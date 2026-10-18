public class DetectLoop {
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
    check("no loop", hasCycle(makeLoop(arr, -1)), false);
    check("tail -> node 3", hasCycle(makeLoop(arr, 2)), true);
    check("tail -> head (whole list is the loop)", hasCycle(makeLoop(arr, 0)), true);
    check("tail -> itself (self loop)", hasCycle(makeLoop(arr, 4)), true);
    check("single node, no loop", hasCycle(makeLoop(new int[]{1}, -1)), false);
    check("single node pointing to itself", hasCycle(makeLoop(new int[]{1}, 0)), true);
    check("two nodes, 2 -> 1", hasCycle(makeLoop(new int[]{1, 2}, 0)), true);
    check("empty list", hasCycle(null), false);
  }

  public static boolean hasCycle(Node head){
    Node slow = head;
    Node fast = head;

    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast){
        return true;
      }
    }
    
    return false;
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

  // Builds a list from arr, then links the tail back to the node at index pos.
  // pos = -1 means no loop.
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

  private static void check(String label, Object got, Object expected){
    boolean ok = String.valueOf(got).equals(String.valueOf(expected));
    System.out.println((ok ? "PASS  " : "FAIL  ") + label + "  ->  " + got + (ok ? "" : "   (expected " + expected + ")"));
  }
}
