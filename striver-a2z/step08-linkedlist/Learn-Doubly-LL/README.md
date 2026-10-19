# Step 8 — Learn the doubly linked list

Full notes for every problem in this folder. Status and revisit dates are tracked in [PROGRESS.md](../../../PROGRESS.md).

A doubly linked list is a linked list in which every node also holds a reference to the node before it, called prev. That makes it possible to walk in both directions and to delete a node given only the node itself, at the cost of keeping two references correct on every change.

## Convert an array to a doubly linked list and print it
**File:** [DoublyLL_Basics.java](DoublyLL_Basics.java), methods `convertArr2DLL` and `print`

**Question.** Build a doubly linked list holding the values of an array in the same order, and print it.

**Approach — attach each new node in both directions.** The first value becomes the head. A reference to the last node built so far is kept, and for every remaining value a new node is created whose prev points back at that last node; the last node's next is then pointed forward at the new node. Printing walks from the head following next.

- **Time:** O(N) for both.
- **Extra space:** O(N) for the nodes being created; printing needs O(1).

**Remember:** every new link has two sides. Setting next without setting prev, or the other way round, leaves a list that looks correct in one direction and broken in the other.

## Length of a doubly linked list
**File:** [DoublyLL_Basics.java](DoublyLL_Basics.java), method `lengthOfLL`

**Question.** Count the nodes in a doubly linked list.

**Approach — walk and count.** Exactly as for a singly linked list: walk from the head following next, counting every node.

- **Time:** O(N).
- **Extra space:** O(1).

**Remember:** the prev references make no difference to counting; a forward walk is all that is needed.

## Search for a value in a doubly linked list
**File:** [DoublyLL_Basics.java](DoublyLL_Basics.java), method `checkIfPresent`

**Question.** Decide whether a value is present in a doubly linked list.

**Approach — walk until found.** The method walks from the head comparing each value with the target, returning true at the first match and false at the end.

- **Time:** O(N).
- **Extra space:** O(1).

**Remember:** walking backwards from the tail is possible in a doubly linked list, but it does not make a search faster in the worst case; it only helps when the target is known to be near the end.

## Delete a node from a doubly linked list
**File:** [DoublyLL_Basics.java](DoublyLL_Basics.java), methods `removeHead`, `removeTail`, `removeKthNode` and `removeNode`

**Question.** Delete the head, the tail, the Kth node, or a node that is handed to the method directly.

**Delete the head.** The second node becomes the new head; the old head's next and the new head's prev are both cleared, so the removed node is fully detached. A list with zero or one node becomes empty.

- **Time:** O(1).
- **Extra space:** O(1).

**Delete the tail.** The method walks to the last node, clears the next reference of the node before it, and clears the tail's prev. A list with zero or one node becomes empty.

- **Time:** O(N).
- **Extra space:** O(1).

**Delete the Kth node.** If K is 1, this is deleting the head. Otherwise the method walks to position K and joins the nodes on either side of it: the previous node's next skips forward over it, and, if there is a following node, that node's prev skips back over it.

- **Time:** O(K).
- **Extra space:** O(1).

**Delete a given node.** Because the node knows its own neighbours through prev and next, no walk is needed: the node before it is joined straight to the node after it. If the node is the tail, the node before it simply becomes the new end.

- **Time:** O(1).
- **Extra space:** O(1).

**Remember:** deleting a given node in O(1) is the main thing a doubly linked list gains over a singly linked one. The first and last nodes are each missing one neighbour, so check for that before touching prev or next.

## Insert a node into a doubly linked list
**File:** [DoublyLL_Basics.java](DoublyLL_Basics.java), methods `insertBeforeHead`, `insertAfterTail`, `insertAtKthPosition` and `insertBeforeNode`

**Question.** Insert a new value before the head, after the tail, at position K, or immediately before a node that is handed to the method.

**Insert before the head.** A new node is created whose next is the current head, the current head's prev is pointed back at it, and it becomes the new head. An empty list becomes a single node.

- **Time:** O(1).
- **Extra space:** O(1).

**Insert after the tail.** The method walks to the last node and creates a new node whose prev is that tail, then points the tail's next at it. An empty list becomes a single node.

- **Time:** O(N).
- **Extra space:** O(1).

**Insert at position K.** If K is 1, this is inserting before the head. Otherwise the method walks to the node at position K − 1 and creates a new node between it and its next node, updating that next node's prev if it exists.

- **Time:** O(K).
- **Extra space:** O(1).

**Insert before a given node.** The new node is created between the given node and the node before it, and both neighbours are pointed at it.

- **Time:** O(1).
- **Extra space:** O(1).

**Remember:** an insertion in a doubly linked list has to set up to four references: the new node's prev and next, the previous node's next, and the following node's prev. Any operation that can create a new head has to return it, because a method that returns nothing has no way to tell its caller where the list now starts.

## Reverse a doubly linked list
**File:** [ReverseDLL.java](ReverseDLL.java), method `reverseDLL`

**Question.** Reverse a doubly linked list in place and return the new head.

**Optimal — swap prev and next at every node.** Reversing a doubly linked list just means every node's prev and next trade places. The method walks the list and swaps the two references at each node. Since the references have just been swapped, the way forward to the next unvisited node is now through prev. When the walk ends, the old tail is the new head, and the method returns it. An empty list or a single node is returned unchanged.

- **Time:** O(N).
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which pushes every value onto a stack and then walks the list again writing the values back in reverse order, using O(N) extra space.

**Remember:** after the swap, follow prev to move forward, not next. Following next would step back onto nodes that have already been reversed.
