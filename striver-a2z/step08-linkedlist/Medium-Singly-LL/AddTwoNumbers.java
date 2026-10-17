public class AddTwoNumbers {
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
    // Digits are stored in REVERSE order: [2,4,3] means 342.
    check("342 + 465 = 807", toStr(addTwoNumbers(convertArr2LL(new int[]{2,4,3}), convertArr2LL(new int[]{5,6,4}))), "[7, 0, 8]");
    check("9999 + 99 = 10098 (unequal lengths)", toStr(addTwoNumbers(convertArr2LL(new int[]{9,9,9,9}), convertArr2LL(new int[]{9,9}))), "[8, 9, 0, 0, 1]");
    check("5 + 5 = 10 (final carry adds a node)", toStr(addTwoNumbers(convertArr2LL(new int[]{5}), convertArr2LL(new int[]{5}))), "[0, 1]");
    check("0 + 0 = 0", toStr(addTwoNumbers(convertArr2LL(new int[]{0}), convertArr2LL(new int[]{0}))), "[0]");
  }

  public static Node addTwoNumbers(Node head1, Node head2) {
    Node dummyNode = new Node(-1);
    Node current = dummyNode;
    Node temp1 = head1;
    Node temp2 = head2;
    int carry = 0;
    while (temp1 != null || temp2 != null) {
      int sum = carry;
      if (temp1 != null)
        sum += temp1.data;
      if (temp2 != null)
        sum += temp2.data;

      Node newNode = new Node(sum % 10);
      carry = sum / 10;

      current.next = newNode;
      current = current.next;

      if (temp1 != null)
        temp1 = temp1.next;
      if (temp2 != null)
        temp2 = temp2.next;
    }
    if (carry != 0) {
      Node newNode = new Node(carry);
      current.next = newNode;
    }
    return dummyNode.next;
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
