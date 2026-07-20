# DSA progress log — Striver A2Z + LeetCode (Java)

Rules: brute → better → optimal for every problem. Re-solve each medium 3–4 days later (fill Revisit).
Legend: ✅ done · 🔁 due for revisit · ⚠️ known bug (fix session pending) · 🔨 in progress

## Step 1 — Basics
| Problem | File | Approaches | Status | Revisit |
|---|---|---|---|---|
| Reverse number, palindrome, armstrong, divisors, prime, GCD | step01-basics/BasicMaths.java | loops + Euclidean GCD, overflow guards | ✅ | |
| Recursion drills (print 1..N, N..1, backtracking, sum, factorial, reverse array, palindrome) | step01-basics/Recursion.java | recursion + backtracking variants | ✅ | |
| Hashing (array, char, HashMap, frequency, highest occurring) | step01-basics/Hashing.java | precompute + fetch pattern | ✅ | |

## Step 2 — Sorting
| Problem | File | Approaches | Status | Revisit |
|---|---|---|---|---|
| Selection sort | step02-sorting/SelectionSort.java | O(N^2) | ✅ | |
| Bubble sort | step02-sorting/BubbleSort.java | iterative + recursive, early exit | ✅ | |
| Insertion sort | step02-sorting/InsertionSort.java | iterative + recursive | ✅ | |
| Merge sort | step02-sorting/MergeSort.java | O(N log N) | ✅ | |
| Quick sort | step02-sorting/QuickSort.java | partition (buggy) | ⚠️ infinite-loop bug | |

## Step 3 — Arrays (easy)
| Problem | File | Approaches | Status | Revisit |
|---|---|---|---|---|
| Largest element | step03-arrays/easy/LargestElement.java | O(N) | ✅ | |
| Second largest/smallest | step03-arrays/easy/SecondLargestSmallest.java | single pass | ✅ | |
| Remove duplicates (sorted) | step03-arrays/easy/RemoveDuplicatesSorted.java | two pointers | ✅ | |
| Check sorted | step03-arrays/easy/CheckSorted.java | O(N) | ✅ | |
| Rotate by K | step03-arrays/easy/RotateArray.java | reversal algorithm | ✅ | |
| Move zeros | step03-arrays/easy/MoveZeros.java | brute + optimal two pointers | ✅ | |
| Union + intersection (sorted) | step03-arrays/easy/UnionIntersectionSorted.java | two pointers | ✅ | |
| Missing number | step03-arrays/easy/MissingNumber.java | XOR | ✅ | |
| Single number | step03-arrays/easy/SingleNumber.java | XOR | ✅ | |
| Longest subarray sum K | step03-arrays/easy/LongestSubarraySumK.java | brute + prefix-hash + two pointers | ✅ | |

## Step 3 — Arrays (medium) ← current
| Problem | File | Approaches | Status | Revisit |
|---|---|---|---|---|
| Two sum | step03-arrays/medium/TwoSum.java | HashMap + two pointers | ✅ | |
| Sort colors (0/1/2) | step03-arrays/medium/SortColors.java | Dutch national flag | ✅ |
| Majority element | step03-arrays/medium/MajorityElement.java | HashMap + Boyer-Moore | ✅ | |
| Maximum subarray sum (Kadane's) | step03-arrays/medium/MaximumSubarraySum.java | Kadane + print-subarray variant | ✅ | |
| Best time to buy & sell stock | step03-arrays/medium/StockBuySell.java | min-so-far single pass | ✅ | |
| Rearrange by sign | step03-arrays/medium/RearrangeBySign.java | brute + optimal O(N) | ✅ | |
| Next permutation | step03-arrays/medium/NextPermutation.java | 3-step: break point, swap, reverse suffix | ✅ | |
| Leaders in array | step03-arrays/medium/LeadersInArray.java | right-to-left running max | ✅ | |

## LeetCode extras
| Problem | File | Approaches | Status | Revisit |
|---|---|---|---|---|
| GCD sum (daily, Jul 16) | leetcode/GcdSum_20260716.java | prefix max + prefix gcd | ✅ | |
| Find GCD of min & max (daily, Jul 18) | leetcode/FindGcd_20260718.java | min/max scan + Euclid | ✅ | |
