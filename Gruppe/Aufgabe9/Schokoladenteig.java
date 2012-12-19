public class Schokoladenteig implements Teig {
  @Override public String toString() {
  	return "Schokoladenteig";
  }

  /* alle Schokoteige sind gleich */
  @Override public boolean equals(Object o) {
    return o instanceof Schokoladenteig;
  }

  /* alle Schokoteige sind gleich */
  @Override public int hashCode() {
    return 1;
  }
}