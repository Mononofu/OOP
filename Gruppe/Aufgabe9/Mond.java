public class Mond extends Form {
  /* liefert eine KeksmaschineMond */
  public Keksbackmaschine getMaschine(){
  	return  new KeksmaschineMond();
  }

  /* beschreibt die form */
  @Override public String toString(){
  	return "Mond";
  }
}