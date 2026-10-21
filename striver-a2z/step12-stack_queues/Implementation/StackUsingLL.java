class LLStack{
  private static class Node{
    int data;
    Node next;

    Node(int data, Node next){
      this.data = data;
      this.next = next;
    }
  }

  private Node topNode;
  private int count;

  public LLStack(){
    topNode = null;
    count = 0;
  }

  public void push(int value){
    Node newNode = new Node(value, topNode);

    topNode = newNode;
    count++;
  }

  public int pop(){
    if(topNode == null) return -1;

    Node removedNode = topNode;
    int removedValue = removedNode.data;

    topNode = topNode.next;
    count--;

    return removedValue;
  }

  public int peek(){
    if(topNode == null) return -1;
    return topNode.data;
  }

  public boolean isEmpty(){
    return topNode == null;
  }

  public int size(){
    return count;
  }
}

public class StackUsingLL {
  public static void main(String[] args) {
    LLStack stack = new LLStack();

    stack.push(10);
    stack.push(20);
    stack.push(30);
    System.out.println("Top = " + stack.peek());
    System.out.println("Size = " + stack.size());
    System.out.println("Popped " + stack.pop());
    System.out.println("Top = " + stack.peek());
    System.out.println("Size = " + stack.size());
    System.out.println("Is Empty = " + stack.isEmpty());
  }
}
