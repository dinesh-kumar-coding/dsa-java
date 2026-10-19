# Step 8 — Medium problems on doubly linked lists

Full notes for every problem in this folder. Status and revisit dates are tracked in [PROGRESS.md](../../../PROGRESS.md).

## Delete all occurrences of a key
**File:** [DeleteAllOccurrencesDLL.java](DeleteAllOccurrencesDLL.java), method `removeAllOccurrences`

**Question.** Delete every node holding a given value from a doubly linked list and return the head.

**Optimal — one pass, joining the neighbours around every match.** The method walks the list once. Whenever a node holds the value, it is cut out by pointing the previous node forward to the following node and the following node back to the previous node. If the matching node is the head, the head moves on to the next node first.

- **Time:** O(N) — one pass.
- **Extra space:** O(1).

**Remember:** check that the previous node and the following node exist before touching them; the first and last nodes each have one missing neighbour. When the head itself is deleted, return the new head, otherwise the caller keeps a reference to a node that is no longer part of the list.

## Remove duplicates from a sorted doubly linked list
**File:** [RemoveDuplicatesInSortedDLL.java](RemoveDuplicatesInSortedDLL.java), method `removeDuplicates`

**Question.** In a sorted doubly linked list, keep only the first copy of every value.

**Optimal — link each unique node to the next new value.** One reference stays on the last unique node kept so far, while another scans ahead. Because the list is sorted, duplicates are next to each other, so the scanner skips every node equal to the kept one. When it reaches a new value, that node is linked to the kept node in both directions and becomes the new kept node. At the end, the last kept node's next is cleared.

- **Time:** O(N).
- **Extra space:** O(1).

**Remember:** clear the next reference of the last unique node at the end. Without that, any duplicates at the very end of the list stay attached behind it.
