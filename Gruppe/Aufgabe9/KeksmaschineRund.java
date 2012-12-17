import java.lang.RuntimeException;

public class KeksmaschineRund extends Keksbackmaschine{
  public Keks backe(){
    if(this.teig == null) throw new RuntimeException();
    return new Keks(new Rund(), teig);
  }
}