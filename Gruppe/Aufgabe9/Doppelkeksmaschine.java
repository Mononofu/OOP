import java.lang.RuntimeException;

/* maschine die doppelkekse mit einem bestimmten teig baeckt */
public class Doppelkeksmaschine implements Keksmaschine{
  private Keks k;
  private Fuellung f;

  /* neue Doppelkeksmaschine */
  public Doppelkeksmaschine(){
    this.k = null;
  }

  /* setze den fuer den boden / deckel zu verwendenden keks
     gibt this zurueck um aufrufe verkettbar zu machen */
  public Doppelkeksmaschine gebeKeks(Keks ks){
    this.k = new Keks(ks);
    return this;
  }

  /* setze die fuellung 
     gibt this zurueck um aufrufe verkettbar zu machen */
  public Doppelkeksmaschine gebeFuellung(Fuellung f){
    this.f = f;
    return this;
  }

  /* vorbedingung: gebeKeks(k) und gebeFuellung(f) muessen mit nicht null werten
        aufgerufen worden sein
     gibt einen neuen doppelkeks zurueck, der mit den zuvor gesetzten keksen und 
     fuellung gebacken wird */
  public Keks backe(){
    if(k == null) throw new RuntimeException();
    if(f == null) throw new RuntimeException();
    return new Doppelkeks(k.getForm(), k.getTeig(), f);
  }

}