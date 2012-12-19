/* in a better language: 'case object Schokoladenteig extends Teig' */

public class Schokoladenteig implements Teig {
  @Override public String toString() {
  	return "Schokoladenteig";
  }

  /* alle Schokoteige sind gleich */
  /* this is necessary since in java it's not possible to directly declare objects */
  @Override public boolean equals(Object o) {
    return o instanceof Schokoladenteig;
  }

  /* alle Schokoteige sind gleich */
  @Override public int hashCode() {
    return 1;
  }
}