import java.util.*;

class ArrayQueue{
  private int[] values;
  private int capacity;
  private int front;
  private int rear;
  private int size;

  public ArrayQueue(int capacity){
    values = new int[capacity];
    this.capacity = capacity;
    front = 0;
    rear = 0;
    size = 0;
  }

  public void push(int value, List<String> output){
    if(size == capacity){
      output.add("Queue Overflow");
      return;
    }
    values[rear] = value;
    rear = (rear + 1) % capacity;
    size = size + 1;
    output.add("Pushed " + value);
  }

  public void pop(List<String> output){
    if(size == 0){
      output.add("Queue Underflow");
      return;
    }

    int removedValue = values[front];
    front = (front + 1) % capacity;
    size = size - 1;
    output.add("Popped " + removedValue);
  }

  public void peek(List<String> output){
    if(size == 0){
      output.add("Queue is Empty");
      return;
    }
    output.add("Front = " + values[front]);
  }

  public boolean isEmpty(){
    return size == 0;
  }

  public int size(){
    return size;
  }
}

public class QueueUsingArrays {
  public static void main(String[] args) {
    List<String> output = new ArrayList<>();
    ArrayQueue queue = new ArrayQueue(4);

    queue.push(10, output);
    queue.push(20, output);
    queue.push(30, output);
    queue.peek(output);
    output.add("Size = " + queue.size());
    queue.pop(output);
    queue.peek(output);
    output.add("Size = " + queue.size());
    output.add("Is Empty = " + queue.isEmpty());

    for(String line : output){
      System.out.println(line);
    }
  }
}