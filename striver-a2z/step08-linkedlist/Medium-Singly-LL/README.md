# Step 8 — Medium problems on singly linked lists

Full notes for every problem in this folder. Status and revisit dates are tracked in [PROGRESS.md](../../../PROGRESS.md).

Many of these problems use the tortoise and hare technique: two references walk the same list, one moving one node per step and the other moving two. The relationship between where they are says something about the list, such as where its middle is or whether it loops back on itself.

## Middle of a linked list
**File:** [MiddleOfLL.java](MiddleOfLL.java), method `middleNode`

**Question.** Return the middle node of a linked list; when the list has two middle nodes, return the second one.

**Optimal — tortoise and hare.** Both references start at the head. In every step the slow one moves one node and the fast one moves two, so when the fast one reaches the end, the slow one has covered exactly half the distance and is standing on the middle.

- **Time:** O(N) — one walk through half the list for the slow reference.
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which counts the nodes in one pass and walks to node number N/2 in a second pass.

**Remember:** the loop condition decides which middle is returned for even lengths. Continuing while the fast reference and the node after it both exist gives the second middle; continuing while the next two nodes after the fast reference exist gives the first middle.

## Reverse a linked list
**File:** [ReverseLL.java](ReverseLL.java), methods `reverseList_iterative` and `reverseList_recursive`

**Question.** Reverse a linked list and return the new head.

**Iterative — three references.** The method walks the list keeping the previous node, the current node, and the node after the current one. At each step it saves the next node, points the current node back at the previous one, and then moves both previous and current one node forward. When current runs off the end, previous is the new head.

- **Time:** O(N).
- **Extra space:** O(1).

**Recursive — reverse the rest, then attach the head at the end.** An empty list or a single node is already reversed. Otherwise the method reverses everything after the head through a recursive call; the node that came after the head is now the last node of that reversed part, so it is pointed back at the head, and the head's next is cleared so the head becomes the new tail.

- **Time:** O(N).
- **Extra space:** O(N) for the call stack.

**Not in the file yet:** the brute force, which pushes every value onto a stack and writes them back in reverse order.

**Remember:** in the iterative version, save the next node *before* redirecting the current node's next, or the rest of the list is lost. In the recursive version, clearing the old head's next is what stops the list from pointing back into itself.

## Detect a loop in a linked list
**File:** [DetectLoop.java](DetectLoop.java), method `hasCycle`

**Question.** Decide whether a linked list loops back on itself instead of ending.

**Optimal — Floyd's tortoise and hare.** The slow reference moves one node per step and the fast one moves two. If the list ends, the fast reference reaches the end and there is no loop. If there is a loop, both references eventually enter it, and the fast one closes the gap by one node on every step, so it is guaranteed to land on the slow one.

- **Time:** O(N).
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which stores every visited node in a hash set and reports a loop the moment a node is visited a second time, using O(N) extra space.

**Remember:** compare the nodes themselves, not their values; two different nodes can hold the same value. The fast reference cannot jump over the slow one inside the loop, because it only gains one node per step.

## Starting point of the loop
**File:** [StartingNodeOfLoop.java](StartingNodeOfLoop.java), method `startingNode`

**Question.** If a linked list contains a loop, return the node where the loop begins; otherwise return nothing.

**Optimal — Floyd's algorithm, then a second walk.** The method first runs the tortoise and hare until they meet inside the loop. It then moves the slow reference back to the head and advances both references one node at a time. The point where they meet again is the start of the loop.

- **Time:** O(N).
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which stores visited nodes in a hash set and returns the first node that turns up a second time.

**Remember:** the second walk works because the distance from the head to the start of the loop equals the distance from the meeting point forwards to the start of the loop. Move one reference back to the head, and then move both one step at a time; the fast reference no longer takes double steps.

## Length of the loop
**File:** [LengthOfLoop.java](LengthOfLoop.java), method `lengthOfLoop`

**Question.** If a linked list contains a loop, return how many nodes are in the loop; otherwise return 0.

**Optimal — meet, then walk around once.** The method runs the tortoise and hare until they meet, which proves there is a loop and gives a node inside it. It then keeps one reference fixed and walks the other around the loop, counting steps until it is back at the fixed node.

- **Time:** O(N).
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which records each node's position in a hash map while walking, and when a node appears again, returns the difference between the current position and its first position.

**Remember:** start the count at the meeting point and stop on returning to it. The first step away from the meeting point already counts as one node.

## Check if a linked list is a palindrome
**File:** [CheckPalindrome.java](CheckPalindrome.java), methods `checkIfPalidrome` and `reverseList_iterative`

**Question.** Decide whether the values of a linked list read the same forwards and backwards.

**Optimal — reverse the second half and compare.** The method uses the tortoise and hare to stop at the end of the first half, reverses the second half in place, and then walks the first half and the reversed second half side by side, comparing values. Before returning, it reverses the second half again, so the caller gets the list back exactly as it was.

- **Time:** O(N).
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which pushes every value onto a stack and compares the list with the values popped back off, using O(N) extra space.

**Remember:** put the second half back the way it was before returning; a method that only answers a question should not leave the caller's list changed. For an even length, stop the slow reference at the *first* middle so that the two halves are the same size.

## Odd even linked list
**File:** [OddEvenLL.java](OddEvenLL.java), method `oddEven`

**Question.** Rearrange a linked list so that all the nodes in odd positions come first, followed by all the nodes in even positions, keeping the original order within each group.

**Optimal — build two chains and join them.** One reference starts on the first node to build the odd chain, and another starts on the second node to build the even chain. The head of the even chain is saved first. In each step, the odd node is pointed at the node two places ahead, and so is the even node, and both references move on. When the even chain runs out, the end of the odd chain is joined to the saved head of the even chain.

- **Time:** O(N).
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which copies the values into an array grouped by position and writes them back, using O(N) extra space.

**Remember:** "odd" and "even" refer to positions, not values. Save the head of the even chain before the loop starts, because the loop moves the even reference away from it.

## Remove the Nth node from the end
**File:** [RemoveNthFromEnd.java](RemoveNthFromEnd.java), method `removeNthNodeFromEnd`

**Question.** Remove the Nth node counting from the end of a linked list.

**Optimal — two references with a fixed gap.** The fast reference first moves N nodes ahead. If that takes it past the end, the node to remove is the head itself, so the method returns the second node. Otherwise both references move together until the fast one is on the last node; the slow one is then just before the node to remove, so it skips over it.

- **Time:** O(L), where L is the length of the list — a single pass.
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which counts the length in one pass and walks to node number L − N in a second pass.

**Remember:** when the fast reference falls off the end after its head start, the node to remove is the head, and that case has to be handled before the main loop. The head start of N is what makes the slow reference stop *before* the node to delete rather than on it.

## Delete the middle node
**File:** [DeleteMiddle.java](DeleteMiddle.java), method `deleteMiddle`

**Question.** Delete the middle node of a linked list; for an even length, delete the second of the two middle nodes.

**Optimal — tortoise and hare with a head start.** A list with one node becomes empty. Otherwise the fast reference starts two nodes ahead of the slow one, so when the fast reference reaches the end, the slow one is standing just before the middle node instead of on it, and it skips over the middle.

- **Time:** O(N).
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which counts the nodes and then walks to the node before the middle in a second pass.

**Remember:** deleting a node needs the node before it. Giving the fast reference one extra step at the start is a neat way of making the slow reference stop exactly one node early.

## Sort a linked list of 0s, 1s and 2s
**File:** [Sort0s1s2s.java](Sort0s1s2s.java), method `sortList`

**Question.** Sort a linked list whose values are only 0, 1 and 2.

**Optimal — three chains joined together.** The method creates three dummy nodes, one each to start a chain of 0s, a chain of 1s and a chain of 2s. It walks the list once and attaches every node to the end of the chain matching its value. Finally it joins the end of the 0s chain to the start of the 1s chain, or straight to the 2s chain if there are no 1s, joins the 1s chain to the 2s chain, ends the 2s chain, and returns the node after the first dummy.

- **Time:** O(N) — one pass.
- **Extra space:** O(1) — the existing nodes are relinked, not copied.

**Not in the file yet:** the brute force, which counts the 0s, 1s and 2s and then overwrites the values in a second pass.

**Remember:** dummy nodes remove every "is this chain still empty?" check while attaching nodes. When joining, any chain can be empty, so join the 0s to the 1s only when there are 1s; and always end the last chain explicitly, or its final node may still point back into the old list.

## Intersection point of two Y-shaped linked lists
**File:** [IntersectionPointOfYLL.java](IntersectionPointOfYLL.java), method `getIntersectionNode`

**Question.** Two linked lists merge at some node and share every node after it, forming a Y shape. Return the node where they meet, or nothing if they never do.

**Optimal — two references that switch lists.** One reference walks the first list and one walks the second. When a reference reaches the end of its list, it continues from the head of the *other* list. After switching, both have walked the same total distance by the time they reach the meeting node, so they arrive there together. If the lists never meet, both reach the end together instead, and the method returns nothing.

- **Time:** O(N + M), where N and M are the lengths of the two lists.
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which puts every node of the first list into a hash set and returns the first node of the second list found in it; and the length-difference approach, which moves the reference on the longer list ahead by the difference in lengths before walking both together.

**Remember:** compare nodes, not values. Two different nodes can hold the same value, and the meeting point is the first node the two lists actually share.

## Add two numbers
**File:** [AddTwoNumbers.java](AddTwoNumbers.java), method `addTwoNumbers`

**Question.** Two linked lists each store a non-negative number, one digit per node, with the lowest digit first. Return their sum as a linked list in the same format.

**Optimal — schoolbook addition with a carry.** Because the lowest digit comes first, walking the two lists from the head is exactly the order in which addition is done by hand. At each position the method adds the two digits, using 0 for a list that has run out, plus the carry; it creates a node holding the sum modulo 10 and carries the sum divided by 10 into the next position. A dummy node at the front means the first digit needs no special handling, and the result starts at the node after it.

- **Time:** O(max(N, M)).
- **Extra space:** O(max(N, M)) for the result list.

**Remember:** do not forget the final carry. Adding 999 and 1 produces four digits, so if a carry is left once both lists are finished, it needs one more node at the end.
