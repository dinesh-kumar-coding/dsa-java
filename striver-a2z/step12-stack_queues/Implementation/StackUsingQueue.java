import java.util.LinkedList;
import java.util.Queue;

class QueueStack{
  Queue<Integer> q;
  int size;

  public QueueStack(){
    q = new LinkedList<>();
    size = 0;
  }

  public void push(int x){
    q.add(x);
    size++;
    for(int i = 1; i < size; i++){
      q.offer(q.poll());
    }
  }

  public int pop(){
    if(size == 0) return -1;
    int removedValue = q.peek();
    q.remove();
    size--;
    return removedValue;
  }

  public int peek(){
    if(size == 0) return -1;
    return q.peek();
  }

  public int size(){
    return size;
  }

  public boolean isEmpty(){
    return size == 0;
  }
}

public class StackUsingQueue {
  public static void main(String[] args) {
    QueueStack stack = new QueueStack();

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
