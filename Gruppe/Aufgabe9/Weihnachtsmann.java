public class Weihnachtsmann extends Form {

  public Weihnachtsmann(){}

  public Keksbackmaschine getMaschine(){
  	return new KeksmaschineWeihnachtsmann();
  }

  @Override
  public String toString(){
  	return "Weihnachtsmann";
  }

}