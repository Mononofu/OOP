import java.util.ArrayList;
import java.util.List;

/* baeckerei die bestellte kekse baeckt und keksdosen damit befuellt */
public class Baeckerei{
  private final List<Bestellung> bestellungen;

  /* neue baeckerei */
  public Baeckerei(){
    this.bestellungen = new ArrayList<Bestellung>();
  }

  /* setzt neue bestellung ab und gibt die entsprechend befuellte keksdose zurueck */
  public Keksdose abgebeBestellung (Bestellung b){
    Keksdose dose = new Keksdose();

    bestellungen.add(b);

    for(KeksPosten kp : b) {
      Keks k = kp.typ;
      Keksmaschine maschine = null;

      if(k instanceof Doppelkeks) {
        maschine = new Doppelkeksmaschine()
            .gebeKeks(k)
            .gebeFuellung(((Doppelkeks) k).getFuellung());
      } else {
        maschine = k.getForm().getMaschine()
            .gebeTeig(k.getTeig());
      }

      for(int i = 0; i < kp.anzahl; i++) {
        dose.addKeks(maschine.backe());
      }
    }

    return dose;
  }
}
