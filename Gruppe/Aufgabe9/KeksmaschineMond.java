import java.lang.RuntimeException;

public class KeksmaschineMond extends Keksbackmaschine{
  public Keks backe(){
    if(this.teig == null) throw new RuntimeException();
    return new Keks(new Mond(), teig);
  }
}