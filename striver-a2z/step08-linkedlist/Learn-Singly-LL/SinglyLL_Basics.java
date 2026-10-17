public class SinglyLL_Basics {
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
    int[] arr = {12, 5, 8, 7};

    System.out.println("--- Build + traverse ---");
    Node head = convertArr2LL(arr);
    check("convertArr2LL", toStr(head), "[12, 5, 8, 7]");
    check("lengthOfLL", lengthOfLL(head), 4);
    check("lengthOfLL (empty)", lengthOfLL(null), 0);
    check("checkIfPresent 8", checkIfPresent(head, 8), true);
    check("checkIfPresent 99", checkIfPresent(head, 99), false);

    System.out.println();
    System.out.println("--- Delete ---");
    check("removeHead", toStr(removeHead(convertArr2LL(arr))), "[5, 8, 7]");
    check("removeHead (single node)", toStr(removeHead(new Node(1))), "[]");
    check("removeTail", toStr(removeTail(convertArr2LL(arr))), "[12, 5, 8]");
    check("removeTail (single node)", toStr(removeTail(new Node(1))), "[]");
    check("removeKthNode k=1 (head)", toStr(removeKthNode(convertArr2LL(arr), 1)), "[5, 8, 7]");
    check("removeKthNode k=3", toStr(removeKthNode(convertArr2LL(arr), 3)), "[12, 5, 7]");
    check("removeKthNode k=4 (tail)", toStr(removeKthNode(convertArr2LL(arr), 4)), "[12, 5, 8]");
    check("removeKthNode k=9 (past end)", toStr(removeKthNode(convertArr2LL(arr), 9)), "[12, 5, 8, 7]");
    check("removeNodeWithDataEl 8", toStr(removeNodeWithDataEl(convertArr2LL(arr), 8)), "[12, 5, 7]");
    check("removeNodeWithDataEl 12 (head)", toStr(removeNodeWithDataEl(convertArr2LL(arr), 12)), "[5, 8, 7]");
    check("removeNodeWithDataEl 99 (absent)", toStr(removeNodeWithDataEl(convertArr2LL(arr), 99)), "[12, 5, 8, 7]");

    System.out.println();
    System.out.println("--- Insert ---");
    check("insertBeforeHead", toStr(insertBeforeHead(convertArr2LL(arr), 100)), "[100, 12, 5, 8, 7]");
    check("insertAfterTail", toStr(insertAfterTail(convertArr2LL(arr), 100)), "[12, 5, 8, 7, 100]");
    check("insertAfterTail (empty list)", toStr(insertAfterTail(null, 100)), "[100]");
    check("insertAtKthPosition k=1", toStr(insertAtKthPosition(convertArr2LL(arr), 100, 1)), "[100, 12, 5, 8, 7]");
    check("insertAtKthPosition k=3", toStr(insertAtKthPosition(convertArr2LL(arr), 100, 3)), "[12, 5, 100, 8, 7]");
    check("insertAtKthPosition k=5 (end)", toStr(insertAtKthPosition(convertArr2LL(arr), 100, 5)), "[12, 5, 8, 7, 100]");
    check("insertBeforeEl 8", toStr(insertBeforeEl(convertArr2LL(arr), 100, 8)), "[12, 5, 100, 8, 7]");
    check("insertBeforeEl 12 (head)", toStr(insertBeforeEl(convertArr2LL(arr), 100, 12)), "[100, 12, 5, 8, 7]");

    System.out.println();
    System.out.println("--- print() ---");
    print(convertArr2LL(arr));
  }

  public static Node convertArr2LL(int[] arr) {
    Node head = new Node(arr[0]);
    Node mover = head;
    for (int i = 1; i < arr.length; i++) {
      Node temp = new Node(arr[i]);
      mover.next = temp;
      mover = temp;
    }
    return head;
  }

  public static void print(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
  }

  public static int lengthOfLL(Node head) {
    Node temp = head;
    int count = 0;
    while (temp != null) {
      count++;
      temp = temp.next;
    }
    return count;
  }

  public static boolean checkIfPresent(Node head, int val) {
    Node temp = head;
    while (temp != null) {
      if (temp.data == val)
        return true;
      temp = temp.next;
    }
    return false;
  }

  public static Node removeHead(Node head) {
    if (head == null)
      return head;
    head = head.next;
    return head;
  }

  public static Node removeTail(Node head) {
    if (head == null || head.next == null)
      return null;
    Node temp = head;
    while (temp.next.next != null) {
      temp = temp.next;
    }
    temp.next = null;
    return head;
  }

  public static Node removeKthNode(Node head, int k) {
    if (head == null)
      return head;
    if (k == 1) {
      head = head.next;
      return head;
    }
    int count = 0;
    Node temp = head;
    Node prev = null;
    while (temp != null) {
      count++;
      if (count == k) {
        prev.next = prev.next.next;
        break;
      }
      prev = temp;
      temp = temp.next;
    }
    return head;
  }

  public static Node removeNodeWithDataEl(Node head, int el) {
    if (head == null)
      return head;
    if (el == head.data) {
      head = head.next;
      return head;
    }
    Node temp = head;
    Node prev = null;
    while (temp != null) {
      if (el == temp.data) {
        prev.next = prev.next.next;
        break;
      }
      prev = temp;
      temp = temp.next;
    }
    return head;
  }

  public static Node insertBeforeHead(Node head, int val) {
    return new Node(val, head);
  }

  public static Node insertAfterTail(Node head, int val) {
    if (head == null)
      return new Node(val, null);

    Node temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    Node newNode = new Node(val, null);
    temp.next = newNode;
    return head;
  }

  public static Node insertAtKthPosition(Node head, int val, int k) {
    if (k == 1)
      return new Node(val, head);
    int count = 0;
    Node temp = head;
    while (temp != null) {
      count++;
      if (count == k - 1) {
        Node newNode = new Node(val, temp.next);
        temp.next = newNode;
        break;
      }
      temp = temp.next;
    }
    return head;
  }

  public static Node insertBeforeEl(Node head, int val, int el) {
    if (head == null)
      return head;
    if (head.data == el)
      return new Node(val, head);
    Node temp = head;
    while (temp.next != null) {
      if (temp.next.data == el) {
        Node newNode = new Node(val, temp.next);
        temp.next = newNode;
        break;
      }
      temp = temp.next;
    }
    return head;
  }

  // ---- test helpers ----

  private static void check(String label, Object got, Object expected){
    boolean ok = String.valueOf(got).equals(String.valueOf(expected));
    System.out.println((ok ? "PASS  " : "FAIL  ") + label + "  ->  " + got + (ok ? "" : "   (expected " + expected + ")"));
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
