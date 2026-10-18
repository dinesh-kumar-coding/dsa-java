public class StartingNodeOfLoop {
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
    check("tail -> node 3", dataOf(startingNode(makeLoop(arr, 2))), 3);
    check("tail -> head", dataOf(startingNode(makeLoop(arr, 0))), 1);
    check("tail -> itself", dataOf(startingNode(makeLoop(arr, 4))), 5);
    check("no loop -> null", dataOf(startingNode(makeLoop(arr, -1))), null);
  }

  public static Node startingNode(Node head){
    Node slow = head;
    Node fast = head;
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast){
        slow = head;
        while(fast != slow){
          fast = fast.next;
          slow = slow.next;
        }
        return slow;
      }
    }
    return null;
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

  private static Object dataOf(Node n){
    return n == null ? null : n.data;
  }
}
