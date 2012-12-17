public class Mond extends Form {

  public Mond(){
  	this.form="Mond";
  }

  public Keksbackmaschine getMaschine(){
  	return  new KeksmaschineMond();
  }

}