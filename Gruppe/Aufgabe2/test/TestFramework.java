package test;

import java.lang.reflect.Method;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class TestFramework {
  // coloring might not work on windows
  // but then, why would you use windows?
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  static void printSuccess(String name) {
    System.out.println(ANSI_GREEN + "  - " + name + " sucessful" + ANSI_RESET);
  }

  static void printFailure(String name, String cause) {
    System.out.println(ANSI_RED + "  - " + name + " failed: " + cause + ANSI_RESET);
  }

  public static String getLocation(Throwable t, int depth) {
    StackTraceElement l = t.getStackTrace()[depth];
    return "line "+l.getLineNumber();
  }

  public static void runTests(List<Class<? extends AbstractTest>> cs) {
    int failed_tests = 0;
    int total_tests = 0;

    for(Class<? extends AbstractTest> cls : cs) {
      try {
        Object o = cls.newInstance();
        System.out.println("Testing " + cls.getName());

        // run all setup methods
        for(Method m : cls.getDeclaredMethods())
          if(m.isAnnotationPresent(BeforeClass.class))
            m.invoke(o);
        
        // run all test methods
        for(Method m : cls.getDeclaredMethods()) {
          if(m.isAnnotationPresent(UnitTest.class)) {
            total_tests += 1;
            // method declared as unittest
            try {
              m.invoke(o);
              if(m.isAnnotationPresent(AssertThrows.class)) {
                printFailure(m.getName(), "excpected Exception wasn't thrown: " +
                  m.getAnnotation(AssertThrows.class).exception());
              } else {
                printSuccess(m.getName());
              }
            } catch(InvocationTargetException e) {
              if(e.getCause() instanceof test.AssertException) {
                printFailure(m.getName(), e.getCause().getMessage()+ 
                    " @ " + getLocation(e.getCause(), 1));
                failed_tests += 1;
              } else {
                // methods just threw an exception that wasn't from assert
                // check if that was to be excpected
                if(m.isAnnotationPresent(AssertThrows.class) &&
                  m.getAnnotation(AssertThrows.class).exception().equals(e.getCause().getClass())) {
                  printSuccess(m.getName());
                } else {
                  failed_tests += 1;
                  printFailure(m.getName(), 
                    "unexpected Exception: ");
                  e.getCause().printStackTrace();
                }
              }
            } 
          }
        }
      } catch(Exception e) {
        System.out.println("failed to run tests for class " + cls.getName());
        e.printStackTrace();
      }
    }

    if(failed_tests == 0) {
      System.out.println();
      System.out.println(ANSI_GREEN + "all tests sucessful!" + ANSI_RESET);
    } else {
      System.out.println();
      System.out.println(ANSI_RED + 
        String.format("%d / %d failed!", failed_tests, total_tests) + 
        ANSI_RESET);
      System.exit(1);
    }
  }
}