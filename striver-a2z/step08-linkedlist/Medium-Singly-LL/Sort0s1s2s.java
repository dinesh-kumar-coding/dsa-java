public class Sort0s1s2s {
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
    // Your method is named sortList, but it's the 0s/1s/2s problem (Dutch flag on a list),
    // not LeetCode 148 "Sort List" - hence the file name.
    check("[1,0,2,1,0,2]", toStr(sortList(convertArr2LL(new int[]{1,0,2,1,0,2}))), "[0, 0, 1, 1, 2, 2]");
    check("[2,2,1] (no 0s)", toStr(sortList(convertArr2LL(new int[]{2,2,1}))), "[1, 2, 2]");
    check("[2,0] (no 1s)", toStr(sortList(convertArr2LL(new int[]{2,0}))), "[0, 2]");
    check("[1,1] (only 1s)", toStr(sortList(convertArr2LL(new int[]{1,1}))), "[1, 1]");
    check("[1] (single)", toStr(sortList(convertArr2LL(new int[]{1}))), "[1]");
    check("empty", toStr(sortList(null)), "[]");
  }

  public static Node sortList(Node head) {
    Node dummy0 = new Node(-1);
    Node zero = dummy0;
    Node dummy1 = new Node(-1);
    Node one = dummy1;
    Node dummy2 = new Node(-1);
    Node two = dummy2;

    Node temp = head;
    while (temp != null) {
      if (temp.data == 0) {
        zero.next = temp;
        zero = temp;
      } else if (temp.data == 1) {
        one.next = temp;
        one = temp;
      } else {
        two.next = temp;
        two = temp;
      }
      temp = temp.next;
    }

    zero.next = dummy1.next != null ? dummy1.next : dummy2.next;
    one.next = dummy2.next;
    two.next = null;

    return dummy0.next;
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
