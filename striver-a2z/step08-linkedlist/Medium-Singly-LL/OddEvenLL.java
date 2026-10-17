public class OddEvenLL {
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
    // Grouping is by POSITION (1st, 3rd, 5th...), not by whether the value is odd.
    // [2,1,3,5,6,4,7] is the test that tells those two apart.
    check("[1,2,3,4,5]", toStr(oddEven(convertArr2LL(new int[]{1,2,3,4,5}))), "[1, 3, 5, 2, 4]");
    check("[2,1,3,5,6,4,7]", toStr(oddEven(convertArr2LL(new int[]{2,1,3,5,6,4,7}))), "[2, 3, 6, 7, 1, 5, 4]");
    check("[1,2] (even length)", toStr(oddEven(convertArr2LL(new int[]{1,2}))), "[1, 2]");
    check("[1] (single)", toStr(oddEven(convertArr2LL(new int[]{1}))), "[1]");
    check("empty", toStr(oddEven(null)), "[]");
  }

  public static Node oddEven(Node head) {
    if (head == null || head.next == null)
      return head;
    Node odd = head;
    Node even = head.next;
    Node evenHead = head.next;
    while (even != null && even.next != null) {
      odd.next = odd.next.next;
      even.next = even.next.next;

      odd = odd.next;
      even = even.next;
    }
    odd.next = evenHead;
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
