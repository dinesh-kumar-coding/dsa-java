public class DeleteMiddle {
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
    check("[1,3,4,7,1,2,6] -> drops 7", toStr(deleteMiddle(convertArr2LL(new int[]{1,3,4,7,1,2,6}))), "[1, 3, 4, 1, 2, 6]");
    check("[1,2,3,4]       -> drops 3", toStr(deleteMiddle(convertArr2LL(new int[]{1,2,3,4}))), "[1, 2, 4]");
    check("[2,1]           -> drops 1", toStr(deleteMiddle(convertArr2LL(new int[]{2,1}))), "[2]");
    check("[1]             -> empty", toStr(deleteMiddle(convertArr2LL(new int[]{1}))), "[]");
  }

  public static Node deleteMiddle(Node head) {
    if (head == null || head.next == null)
      return null;
    Node slow = head;
    Node fast = head.next.next;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;

    return head;
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
