import java.lang.RuntimeException;

/* maschine die mond kekse baeckt */
public class KeksmaschineMond extends Keksbackmaschine{
  /* vorbedingung: gebeTeig(teig) muss mit einem Teig Objekt aufgerufen worden sein 
     gibt einen neuen keks mit mond form zurueck, der aus dem zuvor
     gesetzten teig gemact ist */
  public Keks backe(){
    if(this.teig == null) throw new RuntimeException();
    return new Keks(new Mond(), teig);
  }
}