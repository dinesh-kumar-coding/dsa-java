# Step 3 — Arrays: hard problems

Full notes for every problem in this folder. Status and revisit dates are tracked in [PROGRESS.md](../../../PROGRESS.md).

## Pascal's triangle
**File:** [PascalTriangle.java](PascalTriangle.java), methods `pascalTriangle_brute`, `findCombination`, `pascalTriangle_optimal` and `combinations`

**Question.** Pascal's triangle has three classic variants: find one element, print one row, or print the whole triangle up to N rows. Every element is a combination value, "row choose column", counting rows and columns from 0. This file builds the whole triangle in two ways, and its helper methods solve the other two variants along the way.

**Brute — work out every element on its own.** For each row and each position in it, the method calls `findCombination`, which computes "n choose r" by multiplying and dividing step by step, using the smaller of r and n − r so the loop is as short as possible. That helper on its own answers the "one element" variant.

- **Time:** O(N³) — about N²/2 elements, each taking up to O(N) steps.
- **Extra space:** O(1) apart from the triangle being built.

**Optimal — build each row from the previous value in the same row.** Inside one row, each value can be produced from the value before it: multiply by (row − position) and divide by (position + 1). The helper `combinations` starts every row at 1 and applies that step across the row, which solves the "one row" variant in O(N), and the method calls it for every row to build the whole triangle.

- **Time:** O(N²) — each row costs time proportional to its length.
- **Extra space:** O(1) apart from the triangle being built.

**Remember:** in the row formula, multiply before dividing; the division is only exact after the multiplication. The intermediate product is larger than the final value, so it overflows an `int` sooner than the triangle's own numbers do. Use a `long` for anything beyond small rows.

## Majority element (more than a third)
**File:** [MajorityElement_2.java](MajorityElement_2.java), methods `majorityElementII_brute` and `majorityElementII_optimal`

**Question.** Find every element that appears more than N/3 times in an array.

**Better — count with a hash map.** The method counts the elements in a hash map and adds an element to the result at the moment its count first goes above N/3, so no element is added twice. At most two elements can appear more than N/3 times, so it stops once it has found two.

- **Time:** O(N) on average.
- **Extra space:** O(N) for the map.

**Optimal — Boyer-Moore voting with two candidates.** Because at most two answers exist, the method tracks two candidates and two counts. An element equal to the first or the second candidate increases that candidate's count. Otherwise, if a count is zero, the element takes over that empty slot with a count of 1. Otherwise, the element cancels out one vote from each candidate, so both counts go down. A second pass counts the two candidates and keeps only those that really appear more than N/3 times.

- **Time:** O(N) — two passes.
- **Extra space:** O(1).

**Not in the file yet:** the true brute force, which counts every element with a nested loop in O(N²) time.

**Remember:** check whether the element equals either existing candidate *before* checking for an empty slot; doing it the other way round lets the same value occupy both slots. The second counting pass is required, because the voting only guarantees that the real answers are among the candidates, not that the candidates are answers.

## 3-Sum
**File:** [ThreeSum.java](ThreeSum.java), methods `threeSum_brute`, `threeSum_better`, `threeSum_optimal` and `threeSum_optimal_withTarget`

**Question.** Find every unique triplet of numbers in an array that adds up to zero. The last method answers the same question for any target value.

**Brute — three nested loops.** The method tries every triplet, and for each one that adds up to zero it sorts the three numbers and puts them into a set, so the same triplet found in a different order is only kept once.

- **Time:** O(N³).
- **Extra space:** O(number of triplets) for the set.

**Better — two loops and a hash set for the third number.** For each first number, the method walks the rest of the array with a hash set. For each second number, the third number needed is minus the sum of the first two; if it is already in the set, which holds the numbers between the first and the second, a triplet is found. Each triplet is sorted and stored in a set to remove repeats.

- **Time:** O(N²) on average.
- **Extra space:** O(N) for the hash set, plus the set of triplets.

**Optimal — sort, fix one number, then two pointers.** After sorting, the method fixes the first number of the triplet and places one pointer just after it and one at the end of the array. If the three add up to more than zero, the right pointer moves left; if less, the left pointer moves right; if exactly zero, the triplet is recorded and both pointers move inwards. Repeated values are skipped for the fixed number and for both pointers, so no triplet is recorded twice, and once the fixed number is positive the loop stops, because three numbers that are all positive cannot add up to zero. The target version works the same way but compares against the target and drops that early stop, which is only valid when the target is zero.

- **Time:** O(N²) — O(N) for the pointers for each of the N fixed numbers.
- **Extra space:** O(1) apart from the result.

**Remember:** duplicate handling is where 3-Sum usually goes wrong. Skip a repeated value of the fixed number before starting the pointers, and after a match move both pointers past every copy of the values just used.

## 4-Sum
**File:** [FourSum.java](FourSum.java), methods `fourSum_brute`, `fourSum_better` and `fourSum_optimal`

**Question.** Find every unique quadruplet of numbers in an array that adds up to a target.

**Brute — four nested loops.** Every quadruplet is tried, and the ones that match are sorted and stored in a set to remove repeats.

- **Time:** O(N⁴).
- **Extra space:** O(number of quadruplets) for the set.

**Better — three loops and a hash set for the fourth number.** For each first and second number, the method walks the rest of the array with a hash set. For each third number, the fourth number needed is the target minus the other three; if it is already in the set, a quadruplet is found, which is sorted and stored in a set of results.

- **Time:** O(N³) on average.
- **Extra space:** O(N) for the hash set, plus the set of results.

**Optimal — sort, fix two numbers, then two pointers.** After sorting, the method fixes the first two numbers with two loops, skipping repeated values for each, and then uses two pointers on the remaining part exactly as in 3-Sum. The four numbers are added up in a `long`.

- **Time:** O(N³).
- **Extra space:** O(1) apart from the result.

**Remember:** add the four numbers up in a `long`, because four values close to the `int` limit overflow an `int`, and judges deliberately include such inputs. When skipping repeated values for the second number, compare it with the previous value only when it is not the first position after the first number; skipping from any earlier position throws away valid quadruplets that use the same value twice.

## Longest subarray with sum 0
**File:** [LongestSubArrayWithSumZero.java](LongestSubArrayWithSumZero.java), method `LongestSubArrWithSum_Zero`

**Question.** Find the length of the longest contiguous subarray whose elements add up to zero.

**Optimal — repeated prefix sums.** If the prefix sum at two different positions is the same, the elements between them add up to zero. The method walks the array keeping the prefix sum. If the prefix sum is zero, the subarray from the very start is a candidate. If the prefix sum has been seen before, the stretch since its first appearance is a candidate. Otherwise, the prefix sum is stored with its position.

- **Time:** O(N) on average.
- **Extra space:** O(N) for the map.

**Not in the file yet:** the brute force, which adds up every subarray with a running sum in O(N²) time.

**Remember:** store each prefix sum only at its *first* position; a later position would make the stretch shorter. Prefix sums can also outgrow an `int` even when every element fits, so use a `long` when the input can be large.

## Count subarrays with XOR equal to K
**File:** [SubArrayWithXOR_K.java](SubArrayWithXOR_K.java), method `subArraysWithXOR_k`

**Question.** Count how many contiguous subarrays have a bitwise exclusive or (XOR) of exactly K.

**Optimal — prefix XOR with a count of each one.** This is the "count subarrays with sum K" idea with XOR in place of addition. The method keeps the prefix XOR of everything so far. If a subarray ending at the current position has an XOR of K, then the prefix XOR just before that subarray must be the current prefix XOR XORed with K, because XOR undoes itself. A hash map counts how many times each prefix XOR has appeared, so the method looks that value up and adds its count. The map starts with a prefix XOR of 0 recorded once, for subarrays that begin at the first element.

- **Time:** O(N) on average.
- **Extra space:** O(N) for the map.

**Not in the file yet:** the brute force, which XORs every subarray with a running value in O(N²) time.

**Remember:** where the sum version subtracts K, the XOR version XORs with K, because XORing with the same value twice cancels out. And as with sums, start the map with 0 seen once.

## Merge two sorted arrays without extra space
**File:** [MergeTwoSortedArray.java](MergeTwoSortedArray.java), methods `merge_optimal1`, `merge_optimal2` and `swapIfGreater`

**Question.** Given two sorted arrays, rearrange them so that the first array holds the smallest elements and the second holds the rest, both still sorted, without using a third array.

**Optimal 1 — swap across the boundary, then sort both.** The largest elements of the first array sit at its end and the smallest elements of the second array sit at its start. The method compares the last element of the first array with the first element of the second; while the first is bigger, it swaps them and moves both pointers inwards. As soon as a pair is already in order, every element in the first array is small enough, so it stops and sorts both arrays.

- **Time:** O(min(N, M) + N log N + M log M), where N and M are the lengths of the two arrays.
- **Extra space:** O(1).

**Optimal 2 — the gap method.** The method treats the two arrays as one long array and compares elements a fixed gap apart, swapping any pair that is out of order; a pair can sit in the first array, the second array, or across the two. The gap starts at half the total length, rounded up, and is halved, again rounded up, after each pass, until a final pass with a gap of 1.

- **Time:** O((N + M) log(N + M)) — about log(N + M) passes, each over every element.
- **Extra space:** O(1).

**Remember:** in the gap method, always round the gap *up* when halving, and still run the pass with a gap of 1; stopping before it can leave neighbouring elements out of order.

## Merge sorted array (LeetCode 88)
**File:** [MergeTwoSortedArray.java](MergeTwoSortedArray.java), method `merge_leetcode`

**Question.** The first array has spare space at its end. Merge the second sorted array into it so the whole first array is sorted.

**Optimal — fill from the back.** The method keeps one pointer on the last real element of each array and a third pointer on the last position of the first array. At each step, the larger of the two current elements is written to the back and its pointer moves left. When the second array runs out, the merge is finished, because whatever is left of the first array is already in place.

- **Time:** O(N + M).
- **Extra space:** O(1).

**Remember:** fill from the back, not the front. Writing from the front would overwrite elements of the first array that have not been placed yet, while the back of the first array is empty space that can be filled safely.

## Maximum product subarray
**File:** [MaxProductSubArray.java](MaxProductSubArray.java), method `maxProductSubArray`

**Question.** Find the largest product of a contiguous subarray.

**Optimal — prefix and suffix products.** Without zeros, the best product always comes from a prefix or a suffix of the array: with an even number of negative numbers the whole array is best, and with an odd number, the best is to drop everything up to the first negative or everything after the last one. The method therefore multiplies from the left and from the right at the same time and keeps the largest product seen in either direction. A zero splits the array into separate pieces, so whenever a running product becomes zero it restarts from 1.

- **Time:** O(N) — one pass.
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which multiplies out every subarray in O(N²) time; and the approach that tracks both the largest and the smallest product ending at each position.

**Remember:** a negative number can turn the smallest product into the largest, which is why tracking only the maximum, as in Kadane's algorithm, fails here. Products also grow very fast, so use a `long` when the values can be large.
