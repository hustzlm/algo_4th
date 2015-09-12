import java.util.Iterator;
public class Stack<Item> implements Iterable<Item>{

  private class Node{
    Item item;
    Node next;
  }

  private Node first = null;

  public void push(Item item){
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
  }

  public Item pop(){
    Item item = first.item;
    first = first.next;
    return item;
  }

  boolean isEmpty(){
    return first == null;
  }

  //int size(){}

  public static void main(String[] args) {
    Stack<String> s1 = new Stack<String>();
    while(!StdIn.isEmpty()){
      String s = StdIn.readString();
      if(s.equals("-"))
        StdOut.print(s1.pop() + ' ');
      else
        s1.push(s);
    }

    Stack<Integer> s2 = new Stack<Integer>();
    s2.push(1);
    s2.push(3);
    s2.push(4);
    for (int i : s2)
      StdOut.print(i);
  }

  public Iterator<Item> iterator(){
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item>{
    private Node current = first;

    public boolean hasNext(){
      return current != null;
    }
    public void remove(){}
    public Item next(){
      Item item = current.item;
      current = current.next;
      return item;
    }
  }
}
