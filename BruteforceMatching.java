public class BruteforceMatching {
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
        return i;
    }
    return N;
  }

  //an alternative approach
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
    int n1, n2;
    n1 = search("zhangl", "zhanglimian");
    n2 = search2("zhangli", "zhanglimian");
    StdOut.printf("n1: %d, n2: %d", n1, n2);
  }
}
