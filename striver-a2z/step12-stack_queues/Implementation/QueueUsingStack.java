import java.util.Stack;

class StackQueue_Approach1{
  Stack<Integer> s1, s2;

  public StackQueue_Approach1(){
    s1 = new Stack<Integer>();
    s2 = new Stack<Integer>();
  }
  
  public void push(int x){
    while(!s1.isEmpty()) s2.push(s1.pop());
    s1.push(x);
    while(!s2.isEmpty()) s1.push(s2.pop());
  }

  public int pop(){
    if(s1.isEmpty()) return -1;
    return s1.pop();
  }

  public int peek(){
    if(s1.isEmpty()) return -1;
    return s1.peek();
  }

  public int size(){
    return s1.size();
  }

  public boolean isEmpty(){
    return s1.isEmpty();
  }
}

class StackQueue_Approach2{
  Stack<Integer> s1, s2;

  public StackQueue_Approach2(){
    s1 = new Stack<Integer>();
    s2 = new Stack<Integer>();
  }
  
  public void push(int x){
    s1.push(x);
  }

  public int pop(){
    if(s2.isEmpty()){
      while(!s1.isEmpty()) s2.push(s1.pop());
    }
    return s2.isEmpty()? -1 : s2.pop();
  }

  public int peek(){
    if(s2.isEmpty()){
      while(!s1.isEmpty()) s2.push(s1.pop());
    }
    return s2.isEmpty()? -1 : s2.peek();
  }

  public int size(){
    return s1.size() + s2.size();
  }

  public boolean isEmpty(){
    return s1.isEmpty() && s2.isEmpty();
  }
}

public class QueueUsingStack {
  public static void main(String[] args) {
    System.out.println("Approach 1");
    StackQueue_Approach1 queue1 = new StackQueue_Approach1();
    queue1.push(10);
    queue1.push(20);
    queue1.push(30);
    System.out.println("Front = " + queue1.peek());
    System.out.println("Size = " + queue1.size());
    System.out.println("Popped " + queue1.pop());
    System.out.println("Front = " + queue1.peek());
    System.out.println("Size = " + queue1.size());
    System.out.println("Is Empty = " + queue1.isEmpty());

    System.out.println("Approach 2");
    StackQueue_Approach2 queue2 = new StackQueue_Approach2();
    queue2.push(10);
    queue2.push(20);
    queue2.push(30);
    System.out.println("Front = " + queue2.peek());
    System.out.println("Size = " + queue2.size());
    System.out.println("Popped " + queue2.pop());
    System.out.println("Front = " + queue2.peek());
    System.out.println("Size = " + queue2.size());
    System.out.println("Is Empty = " + queue2.isEmpty());
  }
}
