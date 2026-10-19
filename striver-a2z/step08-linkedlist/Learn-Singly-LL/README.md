# Step 8 — Learn the singly linked list

Full notes for every problem in this folder. Status and revisit dates are tracked in [PROGRESS.md](../../../PROGRESS.md).

A singly linked list stores its values in separate nodes. Each node holds a value and a reference to the next node, the last node points to nothing, and the whole list is reached through its first node, called the head. Every method below takes the head and, when the head can change, returns the new one.

## Convert an array to a linked list and print it
**File:** [SinglyLL_Basics.java](SinglyLL_Basics.java), methods `convertArr2LL` and `print`

**Question.** Build a linked list holding the values of an array in the same order, and print the list.

**Approach — create the head, then keep attaching to the end.** The first value becomes the head. A second reference, the mover, always points at the last node built so far; for every remaining value, a new node is created, the mover's next is pointed at it, and the mover steps onto it. Printing walks from the head, printing each value and following next until it reaches the end.

- **Time:** O(N) for both.
- **Extra space:** O(N) for the nodes being created; printing needs O(1).

**Remember:** keep the head and the mover as two separate references. Moving the head itself while building would lose the start of the list. An empty array has no first value, so it needs handling before the first node is created.

## Length of a linked list
**File:** [SinglyLL_Basics.java](SinglyLL_Basics.java), method `lengthOfLL`

**Question.** Count the nodes in a linked list.

**Approach — walk and count.** A temporary reference starts at the head and moves along the list one node at a time, adding one to a counter at every node, until it runs past the last node.

- **Time:** O(N).
- **Extra space:** O(1).

**Remember:** walk with a temporary reference rather than the head itself, so the caller's head is never moved.

## Search for a value in a linked list
**File:** [SinglyLL_Basics.java](SinglyLL_Basics.java), method `checkIfPresent`

**Question.** Decide whether a value is present in a linked list.

**Approach — walk until found.** The method walks from the head comparing each node's value with the target, returning true at the first match and false if it reaches the end.

- **Time:** O(N).
- **Extra space:** O(1).

**Remember:** a linked list has no indices to jump to, so even a sorted linked list cannot be binary searched efficiently; reaching the middle alone takes N/2 steps.

## Delete a node from a linked list
**File:** [SinglyLL_Basics.java](SinglyLL_Basics.java), methods `removeHead`, `removeTail`, `removeKthNode` and `removeNodeWithDataEl`

**Question.** Delete the head, the tail, the Kth node, or the first node holding a given value.

**Delete the head.** The new head is simply the second node, so the method returns `head.next`. An empty list is returned unchanged.

- **Time:** O(1).
- **Extra space:** O(1).

**Delete the tail.** The method walks until it reaches the second-to-last node and sets that node's next to nothing. A list with zero or one node becomes empty.

- **Time:** O(N).
- **Extra space:** O(1).

**Delete the Kth node.** If K is 1, this is deleting the head. Otherwise the method walks with two references, the current node and the one before it, counting positions; at position K it makes the previous node skip over the current one. If K is beyond the end of the list, nothing changes.

- **Time:** O(K).
- **Extra space:** O(1).

**Delete the node with a given value.** The same as deleting the Kth node, except that the walk stops at the first node holding the value rather than at a position. If the head holds the value, the head is deleted.

- **Time:** O(N).
- **Extra space:** O(1).

**Remember:** to delete a node in a singly linked list, you need the node *before* it, because that is the node whose next reference has to change. The head is the one node with nothing before it, which is why it is always a special case and why every delete method returns the possibly new head.

## Insert a node into a linked list
**File:** [SinglyLL_Basics.java](SinglyLL_Basics.java), methods `insertBeforeHead`, `insertAfterTail`, `insertAtKthPosition` and `insertBeforeEl`

**Question.** Insert a new value before the head, after the tail, at position K, or before the first node holding a given value.

**Insert before the head.** A new node is created pointing at the current head, and it becomes the new head.

- **Time:** O(1).
- **Extra space:** O(1).

**Insert after the tail.** The method walks to the last node and points it at a new node. If the list is empty, the new node is the whole list.

- **Time:** O(N).
- **Extra space:** O(1).

**Insert at position K.** If K is 1, this is inserting before the head. Otherwise the method walks to the node at position K − 1, creates a new node pointing at that node's next, and then points the K − 1 node at the new node.

- **Time:** O(K).
- **Extra space:** O(1).

**Insert before a given value.** If the head holds the value, this is inserting before the head. Otherwise the method walks while looking one node ahead, and when the next node holds the value, it splices the new node in between.

- **Time:** O(N).
- **Extra space:** O(1).

**Remember:** set the new node's next *before* changing the previous node's next. Doing it the other way round overwrites the only reference to the rest of the list, and everything after the insertion point is lost.
