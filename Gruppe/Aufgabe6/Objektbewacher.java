public class Objektbewacher extends Beschuetzer {
  public Objektbewacher(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public void accept(Inspector visitor) {
    visitor.visit(this);
  }
}
