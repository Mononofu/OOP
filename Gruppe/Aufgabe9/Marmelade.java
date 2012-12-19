/* marmeladenfuellung */
public class Marmelade implements Fuellung {
  /* beschreibt die fuellung */
  public String toString(){ return "Marmelade"; }


  /* alle Marmeladen sind gleich */
  @Override public boolean equals(Object o) {
    return o instanceof Marmelade;
  }

  /* alle Marmeladen sind gleich */
  @Override public int hashCode() {
    return 3;
  }
}