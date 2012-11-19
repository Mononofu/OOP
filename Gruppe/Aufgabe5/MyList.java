import java.util.NoSuchElementException;
import java.util.ListIterator;

public class MyList<T> implements Iterable<T> {
  private class Elem<T> {
    public final T value;

    public Elem<T> prev = null;
    public Elem<T> next = null;

    public Elem(T value) {
      this.value = value;
    }

    public String toString() {
      return value == null ? "null" : value.toString();
    }
  }

  private class MyIterator implements ListIterator<T> {
    private Elem<T> cur;
    private int curIdx = -1;

    public MyIterator(Elem<T> start) {
      Elem<T> temp = new Elem<T>(null);
      temp.next = start;
      this.cur = temp;
    }

    public boolean hasNext() {
      return cur.next != null;
    }

    public boolean hasPrevious() {
      return cur != null;
    }

    public T next() {
      if(!hasNext())
        throw new NoSuchElementException();

      cur = cur.next;
      curIdx += 1;
      return cur.value;
    }

    public T previous() {
      if(!hasPrevious())
        throw new NoSuchElementException();

      if(this.cur.prev == null) {
        Elem<T> temp = new Elem<T>(null);
        temp.next = cur;
        this.cur = temp;
        first = temp;
      } else {
        this.cur = this.cur.prev;
      }
      curIdx -= 1;
      return cur.value;
    }

    public int nextIndex() {
      return curIdx + 1;
    }

    public int previousIndex() {
      return curIdx - 1;
    }

    public void add(T o) {
      Elem<T> n = new Elem<T>(o);

      if(curIdx < 0 && !hasNext()) {
        /* this means the list is still empty */
        first = n;
        last = n;
        cur = n;
        curIdx = 0;
      } else {
        if(curIdx < 0) {
          /* trying to insert before we have iterated */
          /* cur is still a temporary node */
          first = n;
          n.next = cur.next;
          if(n.next != null)
            n.next.prev = n;
          cur = n;
          curIdx = 0;
        } else {
          /* we have iterated at least once */
          n.next = cur.next;
          n.prev = cur;

          if(!hasNext()) {
            /* we are all the way at the end */
            last = n;
          } else {
            cur.next.prev = n;
          }

          cur.next = n;
          cur = n;
        }
      }

      /*if(n.prev != null)
        System.out.println("before '" + n.prev + "' prev: '" + n.prev.prev + "', next: '" + n.prev.next + "'");
      System.out.println("added '" + o + "' prev: '" + n.prev + "', next: '" + n.next + "'");
      if(n.next != null)
        System.out.println("after '" + n.next + "' prev: '" + n.next.prev + "', next: '" + n.next.next + "'");
      */

      size += 1;
    }

    public void remove() {
      if(curIdx < 0)
        throw new IllegalStateException();

      if(curIdx == 0) {
        if(hasNext())
          first = cur.next;
        else
          first = null;
      }

      if(hasNext()) {
        cur.next.prev = cur.prev;
      } else {
        if(cur.prev == null)
          last = null;
        else
          last = cur.prev;
      }

      if(cur.prev != null)
        cur.prev.next = cur.next;

      size -= 1;
    }

    public void set(T o) {
      Elem<T> n = new Elem<T>(o);
      n.next = cur.next;
      n.prev = cur.prev;

      if(hasNext())
        cur.next.prev = n;

      if(hasPrevious())
        cur.prev.next = n;
    }
  }

  private Elem<T> first = null;
  private Elem<T> last = null;
  private int size = 0;

  public int size() {
    return size;
  }

  public ListIterator<T> iterator() {
    return new MyIterator(first);
  }

  public boolean contains(T value) {
    ListIterator<T> iter = iterator();
    while(iter.hasNext())
      if(iter.next() == value)
        return true;
    return false;
  }

  public void add(T value) {
    Elem<T> e = new Elem<T>(value);

    if(first == null) {
      first = e;
      last = first;
    } else {
      last.next = e;
      e.prev = last;
      last = e;
    }

    size += 1;
  }

  public void add(int index, T value) throws IndexOutOfBoundsException {
    if(index == size) {
      add(value);
    } else if(index < size) {
      ListIterator<T> iter = iterator();
      for(int i = 0; i < index; i++)
        iter.next();
      iter.add(value);
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  public T get(int index) throws IndexOutOfBoundsException {
    if(index >= size)
      throw new IndexOutOfBoundsException();

    Elem<T> cur = first;
    for(int i = 0; i < index; i++)
      cur = cur.next;
    return cur.value;
  }

  public void remove(int index) throws IndexOutOfBoundsException {
    if(index >= size)
      throw new IndexOutOfBoundsException();

    ListIterator<T> iter = iterator();
    iter.next();
    for(int i = 0; i < index; i++)
      iter.next();

    iter.remove();
  }

}

