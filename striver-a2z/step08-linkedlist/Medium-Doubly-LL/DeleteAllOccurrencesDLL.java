public class DeleteAllOccurrencesDLL {
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
    check("[10,4,10,10,6,10] k=10", toStr(removeAllOccurrences(convertArr2DLL(new int[]{10,4,10,10,6,10}), 10)), "[4, 6]");
    check("[1,2,3] k=1 (head)", toStr(removeAllOccurrences(convertArr2DLL(new int[]{1,2,3}), 1)), "[2, 3]");
    check("[1,2,3] k=2 (middle)", toStr(removeAllOccurrences(convertArr2DLL(new int[]{1,2,3}), 2)), "[1, 3]");
    check("[1,2,3] k=3 (tail)", toStr(removeAllOccurrences(convertArr2DLL(new int[]{1,2,3}), 3)), "[1, 2]");
    check("[5,5,5] k=5 (every node)", toStr(removeAllOccurrences(convertArr2DLL(new int[]{5,5,5}), 5)), "[]");
    check("[1,2,3] k=9 (absent)", toStr(removeAllOccurrences(convertArr2DLL(new int[]{1,2,3}), 9)), "[1, 2, 3]");
  }

  public static Node removeAllOccurrences(Node head, int k){
    Node temp = head;
    while(temp != null){
      if(temp.data == k){
        if(temp == head){
          head = head.next;
        }
        if(temp.prev != null){
          temp.prev.next = temp.next;
        }
        if(temp.next != null){
          temp.next.prev = temp.prev;
        }
      }
      temp = temp.next;
    }
    return head;
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
