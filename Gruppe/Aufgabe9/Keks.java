/* keks mit bestimmter form und bestimmtem teig */
public class Keks{
  private final Form form;
  private final Teig teig;

  /* erstellt einen neuen keks mit Form f und Teig t */
  public Keks(Form f, Teig t){
    this.form = f;
    this.teig = t;
  }

  /* kopiere einen Keks k */
  public Keks(Keks k){
    this.form = k.getForm();
    this.teig = k.getTeig();
  }

  /* liefert den teig des kekses */
  public Teig getTeig(){
    return this.teig;
  }

  /* liefert die form des kekses */
  public Form getForm(){
    return this.form;
  }

  /* stellt den keks als string dar */
  public String toString(){
    return "Keks " + this.form.toString() + " " + this.teig;
  }

  /* gleichheit fuer kekse: genau dann gleich, wenn gleicher teig und form */
  @Override public boolean equals(Object o) {
    if(o instanceof Keks) {
      Keks that = (Keks) o;
      return this.getTeig().equals(that.getTeig()) && this.getForm().equals(that.getForm());
    } else {
      return false;
    }
  }

  /* hashcode fuer kekse */
  @Override public int hashCode() {
    return this.getTeig().hashCode() + this.getForm().hashCode();
  }
}
