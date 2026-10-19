# Step 3 — Arrays: medium problems

Full notes for every problem in this folder. Status and revisit dates are tracked in [PROGRESS.md](../../../PROGRESS.md).

## Two Sum
**File:** [TwoSum.java](TwoSum.java), methods `twoSum` and `twoSumOptimal`

**Question.** Given an array and a target, find two numbers that add up to the target and return their positions.

**Better — hash map, returns the two indices.** Walk through the array once. For each number, the partner it needs is the target minus that number. Before storing the current number, the method checks whether that partner has already been seen, using a hash map from each value to the index where it appeared. If the partner is there, those two indices are the answer; if not, the current number is stored with its index and the walk continues.

- **Time:** O(N) — every element is visited once and each lookup takes constant time on average.
- **Extra space:** O(N) — the map can end up holding every element.

**Optimal for the yes-or-no version — two pointers after sorting.** The method sorts the array and places one pointer on the smallest number and one on the largest. If their sum is larger than the target, the only way to reduce it is to move the right pointer left; if it is smaller, the left pointer moves right; if it matches, the answer is yes. Sorting throws away the original positions, so this version can say whether a pair exists but not where it is.

- **Time:** O(N log N) — the sort dominates, and the pointer walk is linear.
- **Extra space:** constant, apart from the sort itself.

**Not in the file yet:** the brute force, which tries every pair with two nested loops in O(N²) time.

**Remember:** look up the partner *before* storing the current number. Storing first lets a number pair with itself, so a target of 6 would wrongly match a single 3.

## Sort an array of 0s, 1s and 2s
**File:** [SortColors.java](SortColors.java), method `sortArrayOfZeroes_Ones_Twos`

**Question.** Sort an array that contains only the values 0, 1 and 2, in a single pass and without extra space.

**Optimal — the Dutch national flag algorithm.** Three pointers split the array into four regions: everything before low is 0, everything from low up to mid is 1, everything after high is 2, and the region from mid to high has not been looked at yet. The method examines the element at mid. A 0 is swapped to position low, and both low and mid move forward. A 1 is already in the right region, so only mid moves forward. A 2 is swapped to position high and high moves back, but mid stays where it is, because the element that has just arrived from high has not been examined yet. The loop runs until mid passes high.

- **Time:** O(N) — one pass.
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which simply sorts the array in O(N log N) time; and the better approach, which counts the 0s, 1s and 2s in a first pass and overwrites the array with those counts in a second pass.

**Remember:** after a swap with high, do not move mid forward, because the element that came from high is still unchecked. The loop must also keep running while mid equals high, since the element at high is itself unchecked.

## Majority element (more than half)
**File:** [MajorityElement_1.java](MajorityElement_1.java), methods `majorityElement_brute` and `majorityElement_optimal`

**Question.** Find the element that appears more than N/2 times in an array, or report that there is none.

**Better — count with a hash map.** The method counts each element in a hash map and returns an element as soon as its count goes above half the length of the array.

- **Time:** O(N) on average.
- **Extra space:** O(N) for the map.

**Optimal — Boyer-Moore voting.** The method keeps one candidate and a count. When the count is zero, the current element becomes the new candidate with a count of 1. An element equal to the candidate adds one to the count, and any other element takes one away. A majority element appears more often than every other element combined, so it survives all the cancelling and ends up as the candidate. A second pass then counts the candidate to confirm that it really appears more than N/2 times.

- **Time:** O(N) — two passes.
- **Extra space:** O(1).

**Not in the file yet:** the true brute force, which counts every element with a nested loop in O(N²) time.

**Remember:** the voting pass only produces a candidate. If the problem does not guarantee that a majority exists, the second counting pass is essential: in [1, 2, 3] the voting leaves 3 as the candidate even though nothing is a majority.

## Maximum subarray sum (Kadane's algorithm)
**File:** [MaximumSubarraySum.java](MaximumSubarraySum.java), methods `maxSubArraySum` and `maxSubArray`

**Question.** Find the largest possible sum of a contiguous subarray, and also return the subarray itself.

**Optimal — Kadane's algorithm.** The method walks the array keeping a running sum and the best sum found so far. Each element is added to the running sum, and if the running sum is now the best seen, it is recorded. If the running sum drops below zero, it is reset to zero, because a negative running total can only make whatever comes after it smaller. The second method follows the same steps but also remembers where the current run started (whenever the running sum is zero) and the start and end positions of the best run, so it can return the subarray itself rather than only its sum.

- **Time:** O(N) — one pass.
- **Extra space:** O(1) for the sum; the second method also builds the subarray it returns.

**Not in the file yet:** the brute force, which adds up every possible subarray in O(N²) time with a running sum, or O(N³) without one.

**Remember:** decide up front whether an empty subarray is allowed. Starting the best sum at zero returns 0 for an array of all negative numbers, which is only right when taking no elements is allowed; if at least one element must be taken, start the best sum from the first element instead.

## Best time to buy and sell a stock
**File:** [StockBuySell.java](StockBuySell.java), method `maximumProfit`

**Question.** Given a stock's price on each day, find the largest profit from buying on one day and selling on a later day.

**Optimal — track the cheapest price so far.** The method walks through the days keeping the lowest price seen so far as the buying price. On each day it works out the profit from selling today at the current price, records it if it is the best yet, and then updates the lowest price if today is cheaper.

- **Time:** O(N) — one pass.
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which tries every pair of buying and selling days in O(N²) time.

**Remember:** a single left-to-right pass works because, on any day, the lowest price seen so far only contains earlier days, so the method can never sell before it buys. If prices only ever fall, the answer is 0, meaning the best choice is not to trade at all.

## Rearrange array elements by sign
**File:** [RearrangeBySign.java](RearrangeBySign.java), methods `rearrangeArrayElementsBySign_BRUTE` and `rearrangeArrayElementsBySign_OPTIMAL`

**Question.** Rearrange an array so that positive and negative numbers alternate, keeping each group in its original order. The two methods solve two common variants of this problem.

**Split and merge — when the counts can differ.** The first method copies the positive numbers into one list and the negative numbers into another. It then fills the array alternately, starting with a negative number, for as many pairs as the shorter list allows, and appends whatever is left of the longer list at the end in its original order.

- **Time:** O(N) — one pass to split, one pass to write back.
- **Extra space:** O(N) for the two lists.

**Place by index — equal counts, starting with a positive (LeetCode 2149).** The second method makes one pass and writes each number straight into its final slot in a result array: positive numbers go to positions 0, 2, 4 and onwards, and negative numbers go to positions 1, 3, 5 and onwards. The result is then copied back into the original array.

- **Time:** O(N).
- **Extra space:** O(N) for the result array.

**Remember:** placing by index only works when there are exactly as many positive numbers as negative ones. With unequal counts the positions run past the end of the array, so the split-and-merge approach is needed to append the leftovers.

## Next permutation
**File:** [NextPermutation.java](NextPermutation.java), method `nextPermutation`

**Question.** Rearrange an array into the next permutation in dictionary order; if it is already the last one, rearrange it into the first.

**Optimal — break point, swap, reverse.** First, the method scans from the right for the first position whose value is smaller than the value just after it; this is the break point, the rightmost place where the arrangement can still be made larger. If no break point exists, the whole array is in decreasing order, which is the last permutation, so reversing it gives the first one. Otherwise, the method scans from the right again for the first value bigger than the one at the break point, which is the smallest value that can replace it, and swaps the two. Finally it reverses everything after the break point, turning that part into its smallest possible arrangement.

- **Time:** O(N) — at most three passes.
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which generates every permutation, sorts them, and picks the one after the current arrangement, in O(N! × N) time.

**Remember:** everything to the right of the break point is always in decreasing order. That is why the first larger value found from the right is the smallest larger value, and why a simple reversal, rather than a full sort, is enough to make that part as small as possible.

## Leaders in an array
**File:** [LeadersInArray.java](LeadersInArray.java), method `LeadersInAnArray`

**Question.** An element is a leader if it is greater than every element to its right. Find all the leaders.

**Optimal — scan from the right with a running maximum.** The method walks from the last element back to the first, keeping the largest value seen so far. Any element greater than that running maximum is greater than everything to its right, so it is a leader: it is added to the result and becomes the new maximum. Because the leaders are found from right to left, the result is reversed at the end to put them back in their original order.

- **Time:** O(N).
- **Extra space:** O(1) apart from the result list.

**Not in the file yet:** the brute force, which checks every element against everything to its right with a nested loop in O(N²) time.

**Remember:** the last element is always a leader, because nothing is to its right. Check whether the problem says "greater than" or "greater than or equal to": the two definitions give different answers when the array contains duplicates.

## Longest consecutive sequence
**File:** [LongestConsecutiveSequence.java](LongestConsecutiveSequence.java), methods `longestConsecutiveSequence_brute`, `linearSeach`, `longestConsecutiveSequence_better` and `longestConsecutiveSequence_optimal`

**Question.** Find the length of the longest run of consecutive integers that can be formed from the values in an array, in any order.

**Brute — chase each run with a linear search.** For every element x, the method searches the whole array for x + 1, then x + 2, and so on, counting how far the run goes, and keeps the longest count.

- **Time:** O(N³) in the worst case — up to N steps per starting element, each one a linear search of the whole array.
- **Extra space:** O(1).

**Better — sort first.** After sorting, consecutive values sit next to each other. The method walks the sorted array: a value exactly one more than the previous value extends the current run, an equal value is a duplicate and is skipped without breaking the run, and anything else starts a new run of length 1.

- **Time:** O(N log N) — the sort dominates.
- **Extra space:** O(1), but the input array is reordered.

**Optimal — a hash set and starting points only.** Every value goes into a hash set. Then, for each value whose predecessor (value − 1) is not in the set, the value must be the start of a run, so the method counts upwards through value + 1, value + 2 and so on while they are in the set.

- **Time:** O(N) on average — each value is counted inside a run only once.
- **Extra space:** O(N) for the set.

**Remember:** only start counting from values whose predecessor is missing. Without that check, every value in a long run starts its own count and the algorithm slows down to O(N²). In the sorted version, duplicates must be skipped without resetting the count.

## Set matrix zeroes
**File:** [SetMatrixZeroes.java](SetMatrixZeroes.java), methods `setMatrixZeroes_brute`, `fillZeroes`, `setMatrixZeroes_better` and `setMatrixZeroes_optimal`

**Question.** Wherever a matrix contains a 0, set that cell's entire row and column to 0, ideally without using extra space.

**Brute — mark with a placeholder, then convert.** For every 0 found, the method marks every cell in its row and column that holds a 1 with -1 as a placeholder, and a final pass turns every -1 into 0. Using a placeholder rather than writing zeros straight away stops the new zeros from being mistaken for original ones. This version assumes the matrix holds only 0s and 1s.

- **Time:** O(N × M × (N + M)), where the matrix has N rows and M columns — each zero can trigger a scan of a whole row and a whole column.
- **Extra space:** O(1).

**Better — one flag array for rows and one for columns.** A first pass records, in two boolean arrays, which rows and which columns contain a zero. A second pass sets every cell to 0 whose row or column is flagged.

- **Time:** O(N × M) — two passes over the matrix.
- **Extra space:** O(N + M) for the two flag arrays.

**Optimal — use the first row and first column as the flags.** Instead of separate arrays, the method stores the flags inside the matrix itself: a zero at a cell sets the first cell of its row and the first cell of its column to 0. Because those markers overwrite the first row and column, two booleans first record whether the first row and the first column originally contained a zero. The method then zeroes every inner cell whose row marker or column marker is 0, and finally zeroes the first column and the first row only if their booleans say so.

- **Time:** O(N × M).
- **Extra space:** O(1).

**Remember:** never write zeros while still scanning for them, because a freshly written zero looks exactly like an original one and wipes out extra rows and columns. Every approach first records what to clear and only then clears it. In the optimal version, the first row and first column must be cleared last, since they still hold the markers.

## Rotate a matrix by 90 degrees
**File:** [RotateMatrix.java](RotateMatrix.java), methods `rotateMatrixBy90degrees_brute` and `rotateMatrixBy90degrees_optimal`

**Question.** Rotate a square matrix by 90 degrees clockwise.

**Brute — write each element into its new position in a copy.** The element in row i and column j moves to row j and column N − 1 − i, so the method writes every element into its rotated position in a second matrix and then copies the result back element by element. Copying element by element is necessary, because assigning the new matrix to the parameter would not change the matrix the caller passed in.

- **Time:** O(N²).
- **Extra space:** O(N²) for the copy.

**Optimal — transpose, then reverse every row.** Transposing swaps rows and columns: the method swaps the element in row i and column j with the one in row j and column i, but only for the cells below the main diagonal. Reversing each row afterwards completes a clockwise rotation, all in place.

- **Time:** O(N²).
- **Extra space:** O(1).

**Remember:** when transposing, swap each pair only once by walking just one triangle of the matrix; swapping every pair would swap them twice and put the matrix back where it started. Transposing and then reversing each row rotates clockwise, while transposing and then reversing each column rotates anticlockwise.

## Count subarrays with sum K
**File:** [SubArraysSumK.java](SubArraysSumK.java), methods `subArraysSumK_brute`, `subArraysSumK_optimal` and `SubArraysSumKIfNumsOnlyPositive`

**Question.** Count how many contiguous subarrays add up to exactly K.

**Brute — every subarray with a running sum.** For every starting position, the method extends the subarray one element at a time with a running sum and counts each time the sum equals K.

- **Time:** O(N²).
- **Extra space:** O(1).

**Optimal — prefix sums with a count of each one.** While walking the array, the method keeps the prefix sum and a hash map from each prefix sum to how many times it has appeared. If an earlier prefix sum equals the current prefix sum minus K, the elements after it up to the current position add up to K, so the count grows by the number of times that earlier prefix sum appeared. The map starts with a prefix sum of 0 recorded once, which accounts for subarrays that begin at the very first element.

- **Time:** O(N) on average.
- **Extra space:** O(N) for the map.

**Sliding window — only when every number is positive.** Two pointers mark a window. The right pointer adds one element at a time, the left pointer removes elements from the front while the sum is larger than K, and a match is counted whenever the sum equals K.

- **Time:** O(N).
- **Extra space:** O(1).

**Remember:** start the map with a prefix sum of 0 seen once; without it, every subarray that begins at the first element is missed. Unlike "Longest subarray with sum K", which keeps only the first position of each prefix sum, this problem has to count every occurrence. The sliding window fails as soon as zeros or negative numbers appear, because then one right edge can have several valid left edges.

## Spiral traversal of a matrix
**File:** [SpiralMatrix.java](SpiralMatrix.java), method `elementsOfMatrixInSpiralManner`

**Question.** Return all the elements of a matrix in spiral order: along the top row, down the right side, back along the bottom row, up the left side, and inwards.

**Optimal — four shrinking boundaries.** The method keeps four boundaries: top, bottom, left and right. In each round it reads the top row from left to right and moves top down, reads the right column from top to bottom and moves right inwards, then reads the bottom row from right to left and moves bottom up, and finally reads the left column from bottom to top and moves left inwards. The rounds continue while the boundaries have not crossed.

- **Time:** O(N × M) — every element is read once.
- **Extra space:** O(1) apart from the result list.

**Remember:** check that top has not passed bottom before reading the bottom row, and that left has not passed right before reading the left column. Without those two checks, a rectangular matrix such as a single row gets read twice, once going right and once coming back.
