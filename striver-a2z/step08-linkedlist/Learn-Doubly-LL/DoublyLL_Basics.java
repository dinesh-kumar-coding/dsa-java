public class DoublyLL_Basics {
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
    int[] arr = {12, 5, 8, 7};
    // toStr() also verifies every prev pointer - a broken one makes the test FAIL.

    System.out.println("--- Build + traverse ---");
    Node head = convertArr2DLL(arr);
    check("convertArr2DLL", toStr(head), "[12, 5, 8, 7]");
    check("lengthOfLL", lengthOfLL(head), 4);
    check("checkIfPresent 8", checkIfPresent(head, 8), true);
    check("checkIfPresent 99", checkIfPresent(head, 99), false);

    System.out.println();
    System.out.println("--- Delete ---");
    check("removeHead", toStr(removeHead(convertArr2DLL(arr))), "[5, 8, 7]");
    check("removeHead (single node)", toStr(removeHead(new Node(1))), "[]");
    check("removeTail", toStr(removeTail(convertArr2DLL(arr))), "[12, 5, 8]");
    check("removeTail (single node)", toStr(removeTail(new Node(1))), "[]");
    check("removeKthNode k=1 (head)", toStr(removeKthNode(convertArr2DLL(arr), 1)), "[5, 8, 7]");
    check("removeKthNode k=3", toStr(removeKthNode(convertArr2DLL(arr), 3)), "[12, 5, 7]");
    check("removeKthNode k=4 (tail)", toStr(removeKthNode(convertArr2DLL(arr), 4)), "[12, 5, 8]");

    Node h1 = convertArr2DLL(arr);
    removeNode(h1.next.next);                 // remove 8, a middle node
    check("removeNode (middle)", toStr(h1), "[12, 5, 7]");
    Node h2 = convertArr2DLL(arr);
    removeNode(h2.next.next.next);            // remove 7, the tail
    check("removeNode (tail)", toStr(h2), "[12, 5, 8]");

    System.out.println();
    System.out.println("--- Insert ---");
    check("insertBeforeHead", toStr(insertBeforeHead(convertArr2DLL(arr), 100)), "[100, 12, 5, 8, 7]");
    check("insertBeforeHead (empty list)", toStr(insertBeforeHead(null, 100)), "[100]");
    check("insertAfterTail", toStr(insertAfterTail(convertArr2DLL(arr), 100)), "[12, 5, 8, 7, 100]");
    check("insertAfterTail (empty list)", toStr(insertAfterTail(null, 100)), "[100]");
    check("insertAtKthPosition k=1", toStr(insertAtKthPosition(convertArr2DLL(arr), 100, 1)), "[100, 12, 5, 8, 7]");
    check("insertAtKthPosition k=1 (empty list)", toStr(insertAtKthPosition(null, 100, 1)), "[100]");
    check("insertAtKthPosition k=3", toStr(insertAtKthPosition(convertArr2DLL(arr), 100, 3)), "[12, 5, 100, 8, 7]");
    check("insertAtKthPosition k=5 (end)", toStr(insertAtKthPosition(convertArr2DLL(arr), 100, 5)), "[12, 5, 8, 7, 100]");

    Node h3 = convertArr2DLL(arr);
    insertBeforeNode(h3.next.next, 100);      // before 8
    check("insertBeforeNode (middle)", toStr(h3), "[12, 5, 100, 8, 7]");
    Node h4 = convertArr2DLL(arr);
    insertBeforeNode(h4.next.next.next, 100); // before 7, the tail
    check("insertBeforeNode (tail)", toStr(h4), "[12, 5, 8, 100, 7]");

    System.out.println();
    System.out.println("--- print() ---");
    print(convertArr2DLL(arr));
  }

  public static Node convertArr2DLL(int[] arr){
    Node head = new Node(arr[0]);
    Node prev = head;
    for(int i = 1; i < arr.length; i++){
      Node temp = new Node(arr[i], null, prev);
      prev.next = temp;
      prev = temp;
    }
    return head; 
  }

  public static void print(Node head){
    Node temp = head;
    while(temp != null){
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
  }

  public static int lengthOfLL(Node head){
    Node temp = head;
    int count = 0;
    while(temp != null){
      count++;
      temp = temp.next;
    }
    return count;
  }

  public static boolean checkIfPresent(Node head, int val){
    Node temp = head;
    while(temp != null){
      if(temp.data == val) return true;
      temp = temp.next;
    }
    return false;
  }

  public static Node removeHead(Node head){
    if(head == null || head.next == null) return null;
    Node prev = head;
    head = head.next;

    prev.next = null;
    head.prev = null;
    return head;
  }

  public static Node removeTail(Node head){
    if(head == null || head.next == null) return null;
    Node tail = head;
    while(tail.next != null){
      tail = tail.next;
    }
    tail.prev.next = null; 
    tail.prev = null;
    return head;
  }

  public static Node removeKthNode(Node head, int k){
    if(head == null) return null;
    if(k == 1){
      Node prev = head;
      head = head.next;

      prev.next = null;
      if(head != null){
        head.prev = null;
      }
      return head;
    }
    int count = 0;
    Node temp = head;
    while(temp != null){
      count++;
      if(count == k){
        temp.prev.next = temp.next;
        if(temp.next != null){
          temp.next.prev = temp.prev;
        }
        temp.prev = temp.next = null;
        break;
      }
      temp = temp.next;
    }
    return head;
  }

  public static void removeNode(Node node){
    Node back = node.prev;
    Node front = node.next;

    if(front == null){
      back.next = null;
      node.prev = null;
      return;
    }

    back.next = front;
    front.prev = back;

    node.next = node.prev = null;
    return;
  }

  public static Node insertBeforeHead(Node head, int val){
    if(head == null) return new Node(val);
    Node newHead = new Node(val, head, null);
    head.prev = newHead;
    return newHead;
  }

  public static Node insertAfterTail(Node head, int val){
    if(head == null) return new Node(val);

    Node tail = head;
    while(tail.next != null){
      tail = tail.next;
    }
    Node newNode = new Node(val, null, tail);
    tail.next = newNode;
    return head;
  }

  public static Node insertAtKthPosition(Node head, int val, int k){
    if(k == 1) return insertBeforeHead(head, val);
    int count = 0;
    Node temp = head;
    while(temp != null){
      count++;
      if(count == k - 1){
        Node newNode = new Node(val, temp.next, temp);
        if(temp.next != null){
          temp.next.prev = newNode; 
        }
        temp.next = newNode;
        break;
      }
      temp = temp.next;
    }
    return head;
  }

  public static void insertBeforeNode(Node node, int val){
    Node back = node.prev;
    Node newNode = new Node(val, node, back);
    if(back != null){
      back.next = newNode;
    }
    node.prev = newNode;
  }

  // ---- test helpers ----

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
