# Step 10 — Greedy algorithms

Full notes for every problem in this folder. Status and revisit dates are tracked in [PROGRESS.md](../../PROGRESS.md).

A greedy algorithm builds its answer by making the choice that looks best right now and never revisiting it. That only works for problems where the locally best choice is provably part of a best overall answer, so the important part of every problem below is *why* the greedy choice is safe.

## Assign cookies
**File:** [AssignCookies.java](AssignCookies.java), method `assignCookies`

**Question.** Each child has a greed factor and each cookie has a size; a child is content with a cookie at least as large as their greed. Each child gets at most one cookie. Find the largest number of content children.

**Optimal — sort both, then match the smallest with the smallest.** The method sorts the greed factors and the cookie sizes, then walks both with two pointers. If the current cookie is big enough for the least greedy child still waiting, that child is content and the method moves on to the next child. Either way, the cookie has been used or rejected, so the method moves on to the next cookie.

- **Time:** O(N log N + M log M), where N is the number of children and M the number of cookies — the two sorts dominate.
- **Extra space:** O(1), apart from the sorts, which reorder both input arrays.

**Not in the file yet:** the brute force, which tries every way of handing out the cookies, in exponential time.

**Remember:** give each child the smallest cookie that satisfies them, so that bigger cookies stay available for greedier children. A cookie too small for the least greedy child left is safe to throw away, because every child after them is at least as greedy.

## Lemonade change
**File:** [LemonadeChange.java](LemonadeChange.java), method `lemonadeChange`

**Question.** Lemonade costs 5. Customers pay one at a time with a 5, 10 or 20 note, and you start with no change. Decide whether every customer can be given correct change.

**Optimal — count the notes and give the most useful change.** The method only needs to count how many 5 and 10 notes it holds. A 5 is simply kept. A 10 needs one 5 back. A 20 needs 15 back, and the method prefers to give a 10 and a 5, falling back to three 5s only when it has no 10. If neither option is possible, the answer is no.

- **Time:** O(N) — one pass over the customers.
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which tries both ways of giving change for every 20, in exponential time.

**Remember:** prefer a 10 and a 5 over three 5s when changing a 20. A 5 can be used for both a 10 and a 20, while a 10 is only ever useful for a 20, so 5s are the notes worth saving.

## Fractional knapsack
**File:** [FractionalKnapsack.java](FractionalKnapsack.java), method `maximumValue`

**Question.** Each item has a weight and a value, and any fraction of an item may be taken. Fill a bag with a weight limit so that the value inside is as large as possible.

**Optimal — take the items in order of value per unit of weight.** The method sorts the items so that the one with the highest value for each unit of weight comes first, using a comparator that compares those ratios with `Double.compare`. It then takes whole items while they fit, and once the next item is too heavy, it takes the fraction of it that fills the remaining capacity and stops.

- **Time:** O(N log N) — the sort dominates.
- **Extra space:** O(1), apart from the sort, which reorders the items.

**Not in the file yet:** the brute force, which tries every order of taking the items, in O(N!) time.

**Remember:** sort by the ratio of value to weight, not by value or weight alone. When working out the fractional part, convert to `double` before multiplying; if the multiplication happens on `int` values first, it can overflow before the conversion ever takes place.

## Maximum units on a truck
**File:** [FractionalKnapsack.java](FractionalKnapsack.java), method `maximumUnits`

**Question.** Each type of box has a number of boxes available and a number of units in each box. A truck can carry a limited number of boxes. Find the largest number of units it can carry (LeetCode 1710).

**Optimal — load the boxes with the most units first.** The method sorts the box types by units per box, largest first, using `Integer.compare`. It then loads whole groups of boxes while the truck has room, and when a group does not fit completely, it loads as many of those boxes as remain possible and stops.

- **Time:** O(N log N) — the sort dominates.
- **Extra space:** O(1), apart from the sort.

**Remember:** this is the fractional knapsack with whole boxes. Every box takes the same amount of space, so units per box plays the part of the value-to-weight ratio. Sort with `Integer.compare` rather than by subtracting one value from the other, because the subtraction can overflow.

## Jump game I
**File:** [JumpGame_I.java](JumpGame_I.java), method `canJump`

**Question.** Each element of an array is the maximum jump length from that position. Starting at the first position, decide whether the last position can be reached.

**Optimal — track the furthest reachable position.** The method walks the array keeping the furthest position reachable so far. If it ever stands on a position beyond that reach, it is stuck, so the answer is false. Otherwise it extends the reach to the current position plus its jump length, and as soon as the reach covers the last position, the answer is true.

- **Time:** O(N) — one pass.
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which recursively tries every possible jump from every position, in exponential time.

**Remember:** there is no need to track an actual path. Every position up to the current reach is reachable, so the only question at each step is whether the walk has gone beyond that reach.

## Jump game II
**File:** [JumpGame_II.java](JumpGame_II.java), method `minJumps`

**Question.** With the same rules, and the last position guaranteed to be reachable, find the smallest number of jumps needed to get there.

**Optimal — expand one window of reachable positions per jump.** The positions reachable with a given number of jumps form a continuous window. The method starts with a window holding only the first position. For each window, it works out the furthest position reachable from anywhere inside it; the positions just beyond the current window up to that furthest point form the next window, which costs one more jump. It stops once a window reaches the last position.

- **Time:** O(N) — every position belongs to exactly one window.
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which recursively tries every jump, in exponential time; and the dynamic programming approach, which works out the fewest jumps for every position in O(N²) time.

**Remember:** each window is one level of a breadth-first search, so counting the windows counts the jumps. The method relies on the last position being reachable; if a window adds no new positions, the loop makes no progress, so that case needs a check whenever the guarantee is missing.

## N meetings in one room
**File:** [NMeetingsInOneRoom.java](NMeetingsInOneRoom.java), method `maxMeetings`

**Question.** There is one room and N meetings, each with a start time and an end time. Only one meeting can run at a time, and a meeting can only start strictly after the previous one has ended, so a start time equal to the previous end time is a clash. Find the largest number of meetings that can be held.

**Optimal — sort by end time, then always take the meeting that ends first.** The method copies each start and end time into a pair and sorts the pairs by end time with `Integer.compare`. It then walks them in that order, remembering when the last chosen meeting ended, starting from −1 so that a meeting at time 0 can still be chosen, and takes every meeting that starts after that moment. The meeting that ends earliest leaves the most time for everything after it, so no other choice can fit more meetings.

- **Time:** O(N log N) for the sort; the walk is O(N).
- **Extra space:** O(N) for the array of pairs.

**Not in the file yet:** the brute force, which tries every subset of meetings, in exponential time.

**Remember:** sort by end time, not by start time; the meeting that starts first can be a long one that blocks everything else. Read the problem's rule for touching meetings: here a meeting that starts exactly when another ends is a clash, so the check is strictly greater, while problems that allow touching need greater-or-equal.

## Order of the meetings in one room
**File:** [NMeetingsInOneRoom.java](NMeetingsInOneRoom.java), method `maxMeetings_order`

**Question.** The same problem, but return which meetings are held, in the order they happen. When two meetings end at the same time, the one that comes first in the input is preferred.

**Optimal — the same greedy, carrying each meeting's position.** Each meeting is stored as a triple of its position in the input, its start time and its end time. The sort orders the triples by end time and, when two end times are equal, by position, so the earlier meeting in the input comes first. The walk is the same as before, except that the position of every chosen meeting is added to a list, which ends up in the order the meetings are held. The positions are counted from 0.

- **Time:** O(N log N) for the sort.
- **Extra space:** O(N) for the triples and the list.

**Remember:** sorting mixes the meetings up, so each meeting's original position has to be stored before the sort; afterwards it cannot be recovered. Many versions of this problem number the meetings from 1, so check whether the answer needs 1 added to every position.

## Non-overlapping intervals
**File:** [NonOverlappingIntervals.java](NonOverlappingIntervals.java), method `eraseOverlappingIntervals`

**Question.** Given a list of intervals, return the smallest number of intervals to remove so that the rest do not overlap. Intervals that only touch at an end point, such as [1, 2] and [2, 3], do not overlap (LeetCode 435).

**Optimal — keep as many intervals as possible, then subtract.** Removing the fewest intervals is the same as keeping the most, and keeping the most is the meetings problem again. The method sorts the intervals by end time and keeps every interval that starts at or after the end of the last kept one. The last end starts at the smallest possible `int`, so the first interval is always kept, even when the coordinates are negative. The answer is the total number of intervals minus the number kept.

- **Time:** O(N log N) for the sort.
- **Extra space:** O(N) in the worst case for Java's sort of an array of arrays; the walk itself needs O(1).

**Not in the file yet:** the brute force, which tries every subset of intervals, in exponential time.

**Remember:** this is [N meetings in one room](#n-meetings-in-one-room) with one difference: touching intervals are allowed, so the check is greater-or-equal instead of strictly greater. Sorting rearranges the array that was passed in, so copy it first if the original order is still needed.
