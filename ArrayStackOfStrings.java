public class ArrayStackOfStrings{
  private String[] s;
  private int N = 0;

  public ArrayStackOfStrings(){
    s = new String[1];
  }

  public boolean isEmpty(){
    return N == 0;
  }

  public void push(String item){
    if(N == s.length)
      resize(2 * N);
    s[N++] = item;
  }

  public String pop(){
    String item = s[--N];
    s[N] = null;
    if(N > 0 && N == s.length/4)
      resize(s.length/2);
    return item;
  }

  private void resize(int n){
    String[] s1 = new String[n];
    for(int i = 0; i < N; i++)
      s1[i] = s[i];
    s = s1;
  }

  public static void main(String[] args) {
    ArrayStackOfStrings s1 = new ArrayStackOfStrings();
    while(!StdIn.isEmpty()){
      String s = StdIn.readString();
      if(s.equals("-"))
        StdOut.print(s1.pop() + ' ');
      else
        s1.push(s);
    }
  }
}
