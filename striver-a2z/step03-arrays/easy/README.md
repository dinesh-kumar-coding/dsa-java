# Step 3 — Arrays: easy problems

Full notes for every problem in this folder. Status and revisit dates are tracked in [PROGRESS.md](../../../PROGRESS.md).

## Largest element in an array
**File:** [LargestElement.java](LargestElement.java), method `getLargestElement`

**Question.** Find the largest value in an array.

**Optimal — one pass.** The method starts by assuming the first element is the largest, then walks through the rest of the array and replaces its answer whenever a bigger element turns up. An empty array has no largest element, so it returns -1 for that case.

- **Time:** O(N) — every element is looked at once.
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which sorts the array and takes the last element, in O(N log N) time.

**Remember:** start the running maximum from the first element, never from zero. Starting from zero gives a wrong answer whenever every number in the array is negative.

## Second largest and second smallest element
**File:** [SecondLargestSmallest.java](SecondLargestSmallest.java), methods `getSecondLargestElement` and `getSecondSmallestElement`

**Question.** Find the second largest and the second smallest distinct values in an array without sorting it.

**Optimal — one pass that tracks the top two.** The method keeps two values: the largest seen so far and the second largest. When a new element beats the largest, the old largest drops down to become the second largest and the new element takes the top spot. Otherwise, if the element is different from the largest and bigger than the current second largest, it becomes the new second largest. If the second largest never moves from its starting value, there is no second distinct value, so the method returns -1. The second smallest works the same way with every comparison reversed.

- **Time:** O(N) for each of the two answers.
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which sorts the array and scans back from the end for the first value that differs from the largest, in O(N log N) time; and the better approach, which finds the largest in one pass and the biggest value not equal to it in a second pass.

**Remember:** the check that the element differs from the largest is what stops duplicates fooling the answer. Without it, an array like [7, 7, 5] reports 7 as the second largest instead of 5.

## Remove duplicates from a sorted array
**File:** [RemoveDuplicatesSorted.java](RemoveDuplicatesSorted.java), method `getNumberOfNonDuplicatesFromSortedArray`

**Question.** Remove the duplicates from a sorted array in place and return how many unique values remain.

**Optimal — two pointers.** Pointer i marks the last unique value kept so far, and pointer j scans ahead through the rest of the array. Because the array is sorted, equal values always sit next to each other, so whenever the value at j differs from the value at i, it is a new unique value: i moves one step forward and the value is copied into that position. When j reaches the end, the first i + 1 positions hold every unique value in order.

- **Time:** O(N) — one pass.
- **Extra space:** O(1) — the array is rewritten in place.

**Not in the file yet:** the brute force, which puts every element into an ordered set to drop the duplicates and copies the set back, in O(N log N) time with O(N) extra space.

**Remember:** this only works because sorting makes duplicates adjacent. The positions after the returned count still hold leftover values; only the first i + 1 positions are the answer.

## Check if an array is sorted
**File:** [CheckSorted.java](CheckSorted.java), method `checkArrayIsSorted`

**Question.** Decide whether an array is sorted in non-decreasing order.

**Optimal — compare every neighbouring pair.** An array is sorted exactly when no element is smaller than the one before it, so the method walks through the array once and returns false at the first element that drops below its left-hand neighbour.

- **Time:** O(N).
- **Extra space:** O(1).

**Remember:** "non-decreasing" allows equal neighbours, so the check must fail only on a strict drop. Failing on equal values as well would wrongly reject an array like [1, 2, 2, 3].

## Check if an array is sorted and rotated
**File:** [CheckSorted.java](CheckSorted.java), methods `check_leetcode1752` and `reverseArray`

**Question.** Decide whether an array could have been made by taking a sorted array and rotating it by some number of places (LeetCode 1752).

**Approach — undo the rotation, then check.** The method looks for the first position where an element is smaller than the one before it. If there is no such drop, the array is already sorted, which counts as a rotation by zero places. If there is one, that drop is where the rotation must have happened, so the method rotates the array back with three reversals (the part before the drop, the part after it, then the whole array) and checks whether the result is sorted. The reversals rearrange the input array itself.

- **Time:** O(N) — finding the drop, the three reversals and the final check are each a single pass.
- **Extra space:** O(1).

**Not in the file yet:** the counting approach, which counts how many times an element is larger than the next one, including the pair formed by the last element and the first. The array is sorted and rotated exactly when that count is at most 1. It also runs in O(N), and it leaves the array unchanged.

**Remember:** a rotated sorted array has at most one drop, and the pair made by the last element and the first element has to be counted too. That wrap-around pair is the easiest part of this problem to forget.

## Rotate an array by K places
**File:** [RotateArray.java](RotateArray.java), methods `leftRotateArray`, `rightRotateArray` and `reverseArray`

**Question.** Rotate an array to the left or to the right by K places, in place.

**Optimal — the reversal algorithm, in both directions.** First K is reduced to K modulo the length, because rotating by the full length brings the array back to where it started. For a left rotation, the method reverses the first K elements, then the remaining elements, then the whole array. For a right rotation, it makes the same three reversals in a different order: the whole array first, then the first K elements, then the rest. Each reversal flips one block in place, and the three together leave every element exactly K places away from where it began.

- **Time:** O(N) — every element is moved a constant number of times.
- **Extra space:** O(N) for the call stack, because the reversal helper is recursive and goes about half the length of the array deep. A reversal written with a loop would make the extra space constant.

**Not in the file yet:** the brute force, which copies the first K elements into a temporary array, shifts the rest, and copies the K elements back, using O(K) extra space.

**Remember:** reduce K modulo the length before anything else, and guard against an empty array, where that modulo divides by zero.

## Move all zeros to the end
**File:** [MoveZeros.java](MoveZeros.java), methods `moveZeros_bruteforce` and `moveZeros_optimal`

**Question.** Move every zero to the end of an array while keeping the non-zero elements in their original order.

**Brute — copy the non-zero elements out and back.** The method collects every non-zero element into a temporary list, writes them back to the front of the array in the same order, and fills every remaining position with zero.

- **Time:** O(N) — two passes.
- **Extra space:** O(N) for the temporary list.

**Optimal — two pointers with swaps.** Pointer j always marks the position where the next non-zero element belongs, and pointer i scans the array. Whenever i finds a non-zero element, it is swapped into position j and j moves forward. Zeros are never chosen, so they are pushed back step by step as non-zero elements are swapped in front of them.

- **Time:** O(N) — one pass.
- **Extra space:** O(1).

**Remember:** the non-zero elements keep their order because they are placed at j in exactly the order the scan finds them. Swapping, rather than overwriting, is what lets the zeros end up at the back without a separate filling pass.

## Union of two sorted arrays
**File:** [UnionIntersectionSorted.java](UnionIntersectionSorted.java), method `unionOfTwoSortedArrays`

**Question.** Given two sorted arrays, return every distinct value that appears in either of them, in sorted order.

**Optimal — merge with two pointers, skipping repeats.** One pointer walks each array. At every step, the smaller of the two current values is the next value of the union, so it is added to the result and its pointer moves on. When the two values are equal, the one from the first array is taken and the copy in the second array is later skipped as a repeat. A value is only added if it differs from the last value already in the result, which removes duplicates both inside each array and across the two. When one array runs out, the rest of the other is added with the same repeat check.

- **Time:** O(N + M), where N and M are the lengths of the two arrays.
- **Extra space:** O(1) apart from the result list itself.

**Not in the file yet:** the brute force, which puts every element of both arrays into an ordered set and reads it back, in O((N + M) log(N + M)) time.

**Remember:** in Java, comparing two `Integer` objects with `==` or `!=` compares the objects rather than the numbers, and it silently fails for values outside -128 to 127. Comparing an `Integer` from a list with a plain `int` is safe, because Java converts the `Integer` back to an `int` first.

## Intersection of two sorted arrays
**File:** [UnionIntersectionSorted.java](UnionIntersectionSorted.java), method `intersectionofTwoSortedArrays`

**Question.** Given two sorted arrays, return the values they have in common, keeping a value as many times as it appears in both.

**Optimal — two pointers.** One pointer walks each array. If the two current values are equal, that value is in both arrays, so it is added to the result and both pointers move on. If they differ, the smaller value cannot match anything further along in the other array, so only its pointer moves forward. The loop stops as soon as either array runs out.

- **Time:** O(N + M).
- **Extra space:** O(1) apart from the result list.

**Not in the file yet:** the brute force, which checks every element of the first array against the second and marks matched elements as used, in O(N × M) time with O(M) extra space.

**Remember:** after a match, both pointers must move. Moving only one would pair the same element with several copies in the other array and report it too many times.

## Find the missing number
**File:** [MissingNumber.java](MissingNumber.java), method `missingNumber`

**Question.** An array holds N − 1 distinct numbers taken from 1 to N. Find the one that is missing.

**Optimal — exclusive or (XOR).** XOR has two useful properties: a number XORed with itself gives 0, and a number XORed with 0 stays the same. The method XORs together every number from 1 to N in one variable and every element of the array in another. Every number that appears in both cancels itself out, so XORing the two results leaves only the number that was missing.

- **Time:** O(N) — one pass.
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which searches the array for each number from 1 to N in O(N²) time; the better approach, which marks the numbers it sees in a hash array, using O(N) time and O(N) extra space; and the sum approach, which subtracts the sum of the array from N × (N + 1) / 2.

**Remember:** the sum approach is also O(N) with constant space, but for large N the sum overflows an `int`. The XOR approach can never overflow, which is why it counts as the optimal one.

## Find the number that appears once
**File:** [SingleNumber.java](SingleNumber.java), method `findNumberThatAppearsOnceAndOtherNumberTwice`

**Question.** Every number in an array appears exactly twice except one, which appears once. Find that one.

**Optimal — exclusive or (XOR) of everything.** XORing a number with itself gives 0, and the order of XOR operations does not matter, so when every element is XORed together, each pair cancels itself out and only the single number is left.

- **Time:** O(N).
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which counts how often each number appears with a nested loop in O(N²) time; and the better approach, which counts with a hash map in O(N) time and O(N) extra space.

**Remember:** the trick depends on every other number appearing an even number of times. If the others appeared three times each they would not cancel, and a different technique, counting the bits in each position, would be needed.

## Longest subarray with sum K
**File:** [LongestSubarraySumK.java](LongestSubarraySumK.java), methods `longestSubArrayWithSumK`, `longestSubArrayWithSumKBetterForBothPositiveAndNegative` and `longestSubArrayWithSumKOptimalForOnlyPositiveOrWithZeroes`

**Question.** Find the length of the longest contiguous subarray whose elements add up to K.

**Brute — try every subarray with a running sum.** For every starting position, the method extends the subarray one element at a time, keeping a running sum, and records the length whenever the sum equals K. Keeping the sum running avoids adding the whole subarray up again at every step.

- **Time:** O(N²).
- **Extra space:** O(1).

**Better — prefix sums with a hash map, which works with negative numbers.** As the method walks the array it keeps the prefix sum, the total of everything from the start up to the current position. If the prefix sum itself equals K, the subarray from the start is a candidate. Otherwise, if some earlier position had a prefix sum of exactly the current prefix sum minus K, the elements between that position and the current one add up to K. A hash map remembers the first position at which each prefix sum appeared, so that earlier position can be found instantly. The sum is kept in a `long` so that it cannot overflow.

- **Time:** O(N) on average.
- **Extra space:** O(N) for the map.

**Optimal — a sliding window, only when no number is negative.** Two pointers mark the edges of a window. The right pointer adds one element at a time, and whenever the sum grows larger than K, the left pointer removes elements from the front until it no longer is. Whenever the sum equals K, the length of the window is a candidate.

- **Time:** O(N) — each element enters and leaves the window at most once.
- **Extra space:** O(1).

**Remember:** in the hash map version, store each prefix sum only the first time it appears. A later position with the same prefix sum gives a shorter subarray, and this matters as soon as the array contains zeros. The sliding window only works without negative numbers, because adding a negative number can make the sum go down, so shrinking from the left no longer means the window was too large.
