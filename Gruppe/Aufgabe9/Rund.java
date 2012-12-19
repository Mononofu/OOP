public class Rund extends Form {

  /* liefert eine KeksmaschineRund */
  public Keksbackmaschine getMaschine(){
  	return  new KeksmaschineRund();
  }

  /* beschreibt die form */
  @Override public String toString(){
  	return "Rund";
  }

  /* alle runde Formen sind gleich */
  @Override public boolean equals(Object o) {
    return o instanceof Rund;
  }

  /* alle runde Formen sind gleich */
  @Override public int hashCode() {
    return 6;
  }
}