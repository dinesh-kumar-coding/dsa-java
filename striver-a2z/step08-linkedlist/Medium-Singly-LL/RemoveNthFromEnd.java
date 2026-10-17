public class RemoveNthFromEnd {
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
    check("[1,2,3,4,5] n=2", toStr(removeNthNodeFromEnd(convertArr2LL(new int[]{1,2,3,4,5}), 2)), "[1, 2, 3, 5]");
    check("[1,2] n=1 (tail)", toStr(removeNthNodeFromEnd(convertArr2LL(new int[]{1,2}), 1)), "[1]");
    check("[1,2] n=2 (head - your fast==null branch)", toStr(removeNthNodeFromEnd(convertArr2LL(new int[]{1,2}), 2)), "[2]");
    check("[1] n=1 (only node)", toStr(removeNthNodeFromEnd(convertArr2LL(new int[]{1}), 1)), "[]");
  }

  public static Node removeNthNodeFromEnd(Node head, int n) {
    Node fast = head;
    Node slow = head;

    for (int i = 0; i < n; i++){
      fast = fast.next;
    } 

    if (fast == null) return head.next;
    
    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
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
