public class CheckPalindrome {
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
    check("[1,2,2,1]   (even)", checkIfPalidrome(convertArr2LL(new int[]{1,2,2,1})), true);
    check("[1,2,3,2,1] (odd)", checkIfPalidrome(convertArr2LL(new int[]{1,2,3,2,1})), true);
    check("[1,2]", checkIfPalidrome(convertArr2LL(new int[]{1,2})), false);
    check("[1,2,3]", checkIfPalidrome(convertArr2LL(new int[]{1,2,3})), false);
    check("[1] (single)", checkIfPalidrome(convertArr2LL(new int[]{1})), true);

    // reverses the second half, compares, then reverses it BACK.
    // These two check the list is left exactly as it was found - in both outcomes.
    Node p = convertArr2LL(new int[]{1,2,3,2,1});
    checkIfPalidrome(p);
    check("list restored after true ", toStr(p), "[1, 2, 3, 2, 1]");
    Node q = convertArr2LL(new int[]{1,2,3,4,5});
    checkIfPalidrome(q);
    check("list restored after false", toStr(q), "[1, 2, 3, 4, 5]");
  }

  public static boolean checkIfPalidrome(Node head){
    if(head == null || head.next == null) return true;
    Node slow = head;
    Node fast = head;
    while(fast.next != null && fast.next.next != null){
      fast = fast.next.next;
      slow = slow.next;
    }

    Node newHead = reverseList_iterative(slow.next);
    Node first = head;
    Node second = newHead;
    while(second != null){
      if(first.data != second.data){
        reverseList_iterative(newHead);
        return false;
      }
      second = second.next;
      first = first.next;
    }
    reverseList_iterative(newHead);
    return true;
  }

  private static Node reverseList_iterative(Node head){
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
