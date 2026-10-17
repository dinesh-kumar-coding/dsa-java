public class ReverseDLL {
  static class Node {
    int data;
    Node next;
    Node prev;

    public Node (int data, Node next, Node prev){
      this.data = data;
      this.next = next;
      this.prev = prev;
    }

    public Node (int data){
      this.data = data;
      this.next = null;
      this.prev = null;
    }
  }

  public static void main(String[] args) {
    // toStr() also verifies every prev pointer - reversing a DLL is exactly where those break.
    check("[1,2,3,4]", toStr(reverseDLL(convertArr2DLL(new int[]{1,2,3,4}))), "[4, 3, 2, 1]");
    check("[1,2]", toStr(reverseDLL(convertArr2DLL(new int[]{1,2}))), "[2, 1]");
    check("[1] (single)", toStr(reverseDLL(convertArr2DLL(new int[]{1}))), "[1]");
    check("empty", toStr(reverseDLL(null)), "[]");
  }

  public static Node reverseDLL(Node head){
    if(head == null || head.next == null) return head;
    Node current = head;
    Node back = null;
    while(current != null){
      back = current.prev;
      current.prev = current.next;
      current.next = back;
      current = current.prev;
    }
    return back.prev;
  }

  // ---- test helpers ----

  private static Node convertArr2DLL(int[] arr){
    Node head = new Node(arr[0]);
    Node prev = head;
    for(int i = 1; i < arr.length; i++){
      Node temp = new Node(arr[i], null, prev);
      prev.next = temp;
      prev = temp;
    }
    return head; 
  }

  private static void check(String label, Object got, Object expected){
    boolean ok = String.valueOf(got).equals(String.valueOf(expected));
    System.out.println((ok ? "PASS  " : "FAIL  ") + label + "  ->  " + got
                       + (ok ? "" : "   (expected " + expected + ")"));
  }

  // Prints the list forward AND checks every prev pointer on the way.
  // A DLL can print perfectly forward while its prev links are broken - this catches that.
  private static String toStr(Node head){
    StringBuilder sb = new StringBuilder("[");
    Node expectedPrev = null;
    String brokenAt = null;
    for(Node t = head; t != null; t = t.next){
      if(t.prev != expectedPrev && brokenAt == null) brokenAt = String.valueOf(t.data);
      sb.append(t.data);
      if(t.next != null) sb.append(", ");
      expectedPrev = t;
    }
    sb.append("]");
    if(brokenAt != null) sb.append("  !! broken prev link at ").append(brokenAt);
    return sb.toString();
  }
}
