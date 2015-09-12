public class zlmTest {
  public static void main(String[] args) {
    String s = "zhanglimian";
    int hash = 0;
    int M = 97;
    for (int i = 0; i < s.length()  ; i++) {
      hash = (31 * hash + s.charAt(i)) % M;
      StdOut.print(hash);
      StdOut.print(' ');
      StdOut.println((int)(s.charAt(i)));
    }
    // StdOut.println(hash);
  }
}
