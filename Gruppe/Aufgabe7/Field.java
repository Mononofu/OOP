import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Semaphore;
import java.util.Collections;

public class Field {
  private final Cell field[][];
  private final ArrayList<Car> cars = new ArrayList<Car>();
  private final Random r = new Random();
  private final int w;
  private final int h;
  private final CountDownLatch latch = new CountDownLatch(1);
  private final Semaphore notificationLock = new Semaphore(1);
  private boolean raceRunning = false;

  /*capsuled class to give a car access to a single cell of the field*/
  private class CellAccessorImpl implements CellAccessor {
    public Cell getCell(Position p) {
      return field[p.w][p.h];
    }
  }

  /*capsuled class to be accessed by a car in case it won or is out of moves
  prints either of the 2 ways to end the race and ends the race
  the notificationlock semaphore is locked in the meantime*/
  private class TerminationListenerImpl implements TerminationListener {
    public void notifyVictory(Car c) {
      notificationLock.acquireUninterruptibly();
      if(raceRunning) {
        System.out.println("The race was won by " + c.getDescription());
        raceOver();
      }
      notificationLock.release();
    }

    public void notifyOutOfMoves(Car c) {
      notificationLock.acquireUninterruptibly();
      if(raceRunning) {
        System.out.println("Car is out of moves: " + c.getDescription());
        raceOver();
      }
      notificationLock.release();
    }
  }

  /*creates a rectangular field of empty cells with the 
  parameters given */
  public Field(int w, int h) {
    this.w = w;
    this.h = h;

    this.field = new Cell[w][h];
    for(int i = 0; i < w; i++)
      for(int j = 0; j < h; j++)
        this.field[i][j] = new Cell();
  }

  /*sets raceRunning to false which will terminate 
  the race once its been checked for*/
  private void raceOver() {
    if(raceRunning) {
      Debug.info("End of race");
      raceRunning = false;

      for(Car car : cars)
        car.end();

      latch.countDown();
      Debug.info("done");
    }
  }

  /*prints the stats as well as the field at the end of the race*/
  public void printStats() {
    /* wait for all cars to terminate */
    try {
      for(Car car : cars)
        car.await();
    } catch (java.lang.InterruptedException ex) {
      System.err.println("should never happen");
    }

    System.out.println("==== Leaderboard");
    Collections.sort(this.cars);
    for(Car c : cars)
      System.out.println(c.getDescription());

    System.out.println("");

    System.out.println("==== Final field");
    System.out.println(this.toString());
  }

  /*adds a new car to this field
  chooses a random empty cell and a random alignment*/
  public void add(Car c) {
    c.setCellAccessor(new CellAccessorImpl());
    c.setTerminationListener(new TerminationListenerImpl());

    int tempW, tempH;
    do {
      tempW = r.nextInt(w);
      tempH = r.nextInt(h);
    } while(this.field[tempW][tempH].hasCar());
    c.setInitialPosition(tempW, tempH, Helpers.rotateLeft(AbsoluteDirection.N, 2*r.nextInt(4)));

    c.setDimension(w, h);
    cars.add(c);
  }

  /* starts the race
  starts each car and the waits 10 seconds
  waiting for 1 car to end the race
  else ends it itself without a winner*/
  public void runWithMaxDuration(int seconds) {
    this.raceRunning = true;
    Debug.info(this.toString());

    for(Car c : cars)
      c.start();

    for(int i = 0; i < 40 * seconds; i++) {
      try {
        if(latch.await(25, TimeUnit.MILLISECONDS)) {
          Debug.info("race over, print stats");
          printStats();
          return;
        } else {
          Debug.info("waiting");
          /* race still ongoing, continue to wait */
        }
      } catch (InterruptedException e) {
        /* somebody won the race */
        Debug.error("main thread shouldn't be interruped!");
      }
      Debug.info(this.toString());
    }

    Debug.info("over");

    for(Car c : cars)
      c.end();

    System.out.println("The race ended without a winner.");
    printStats();
  }

  /*locks and prints the current field 
  afterwards unlocks it again
  synchronized not to try to lock cells locked by another toString*/
  @Override public synchronized String toString() {
    lockAll();
    String out = "";

    for(int j = 0; j < h; j++) {
      for(int i = 0; i < w; i++) {
        out += this.field[i][j].toString();
      }
      out += "\n";
    }

    releaseAll();
    return out;
  }

  /*locks all cells*/
  private void lockAll() {
    Debug.info("try to lock all");
    for(int i = 0; i < w; i++)
      for(int j = 0; j < h; j++)
        while(!this.field[i][j].tryAcquire()) {
          try { Thread.sleep(100); } catch (Exception ex) { }
          Debug.info(i + ":" + j + ", " + this.field[i][j].getDescription());
        }
    Debug.info("locked all");
  }

  /*realeases all cells*/
  private void releaseAll() {
    for(int i = 0; i < w; i++)
      for(int j = 0; j < h; j++)
        this.field[i][j].release();
  }

}
