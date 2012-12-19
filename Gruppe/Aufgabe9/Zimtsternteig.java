public class Zimtsternteig implements Teig {
  @Override public String toString() {
  	return "Zimtsternteig";
  }

  /* alle Zimtsternteig sind gleich */
  @Override public boolean equals(Object o) {
    return o instanceof Zimtsternteig;
  }

  /* alle Zimtsternteig sind gleich */
  @Override public int hashCode() {
    return 8;
  }
}