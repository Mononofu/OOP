import java.util.Map;
import java.util.HashMap;

/* keksdose, die eine menge von verschiedenen keksen enthaelt */
public class Keksdose{
  private final HashMap<Keks, Integer> kekse;

  /* erstellt eine leere keksdose */
  public Keksdose(){
    this.kekse = new HashMap<Keks, Integer>();
  }

  /* legt keks k in die dose */
  public void addKeks(Keks k){
    kekse.put(k, kekse.containsKey(k) ? kekse.get(k) + 1 : 1);
  }


  /* stellt den inhalt als string dar */
  public String inhalt() {
    String out = "Inhalt der Keksdose:\n";
    for(Keks k : kekse.keySet()){
      out += "\t" + kekse.get(k) + "x " + k.toString() + "\n";
    }
    return out;
  }
}
