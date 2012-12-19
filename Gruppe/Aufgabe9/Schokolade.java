/* schoko fuellung */
public class Schokolade implements Fuellung {
  /* beschreibt die Fuellung */
  public String toString(){ return "Schokolade"; }

  /* jede Schokolade ist gleich */
  @Override public boolean equals(Object o) {
    return o instanceof Schokolade;
  }

  /* jede Schokolade ist gleich */
  @Override public int hashCode() {
    return 7;
  }
}