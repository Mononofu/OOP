public class Weihnachtsmann extends Form {

  public Weihnachtsmann(){
  	this.form="Weihnachtsmann";
  }

  public Keksbackmaschine getMaschine(){
  	return  new KeksmaschineWeihnachtsmann();
  }
}