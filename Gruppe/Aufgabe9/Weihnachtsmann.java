/* weihnachtsmann form fuer kekse */
public class Weihnachtsmann extends Form {
  /* liefert KeksmaschineWeihnachtsmann */
  public Keksbackmaschine getMaschine(){
  	return new KeksmaschineWeihnachtsmann();
  }

  /* beschreibt die Form */
  @Override public String toString() {
  	return "Weihnachtsmann";
  }
}