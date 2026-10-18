public class IntersectionPointOfYLL{
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

  public static void main(String[] args){
    // Intersection means the SAME NODE, not the same value - so these compare references.
    Node[] y1 = makeY(new int[]{4, 1}, new int[]{5, 6, 1}, new int[]{8, 4, 5});
    checkNode("A=[4,1|8,4,5]  B=[5,6,1|8,4,5]", getIntersectionNode(y1[0], y1[1]), y1[2]);
    // ^ both prefixes contain a 1 - a solution comparing VALUES would wrongly stop there

    Node[] y2 = makeY(new int[]{1, 9, 1}, new int[]{3}, new int[]{2, 4});
    checkNode("different lengths  A=[1,9,1|2,4]  B=[3|2,4]", getIntersectionNode(y2[0], y2[1]), y2[2]);

    Node[] y3 = makeY(new int[]{9, 9}, new int[]{}, new int[]{1, 2, 3});
    checkNode("B is entirely the shared tail", getIntersectionNode(y3[0], y3[1]), y3[2]);

    Node[] y4 = makeY(new int[]{}, new int[]{}, new int[]{7, 8});
    checkNode("A and B are the same list", getIntersectionNode(y4[0], y4[1]), y4[2]);

    Node[] y5 = makeY(new int[]{2, 6, 4}, new int[]{1, 5}, new int[]{});
    checkNode("no intersection", getIntersectionNode(y5[0], y5[1]), null);

    Node[] y6 = makeY(new int[]{}, new int[]{1, 2}, new int[]{});
    checkNode("A is empty", getIntersectionNode(y6[0], y6[1]), null);
  }

  public static Node getIntersectionNode(Node headA, Node headB){
    Node temp1 = headA;
    Node temp2 = headB;

    while(temp1 != temp2){
      temp1 = temp1 == null ? headB: temp1.next;
      temp2 = temp2 == null ? headA: temp2.next;
    }

    return temp1;
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

  // Builds two lists sharing a common tail (the "Y" shape).
  // Returns {headA, headB, firstSharedNode}. An empty `common` means they never meet.
  private static Node[] makeY(int[] onlyA, int[] onlyB, int[] common){
    Node shared = common.length == 0 ? null : convertArr2LL(common);
    return new Node[]{attach(onlyA, shared), attach(onlyB, shared), shared};
  }

  // Builds a list from prefix and links its last node to `tail` (which may be null).
  private static Node attach(int[] prefix, Node tail){
    if(prefix.length == 0) return tail;
    Node head = convertArr2LL(prefix);
    Node t = head;
    while(t.next != null) t = t.next;
    t.next = tail;
    return head;
  }

  // Passes only if `got` is the very same node object as `expected`.
  private static void checkNode(String label, Node got, Node expected){
    boolean ok = got == expected;
    String gotStr = got == null ? "null" : "node " + got.data;
    String hint = "";
    if(!ok && got != null && expected != null && got.data == expected.data) hint = ", a DIFFERENT node with the same value";
    System.out.println((ok ? "PASS  " : "FAIL  ") + label + "  ->  " + gotStr
                       + (ok ? "" : "   (expected " + (expected == null ? "null" : "node " + expected.data) + hint + ")"));
  }
}
