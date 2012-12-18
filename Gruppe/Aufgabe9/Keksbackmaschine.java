/* maschine die kekse mit einem bestimmten teig baeckt */
public abstract class Keksbackmaschine implements Keksmaschine{
  protected Teig teig = null;

  /* setze den von der maschine verwendeten teig
     gibt this zurueck um aufrufe verkettbar zu machen */
  public Keksbackmaschine gebeTeig(Teig t){
    this.teig = t;
    return this;
  }

  /* backe einen neuen keks */
  abstract public Keks backe();
}
