public class Mond extends Form {

  public Mond(){}

  public Keksbackmaschine getMaschine(){
  	return  new KeksmaschineMond();
  }

  @Override
  public String toString(){
  	return "Mond";
  }

}