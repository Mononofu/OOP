public class Mond extends Form {
  /* liefert eine KeksmaschineMond */
  public Keksbackmaschine getMaschine(){
  	return  new KeksmaschineMond();
  }

  /* beschreibt die form */
  @Override public String toString(){
  	return "Mond";
  }

  /* alle Monde sind gleich */
  @Override public boolean equals(Object o) {
    return o instanceof Mond;
  }

  /* alle Monde sind gleich */
  @Override public int hashCode() {
    return 4;
  }
}