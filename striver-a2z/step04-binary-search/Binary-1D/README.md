# Step 4 — Binary search on one-dimensional arrays

Full notes for every problem in this folder. Status and revisit dates are tracked in [PROGRESS.md](../../../PROGRESS.md).

## Binary search for a target
**File:** [BinarySearch.java](BinarySearch.java), methods `binarySearch_iterative` and `binarySearch_recursive`

**Question.** Find the position of a target in a sorted array, or return -1 if it is not there.

**Iterative — halve the search range in a loop.** The method keeps a range from low to high and looks at the middle element. If it is the target, the search is over. If it is smaller than the target, the target can only be in the right half, so low moves to just after the middle; if it is larger, high moves to just before the middle. When low passes high, the range is empty and the target is not in the array.

- **Time:** O(log N) — the range halves at every step.
- **Extra space:** O(1).

**Recursive — the same halving, one call per step.** The recursive version takes low and high as arguments and calls itself on the left or right half instead of changing variables in a loop. A range where low has passed high means the target is not there.

- **Time:** O(log N).
- **Extra space:** O(log N) for the call stack.

**Remember:** compute the middle as `low + (high - low) / 2` rather than `(low + high) / 2`. Adding low and high can overflow an `int` for very large arrays; subtracting first never can.

## Lower bound
**File:** [BinarySearch.java](BinarySearch.java), method `lowerBound`

**Question.** Find the first position in a sorted array whose value is greater than or equal to a target. If no such position exists, return the length of the array.

**Optimal — record a candidate and keep searching left.** The method starts with the answer set to the length of the array. Whenever the middle value is at least the target, the middle is a possible answer, so it is recorded and the search continues in the left half in case an earlier position also qualifies. Otherwise the search moves to the right half.

- **Time:** O(log N).
- **Extra space:** O(1).

**Remember:** a matching middle value is not the end of the search here; it is only a candidate. Recording it and moving left is the pattern behind every "first position that satisfies something" binary search.

## Upper bound
**File:** [BinarySearch.java](BinarySearch.java), method `upperBound`

**Question.** Find the first position in a sorted array whose value is strictly greater than a target. If no such position exists, return the length of the array.

**Optimal — the lower bound with a strict comparison.** The method is identical to the lower bound except that a position only counts as a candidate when its value is strictly greater than the target. Every candidate is recorded and the search continues to the left.

- **Time:** O(log N).
- **Extra space:** O(1).

**Remember:** the only difference between the two bounds is greater-or-equal versus strictly-greater. Upper bound minus lower bound gives the number of times the target appears in the array.

## Search insert position
**File:** [SearchInsertFloorCeil.java](SearchInsertFloorCeil.java), method `searchInsertPosition`

**Question.** Return the position of a target in a sorted array, or the position where it would be inserted to keep the array sorted.

**Optimal — this is the lower bound.** The position where a target belongs is exactly the first position whose value is greater than or equal to it, so the method runs the lower-bound search: record every middle value that is at least the target and keep searching to the left. If every value is smaller than the target, it belongs at the end, which is why the answer starts as the length of the array.

- **Time:** O(log N).
- **Extra space:** O(1).

**Remember:** recognising a problem as a lower bound in disguise is the whole skill here. "Where would this go", "first value at least X" and "first position not smaller than X" are all the same search.

## Floor and ceil in a sorted array
**File:** [SearchInsertFloorCeil.java](SearchInsertFloorCeil.java), methods `floor` and `ceil`

**Question.** The floor of a target is the largest value in the array that is less than or equal to it; the ceil is the smallest value that is greater than or equal to it. Find both, returning -1 when one does not exist.

**Optimal — two mirror-image searches.** For the floor, any middle value that is at most the target is a candidate, so it is recorded and the search moves right to look for a bigger one; a larger middle value sends the search left. For the ceil, any middle value that is at least the target is a candidate, so it is recorded and the search moves left to look for a smaller one. Both methods return the value itself rather than its position.

- **Time:** O(log N) for each.
- **Extra space:** O(1).

**Remember:** the floor searches right after a candidate and the ceil searches left. If the target is in the array, the floor and the ceil are both the target itself.

## First and last occurrence
**File:** [FirstLastCountOccurrence.java](FirstLastCountOccurrence.java), methods `firstOccurrence` and `lastOccurrence`

**Question.** Find the first and the last position of a target in a sorted array that may contain duplicates, returning -1 if it is absent.

**Optimal — keep searching after a match.** Both methods run an ordinary binary search, but finding the target does not stop them. For the first occurrence, a match is recorded and the search continues in the left half, in case an earlier copy exists; for the last occurrence, a match is recorded and the search continues in the right half.

- **Time:** O(log N) for each.
- **Extra space:** O(1).

**Remember:** a plain binary search lands on *some* copy of the target, not a particular one. Finding the first or last copy means recording the match and pushing on in the right direction.

## Count occurrences
**File:** [FirstLastCountOccurrence.java](FirstLastCountOccurrence.java), method `countOccurrences`

**Question.** Count how many times a target appears in a sorted array.

**Optimal — last position minus first position plus one.** The method reuses the two methods above: it finds the first occurrence, returns 0 straight away if the target is absent, and otherwise returns the last position minus the first position plus one.

- **Time:** O(log N) — two binary searches.
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which walks the whole array and counts in O(N) time.

**Remember:** reuse the methods that are already written and tested instead of writing the search again inside this one. Upper bound minus lower bound gives the same count with a different pair of searches.

## Single element in a sorted array
**File:** [SingleElementInSortedArr.java](SingleElementInSortedArr.java), methods `singleElementInASortedArray_brute` and `singleElementInASortedArray_optimal`

**Question.** In a sorted array, every value appears exactly twice except one, which appears once. Find it.

**Brute — exclusive or (XOR) of everything.** XORing every element cancels each pair, because a value XORed with itself is 0, and leaves only the single value.

- **Time:** O(N).
- **Extra space:** O(1).

**Optimal — binary search on the length of the window.** The search window always contains the single element, so it always holds an odd number of elements. The method looks at the middle element and finds its partner, the equal value next to it on the left or on the right. Taking that pair away leaves two sides, and the single element must be on the side that now holds an odd number of elements. Which side that is depends only on whether the window length is one more than a multiple of four or three more than a multiple of four, which the method tests with `(high - low) % 4`. If the middle element has no equal neighbour, it is the answer.

- **Time:** O(log N).
- **Extra space:** O(1).

**Not in the file yet:** the textbook version of the binary search, which uses index parity instead: before the single element, the first copy of every pair sits at an even index, and after it, at an odd index.

**Remember:** whichever version is used, the single element is the point where the pairing pattern breaks, and looking at a neighbour at the very edge of the array has to be guarded so it never reads past either end.

## Search in a rotated sorted array
**File:** [SearchElementInRotArr.java](SearchElementInRotArr.java), method `searchEleInRotatedArray`

**Question.** A sorted array of distinct values has been rotated at an unknown point. Find the position of a target, or return -1.

**Optimal — one half is always sorted.** In a rotated array, at least one of the two halves around the middle is in normal sorted order. If the value at low is not larger than the value at mid, the left half is sorted: when the target lies between those two values, the search continues on the left, and otherwise on the right. If not, the right half is sorted, and the method checks whether the target lies between the middle value and the value at high in the same way.

- **Time:** O(log N).
- **Extra space:** O(1).

**Remember:** identify the sorted half first, then ask whether the target lies inside it; a range check is only meaningful on the half that is known to be sorted. Use "not larger than" when testing the left half, because when low and mid are the same position, the left half is a single element, which counts as sorted.

## Search in a rotated sorted array with duplicates
**File:** [SearchElementInRotArr.java](SearchElementInRotArr.java), method `searchEleInRotatedArray_withDuplicates`

**Question.** The same search, but the array may contain duplicate values. Return whether the target is present.

**Optimal — shrink both ends when the halves cannot be told apart.** The method is the same as the version without duplicates, with one extra case. When the values at low, mid and high are all equal, there is no way to tell which half is sorted, so both ends move one step inwards and the loop starts again. This is safe, because both of those values equal the middle value, which has already been checked against the target.

- **Time:** O(log N) on average, O(N) in the worst case, when almost every value is the same.
- **Extra space:** O(1).

**Remember:** duplicates are what break the "one half is sorted" test, and only in the case where low, mid and high all hold the same value. Handling that single case is the entire difference between the two versions.

## Minimum in a rotated sorted array
**File:** [MinInRotArr.java](MinInRotArr.java), method `minInRotatedArr`

**Question.** Find the smallest value in a sorted array of distinct values that has been rotated.

**Optimal — compare the middle with the right end.** If the middle value is greater than the value at high, the drop where the rotation happened, and therefore the minimum, lies to the right of the middle, so low moves past it. Otherwise the stretch from mid to high is in order, so the minimum is at mid or to its left, and high moves to mid. When low and high meet, they meet on the minimum.

- **Time:** O(log N).
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which scans the whole array in O(N) time.

**Remember:** move high to mid, not to mid − 1, because the middle element itself may be the minimum.

## Minimum in a rotated sorted array with duplicates
**File:** [MinInRotArr.java](MinInRotArr.java), method `minInRotatedArr_withDuplicates`

**Question.** The same problem, but the array may contain duplicate values.

**Optimal — shrink the right end when the values are equal.** The method is the same as the version without duplicates, except that when the values at low, mid and high are all equal, it cannot tell which side the minimum is on, so it moves high one step inwards and tries again. The value removed equals the middle value, which is still inside the range, so the minimum value is never lost.

- **Time:** O(log N) on average, O(N) in the worst case.
- **Extra space:** O(1).

**Remember:** that one-step shrink is why duplicates can make the search linear: an array of identical values shrinks by only one position per step.

## Number of times a sorted array has been rotated
**File:** [TimesSortArrRot.java](TimesSortArrRot.java), method `timesSortedArrayIsRotated`

**Question.** A sorted array has been rotated some number of times. Find how many, which is the position of the minimum element.

**Optimal — the minimum search, returning a position.** The method runs the same search as for the minimum with duplicates, but returns where the minimum is rather than its value: if the middle value is greater than the value at high, low moves past the middle; if all three values are equal, high moves one step inwards; otherwise high moves to mid. When low and high meet, low is the number of rotations.

- **Time:** O(log N) on average, O(N) in the worst case.
- **Extra space:** O(1).

**Remember:** with duplicates, the minimum value can appear in several places, and not every one of those positions is a valid rotation count. Shrink only one end when the three values are equal; moving both ends inwards at once can step over the position the search is looking for.

## Find a peak element
**File:** [PeakElement.java](PeakElement.java), method `findPeakElement`

**Question.** A peak is an element larger than its neighbours, where anything beyond the ends of the array counts as smaller than everything. Find the position of any peak.

**Optimal — follow the slope uphill.** The method compares the middle element with the one to its right. If the middle is larger, the array is going downhill at that point, so a peak lies at the middle or to its left, and high moves to mid. Otherwise the array is going uphill, so a peak lies to the right, and low moves past the middle. When low and high meet, that position is a peak.

- **Time:** O(log N).
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which checks every element against its neighbours in O(N) time.

**Remember:** a peak always exists, because the edges count as smaller than everything, and walking uphill must eventually stop at one. The search finds *a* peak, not necessarily the highest one.
