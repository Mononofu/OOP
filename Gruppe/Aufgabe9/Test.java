public class Test {
  /* teste die erstellten klassen */
  public static void main(String[] args) {
    Bestellung b = new Bestellung();
    Keksbackmaschine kmr = new KeksmaschineRund();
    Keksbackmaschine kmm = new KeksmaschineMond();
    Doppelkeksmaschine dkm = new Doppelkeksmaschine();

    kmr.gebeTeig(new Muerbteig());
    Keks k1 = kmr.backe();
    kmm.gebeTeig(new Schokoladenteig());
    Keks k2 = kmm.backe();
    dkm.gebeKeks(k1);
    dkm.gebeFuellung(new Marmelade());
    Keks k3 = dkm.backe();

    b.addKeks(2,k1);
    b.addKeks(5,k2);
    b.addKeks(100,k3);
    System.out.println(b.drucke());

    Keksdose klaudia = new Keksdose();
    klaudia.addKeks(k1);
    klaudia.addKeks(k2);
    klaudia.addKeks(k2);
    klaudia.addKeks(k3);
    System.out.println(klaudia.inhalt());

    Baeckerei baeckerei = new Baeckerei();
    Keksdose john = baeckerei.abgebeBestellung(b);
    System.out.println(john.inhalt());
  }
}
