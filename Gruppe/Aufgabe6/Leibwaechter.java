import java.util.List;

public class Leibwaechter extends Beschuetzer {
  public Leibwaechter(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public List<Android> accept(Inspector visitor) {
    return visitor.visit(this);
  }
}