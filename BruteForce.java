public class BruteForce {

  public static int search(String pat, String txt) {
    int M = pat.length();
    int N = txt.length();
    for (int i = 0; i <= N - M; i ++) {
      int j;
      for(j = 0; j < M; j++) {
        if(txt.charAt(i+j) != pat.charAt(j))
          break;
        }
      if(j == M)
        return i;   //found
    }
    return N;       //not found
  }

  //another approach
  public static int search2(String pat, String txt) {
    int i, j;
    int M = pat.length();
    int N = txt.length();
    for(i = 0, j = 0; i < N && j < M; i ++) {
      if(txt.charAt(i) == pat.charAt(j))
        j++;
      else {
        i -= j;
        j = 0;
      }
    }
    if(j == M)
      return i - M; //found
    else
      return N;     //not found
  }

  public static void main(String[] args) {
    String pat = args[0];
    String txt = args[1];
    int offset = search(pat, txt);
    if(offset == txt.length())
      StdOut.println("not found.");
    else
      StdOut.println("found!");
    StdOut.println("text:    " + txt);
    StdOut.print("pattern: ");
    for(int i = 0; i < offset; i++)
      StdOut.print(" ");
    StdOut.println(pat);
  }
}
