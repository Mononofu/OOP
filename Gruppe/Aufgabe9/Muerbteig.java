public class Muerbteig implements Teig {
  /* beschreibt den teig */
  @Override public String toString() {
  	return "Muerbteig";
  }

  /* alle Muerbteige sind gleich */
  @Override public boolean equals(Object o) {
    return o instanceof Muerbteig;
  }

  /* alle Muerbteige sind gleich */
  @Override public int hashCode() {
    return 5;
  }
}