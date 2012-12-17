public class Rund extends Form {

  public Rund(){
  	this.form="Rund";
  }
  public Keksbackmaschine getMaschine(){
  	return  new KeksmaschineRund();
  }
}