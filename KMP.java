public class KMP
{
  private String pat;
  private int[][] dfa;

  public KMP(String pat)
  {
    this.pat = pat;
    int M = pat.length();
    int R = 256;
    dfa = new int[R][M];
    dfa[pat.charAt(0)][0] = 1;
    for(int X = 0, j = 1; j < M; j++)
    {
      for(int c = 0; c < R; c++)
        dfa[c][j] = dfa[c][X];
      dfa[pat.charAt(j)][j] = j+1;
      X = dfa[pat.charAt(j)][X];
    }
  }

  public int search(String txt)
  {
    int i, j;
    int N = txt.length();
    int M = pat.length();
    for(i = 0, j = 0; i<N && j<M; i++)
      j = dfa[txt.charAt(i)][j];
    if(j == M)
      return i-M;     //found
    else
      return N;       //not found
  }

  public static void main(String[] args)
  {
    String pat = args[0];
    String txt = args[1];
    KMP kmp = new KMP(pat);
    int offset = kmp.search(txt);
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