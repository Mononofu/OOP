public class Keks{
  protected final Form form;
  protected final Teig teig;

  public Keks(Form f, Teig t){
    this.form = f;
    this.teig = t;
  }

  public Keks(Keks k){
    this.form = k.getForm();
    this.teig = k.getTeig();
  }

  public Teig getTeig(){
    return this.teig;
  }

  public Form getForm(){
    return this.form;
  }

  public String toString(){
    return "Keks " + this.form.toString() + " " + this.teig;
  }

  @Override public boolean equals(Object o) {
    if(o instanceof Keks) {
      Keks that = (Keks) o;
      return this.getTeig().equals(that.getTeig()) && this.getForm().equals(that.getForm());
    } else {
      return false;
    }
  }

  @Override public int hashCode() {
    return this.getTeig().hashCode() + this.getForm().hashCode();
  }
}
