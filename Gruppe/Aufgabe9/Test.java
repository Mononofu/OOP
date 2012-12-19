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



    Bestellung b2 = new Bestellung();
    b2.addKeks(20,
        new Keks(new Weihnachtsmann(), new Schokoladenteig()));
    b2.addKeks(13,
        new Keks(new Rund(), new Zimtsternteig()));
    b2.addKeks(8,
        new Doppelkeks(new Rund(), new Zimtsternteig(), new Schokolade()));
    System.out.println(b2.drucke());
    Keksdose d2 = baeckerei.abgebeBestellung(b2);
    System.out.println(d2.inhalt());



    Bestellung b3 = new Bestellung();
    b3.addKeks(31,
        new Doppelkeks(new Mond(), new Muerbteig(), new Marmelade()));
    b3.addKeks(20,
        new Keks(new Rund(), new Zimtsternteig()));
    b3.addKeks(33,
        new Keks(new Weihnachtsmann(), new Zimtsternteig()));
    b3.addKeks(22,
        new Keks(new Weihnachtsmann(), new Zimtsternteig()));
    System.out.println(b3.drucke());
    Keksdose d3 = baeckerei.abgebeBestellung(b3);
    System.out.println(d3.inhalt());
  }
}
