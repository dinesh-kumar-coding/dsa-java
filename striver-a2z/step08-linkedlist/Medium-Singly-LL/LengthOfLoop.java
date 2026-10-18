public class LengthOfLoop {
  static class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    check("tail -> node 3  (loop is 3,4,5)", lengthOfLoop(makeLoop(arr, 2)), 3);
    check("tail -> head    (whole list)", lengthOfLoop(makeLoop(arr, 0)), 5);
    check("tail -> itself  (self loop)", lengthOfLoop(makeLoop(arr, 4)), 1);
    check("no loop", lengthOfLoop(makeLoop(arr, -1)), 0);
  }

  public static int lengthOfLoop(Node head){
    Node slow = head;
    Node fast = head;
    while(fast != null && fast.next != null){
      fast = fast.next.next;
      slow = slow.next;
      if(slow == fast){
        fast = fast.next;
        int length = 1;
        while(fast != slow){
          length++;
          fast = fast.next;
        }
        return length;
      }
    }
    return 0;
  }

  // ---- test helpers ----

  private static Node convertArr2LL(int[] arr) {
    Node head = new Node(arr[0]);
    Node mover = head;
    for (int i = 1; i < arr.length; i++) {
      Node temp = new Node(arr[i]);
      mover.next = temp;
      mover = temp;
    }
    return head;
  }

  private static void check(String label, Object got, Object expected){
    boolean ok = String.valueOf(got).equals(String.valueOf(expected));
    System.out.println((ok ? "PASS  " : "FAIL  ") + label + "  ->  " + got
                       + (ok ? "" : "   (expected " + expected + ")"));
  }

  // Builds a list from arr, then links the tail back to the node at index pos.
  // pos = -1 means no loop. (Never call toStr on a looped list - it would run forever.)
  private static Node makeLoop(int[] arr, int pos){
    Node head = convertArr2LL(arr);
    if(pos < 0) return head;
    Node tail = head, target = null;
    int i = 0;
    for(Node t = head; t != null; t = t.next, i++){
      if(i == pos) target = t;
      tail = t;
    }
    tail.next = target;
    return head;
  }
}
