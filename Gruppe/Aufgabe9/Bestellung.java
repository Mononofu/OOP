import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

/* eine bestellung mit verschiedenen keksen, mit einem iterator durchlaufbar */
public class Bestellung implements Iterable<KeksPosten> {
  private final HashMap<Keks, Integer> map;

  /* neue leere bestellung */
  public Bestellung(){
    this.map = new HashMap<Keks, Integer>();
  }

  /* fuege n kekse vom typ k hinzu */
  public void addKeks(int n, Keks k){
    map.put(k, map.containsKey(k) ? map.get(k) + n : n);
  }

  /* stelle die bestellung als String dar */
  public String drucke(){
    String out = "Bestellungen:\n";
    for(Keks k : map.keySet()){
      out += "\t" + map.get(k) + "x " + k.toString() + "\n";
    }
    return out;
  }

  /* durchlaufe alle Posten der Bestellung */
  public Iterator<KeksPosten> iterator() {
    ArrayList<KeksPosten> temp = new ArrayList<KeksPosten>();

    for(Keks k : map.keySet()) {
      temp.add(new KeksPosten(k, map.get(k)));
    }

    return temp.iterator();
  }
}
