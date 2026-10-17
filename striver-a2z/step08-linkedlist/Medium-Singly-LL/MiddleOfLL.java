public class MiddleOfLL {
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
    check("odd length  [1,2,3,4,5]", middleNode(convertArr2LL(new int[]{1,2,3,4,5})).data, 3);
    check("even length [1..6] -> 2nd middle", middleNode(convertArr2LL(new int[]{1,2,3,4,5,6})).data, 4);
    check("two nodes   [1,2]  -> 2nd middle", middleNode(convertArr2LL(new int[]{1,2})).data, 2);
    check("single node [1]", middleNode(convertArr2LL(new int[]{1})).data, 1);
  }

  public static Node middleNode(Node head) {
    Node fast = head;
    Node slow = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
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
}
