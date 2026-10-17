public class ReverseLL {
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
    check("iterative [1,2,3,4,5]", toStr(reverseList_iterative(convertArr2LL(new int[]{1,2,3,4,5}))), "[5, 4, 3, 2, 1]");
    check("recursive [1,2,3,4,5]", toStr(reverseList_recursive(convertArr2LL(new int[]{1,2,3,4,5}))), "[5, 4, 3, 2, 1]");
    check("iterative [1,2]", toStr(reverseList_iterative(convertArr2LL(new int[]{1,2}))), "[2, 1]");
    check("recursive [1,2]", toStr(reverseList_recursive(convertArr2LL(new int[]{1,2}))), "[2, 1]");
    check("iterative [1]", toStr(reverseList_iterative(convertArr2LL(new int[]{1}))), "[1]");
    check("recursive [1]", toStr(reverseList_recursive(convertArr2LL(new int[]{1}))), "[1]");
    check("iterative (empty)", toStr(reverseList_iterative(null)), "[]");
    check("recursive (empty)", toStr(reverseList_recursive(null)), "[]");
  }

  public static Node reverseList_iterative(Node head){
    Node current = head;
    Node prev = null;
    while(current != null){
      Node front = current.next;
      current.next = prev;
      prev = current;
      current = front;
    }
    return prev;
  }

  public static Node reverseList_recursive(Node head){
    if(head == null || head.next == null) return head;
    Node newHead = reverseList_recursive(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
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

  private static String toStr(Node head){
    StringBuilder sb = new StringBuilder("[");
    for(Node t = head; t != null; t = t.next){
      sb.append(t.data);
      if(t.next != null) sb.append(", ");
    }
    return sb.append("]").toString();
  }
}
