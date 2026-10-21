class LLQueue{
  private static class Node{
    int data;
    Node next;

    Node(int data){
      this.data = data;
      next = null;
    }
  }

  private Node frontNode;
  private Node rearNode;
  private int count;

  public LLQueue(){
    frontNode = null;
    rearNode = null;
    count = 0;
  }

  public void push(int value){
    Node newNode = new Node(value);

    if(frontNode == null){
      frontNode = newNode;
      rearNode = newNode;
    } else{
      rearNode.next = newNode;
      rearNode = newNode;
    }
    count++;
  }

  public int pop(){
    if(frontNode == null) return -1;

    Node removedNode = frontNode;
    int removedValue = removedNode.data;

    if(frontNode.next == null){
      frontNode = rearNode = null;
    } else{
      frontNode = frontNode.next;
    }
    count--;

    return removedValue;
  }

  public int peek(){
    if(frontNode == null) return -1;
    return frontNode.data;
  }

  public boolean isEmpty(){
    return frontNode == null;
  }

  public int size(){
    return count;
  }
}

public class QueueUsingLL {
  public static void main(String[] args) {
    LLQueue queue = new LLQueue();

    queue.push(10);
    queue.push(20);
    queue.push(30);
    System.out.println("Front = " + queue.peek());
    System.out.println("Size = " + queue.size());
    System.out.println("Popped " + queue.pop());
    System.out.println("Front = " + queue.peek());
    System.out.println("Size = " + queue.size());
    System.out.println("Is Empty = " + queue.isEmpty());
  }
}