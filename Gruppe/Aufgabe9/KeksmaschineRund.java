import java.lang.RuntimeException;

/* maschine die runde kekse baeckt */
public class KeksmaschineRund extends Keksbackmaschine {
  /* vorbedingung: gebeTeig(teig) muss mit einem Teig Objekt aufgerufen worden sein 
     gibt einen neuen keks mit runder form zurueck, der aus dem zuvor
     gesetzten teig gemact ist */
  public Keks backe(){
    if(this.teig == null) throw new RuntimeException();
    return new Keks(new Rund(), teig);
  }
}