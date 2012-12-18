public class KeksPosten {
  /* keine accessors notwendig, da die werte immutable sind und nicht erweitert
     werden */
  public final Keks typ;
  public final int anzahl;

  /* erstellt einen neuen Posten fuer eine Bestellung. typ != null und anzahl > 0 */
  public KeksPosten(Keks typ, int anzahl) {
    assert(typ != null);
    assert(anzahl > 0);
    this.typ = typ;
    this.anzahl = anzahl;
  }
}
