public class Rund extends Form {

  /* liefert eine KeksmaschineRund */
  public Keksbackmaschine getMaschine(){
  	return  new KeksmaschineRund();
  }

  /* beschreibt die form */
  @Override public String toString(){
  	return "Rund";
  }
}