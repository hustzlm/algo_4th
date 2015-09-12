public class InsertionSort {
  public static void sort(Comparable[] a) {
    int N = a.length;
    for(int i = 1; i < N; i++) {
      for(int j = i; j > 0 && less(a[j], a[j-1]); j--)
        exch(a, j, j-1);
    }
  }

  private static boolean less(Comparable a, Comparable b) {
    return a.compareTo(b) < 0;
  }

  private static void exch(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  private static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++)
      if(less(a[i], a[i-1]))  return false;
    return true;
  }

  private static void show(Comparable[] a){
    for(int i = 0; i < a.length; i++)
      StdOut.print(a[i] + " ");
    StdOut.println();
  }

  public static void main(String[] args){
    String[] a = In.readStrings();
    sort(a);
    assert isSorted(a);
    show(a);

    Date[] b = new Date[4];
    b[0] = new Date(9,3,1994);
    b[1] = new Date(1,1,1993);
    b[2] = new Date(27,12,1993);
    b[3] = new Date(15,8,1995);
    sort(b);
    assert isSorted(b);

    String[] c = new String[4];
    for(int i = 0; i < 4; i++)
      c[i] = b[i].toString();
    show(c);
  }
}
