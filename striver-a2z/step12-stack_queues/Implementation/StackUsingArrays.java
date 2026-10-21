import java.util.*;

class ArrayStack{
  private int[] values;
  private int capacity;
  private int top;

  public ArrayStack(int capacity){
    values = new int[capacity];
    this.capacity = capacity;
    top = -1;
  }

  public void push(int value, List<String> output){
    if(top == capacity - 1){
      output.add("Stack Overflow");
      return;
    }
    top = top + 1;
    values[top] = value;
    output.add("Pushed " + value);
  }

  public void pop(List<String> output){
    if(top == -1){
      output.add("Stack Underflow");
      return;
    }

    int removedValue = values[top];
    top = top - 1;
    output.add("Popped " + removedValue);
  }

  public void peek(List<String> output){
    if(top == -1){
      output.add("Stack is Empty");
      return;
    }
    output.add("Top = " + values[top]);
  }

  public boolean isEmpty(){
    return top == -1;
  }

  public int size(){
    return top + 1;
  }
}

public class StackUsingArrays {
  public static void main(String[] args) {
    List<String> output = new ArrayList<>();
    ArrayStack stack = new ArrayStack(4);

    stack.push(10, output);
    stack.push(20, output);
    stack.push(30, output);
    stack.peek(output);
    output.add("Size = " + stack.size());
    stack.pop(output);
    stack.peek(output);
    output.add("Size = " + stack.size());
    output.add("Is Empty = " + stack.isEmpty());

    for(String line : output){
      System.out.println(line);
    }
  }
}