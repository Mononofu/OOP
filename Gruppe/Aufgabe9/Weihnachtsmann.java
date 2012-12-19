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

  /* alle Weihnachtsmaenner sind gleich */
  @Override public boolean equals(Object o) {
    return o instanceof Weihnachtsmann;
  }

  /* alle Weihnachtsmaenner sind gleich */
  @Override public int hashCode() {
    return 2;
  }
}