import java.util.Arrays;
import test.TestFramework;
import test.SampleTest;


public class Test extends TestFramework{
  public static void main(String[] args) {
    // add classes that contain tests here
    // for info how to create one, check out EventTest.java and SampleTest.java
    runTests(Arrays.<Class>asList(
      EventTest.class,
      SampleTest.class,
      PlaylistTest.class,
      MemberTest.class
      ) );
  }
}