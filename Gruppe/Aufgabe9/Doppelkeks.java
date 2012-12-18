/* doppelkeks, bestehend aus zwei haelften mit fuellung dazwischen */
public class Doppelkeks extends Keks{
  private final Fuellung fuelle;

  /* erstelle einen neuen doppelkeks mit Form f, Teig t und Fuellung fu */
  public Doppelkeks(Form f, Teig t, Fuellung fu){
    super(f,t);
    this.fuelle = fu;
  }

  /* liefere die fuellung fuer einen keks */
  public Fuellung getFuellung() {
    return fuelle;
  }

  /* beschreibe einen doppelkeks */
  @Override public String toString(){
    return "Doppelkeks " + this.getForm() + " " + this.getTeig() + " " + this.fuelle;
  }

  /* gleichheit fuer doppelkekse: genau dann gleich, wenn gleicher teig, fuellung und form */
  @Override public boolean equals(Object o) {
    if(o instanceof Doppelkeks) {
      Doppelkeks that = (Doppelkeks) o;
      return this.getTeig().equals(that.getTeig()) && this.getFuellung().equals(that.getFuellung()) &&
        this.getForm().equals(that.getForm());
    } else {
      return false;
    }
  }

  /* hashcode fuer kekse */
  @Override public int hashCode() {
    return this.getTeig().hashCode() + this.getFuellung().hashCode() + this.getForm().hashCode();
  }
}
