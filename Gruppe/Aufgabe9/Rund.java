public class Rund extends Form {

  public Rund(){}

  public Keksbackmaschine getMaschine(){
  	return  new KeksmaschineRund();
  }

  @Override
  public String toString(){
  	return "Rund";
  }

}