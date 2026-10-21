# Step 12 — Stack and queues: implementation

Full notes for every problem in this folder. Status and revisit dates are tracked in [PROGRESS.md](../../../PROGRESS.md).

The two array classes report every operation by adding a line to an output list, such as "Pushed 10" or "Stack Overflow", instead of printing or returning it. The two linked-list classes return their results instead, with −1 standing for an empty stack or queue.

## Implement a stack using an array
**File:** [StackUsingArrays.java](StackUsingArrays.java), methods `push`, `pop`, `peek`, `isEmpty` and `size`

**Question.** Build a stack, where the last value pushed is the first one removed, on top of a fixed-size array, with push, pop, peek, a check for emptiness and the current size.

**Approach — an array and the index of the top.** The class keeps the values in an array of fixed capacity and an index called `top` that points at the most recent value, starting at −1 for an empty stack. A push first checks whether the array is full, which is when the top is on the last index; if it is not, the top moves up one slot and the value is written there. A pop first checks whether the stack is empty, which is when the top is −1; if it is not, it reads the value at the top and moves the top down one slot. Peek reads the value at the top without moving it, and the size is the top index plus one.

- **Time:** O(1) for every operation.
- **Extra space:** O(N) for the array, where N is the capacity.

**Remember:** a pop only moves the index; the old value stays in the array but can never be read again, because everything above the top counts as empty. Check for a full stack before writing and for an empty one before reading, or the index runs off one end of the array.

## Implement a queue using an array
**File:** [QueueUsingArrays.java](QueueUsingArrays.java), methods `push`, `pop`, `peek`, `isEmpty` and `size`

**Question.** Build a queue, where the first value pushed is the first one removed, on top of a fixed-size array, with the same operations as the stack.

**Approach — a circular array with a front, a rear and a count.** Next to the array, the class keeps the index of the front, where the next value will be removed, the index of the rear, where the next value will be written, and the number of values stored. A push writes at the rear and moves the rear one slot forward; a pop reads at the front and moves the front one slot forward. Each move is taken modulo the capacity, so an index that passes the last slot comes back to slot 0 and reuses the space that earlier pops freed. Peek reads the value at the front without moving it.

- **Time:** O(1) for every operation.
- **Extra space:** O(N) for the array, where N is the capacity.

**Remember:** without wrapping around, the front and the rear only ever move forward, so the array fills up after N pushes even when most of the values have already been popped. Keep the count as well as the two indices: the front and the rear point at the same slot both when the queue is empty and when it is full, and only the count tells the two apart.

## Implement a stack using a linked list
**File:** [StackUsingLL.java](StackUsingLL.java), methods `push`, `pop`, `peek`, `isEmpty` and `size`

**Question.** Build a stack on top of a singly linked list instead of an array, so that it never runs out of room, with push, pop, peek, a check for emptiness and the current size.

**Approach — push and pop at the head of the list.** The class keeps a reference to the top node and a count of the values. A push creates a node whose next is the current top, and that node becomes the new top, so the newest value is always at the head. A pop on an empty stack returns −1; otherwise it saves the value of the top node, moves the top to the next node, lowers the count and returns the saved value. Peek returns the value of the top node without removing it, and the stack is empty when the top is null.

- **Time:** O(1) for every operation, because nothing ever walks the list.
- **Extra space:** O(N) for the nodes, where N is the number of values stored.

**Remember:** add and remove at the head of the list; working at the tail of a singly linked list would need a walk to find the node before the last one. Returning −1 for an empty stack is ambiguous when −1 can also be a real value, so check `isEmpty` first in that case.

## Implement a queue using a linked list
**File:** [QueueUsingLL.java](QueueUsingLL.java), methods `push`, `pop`, `peek`, `isEmpty` and `size`

**Question.** Build a queue on top of a singly linked list, with the same operations as the stack.

**Approach — push at the rear, pop at the front.** The class keeps references to the front node and the rear node, plus a count. A push creates a node; if the queue is empty, the new node becomes both the front and the rear, and otherwise it is linked after the current rear and becomes the new rear. A pop on an empty queue returns −1; otherwise it saves the value of the front node and moves the front to the next node, and when the removed node was the only one, both the front and the rear are set to null. It then lowers the count and returns the saved value. Peek returns the value of the front node, and the queue is empty when the front is null.

- **Time:** O(1) for every operation.
- **Extra space:** O(N) for the nodes, where N is the number of values stored.

**Remember:** keep the rear reference, or every push has to walk the whole list to find the end. When the last node is popped, clear the rear together with the front; otherwise the rear keeps pointing at the removed node, and any code that looks at the rear to decide whether the queue is empty goes wrong. Check whether the front has a next node before moving the front, because afterwards the front may already be null.

## Implement a stack using a queue
**File:** [StackUsingQueue.java](StackUsingQueue.java), methods `push`, `pop`, `peek`, `isEmpty` and `size`

**Question.** Build a stack using only what a single queue offers: adding at the back, removing from the front and looking at the front.

**Approach — rotate the queue after every push.** The class wraps one queue and a count of the values. A push adds the value at the back and then moves every older value, one at a time, from the front to the back, which is the count minus one moves, so the new value ends up at the front. The front of the queue is therefore always the top of the stack, and pop and peek simply remove or read the front. On an empty stack they return −1.

- **Time:** O(N) for a push, because of the rotation, where N is the number of values stored; O(1) for pop, peek, the emptiness check and the size.
- **Extra space:** O(N) for the queue.

**Remember:** rotate the count minus one times, not the count; one more move sends the new value back to the end. Decide which operation pays the cost: this version makes push slow so that pop and peek are instant, and rotating during pop instead would swap the costs around.

## Implement a queue using stacks
**File:** [QueueUsingStack.java](QueueUsingStack.java), methods `push`, `pop`, `peek`, `isEmpty` and `size`

**Question.** Build a queue using only what stacks offer: pushing onto the top, popping from the top and looking at the top. The file solves it in two ways, one class each.

**Approach 1 — keep the oldest value on top of the first stack.** A push moves everything from the first stack onto the second, pushes the new value onto the now empty first stack, and moves everything back. The new value ends up at the bottom and the oldest value at the top, so pop and peek work directly on the top of the first stack, and the size is the size of that stack.

- **Time:** O(N) for a push, where N is the number of values stored; O(1) for pop and peek.
- **Extra space:** O(N) for the two stacks.

**Approach 2 — an input stack and an output stack.** A push always goes onto the first stack. A pop or peek takes from the second stack, and only when the second stack is empty does it move everything over from the first, which reverses the values so the oldest one comes out on top. The size is the total of both stacks.

- **Time:** O(1) for a push; pop and peek are O(1) on average over many operations, because a single call may move N values but every value is moved only once in its lifetime.
- **Extra space:** O(N) for the two stacks.

**Remember:** in the second approach, refill the output stack only when it is completely empty; moving values onto it while it still holds some buries older values under newer ones and breaks the order. Most problems prefer the second approach, because no single push pays for moving the whole queue.
