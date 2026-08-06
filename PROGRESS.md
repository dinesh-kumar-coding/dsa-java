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
| Quick sort | step02-sorting/QuickSort.java | partition (buggy) | ✅ | |

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
| Longest consecutive sequence | step03-arrays/medium/LongestConsecutiveSequence.java | brute (linear search) · better (sort) · optimal (HashSet) | ✅ | |
| Set matrix zeroes | step03-arrays/medium/SetMatrixZeroes.java | brute (marker) · better (row/col arrays) · optimal (in-place markers) | ✅ | |
| Rotate matrix by 90° | step03-arrays/medium/RotateMatrix.java | brute (index map) · optimal (transpose + reverse rows) | ✅ | |
| Count subarrays with sum K | step03-arrays/medium/SubArraysSumK.java | brute O(N²) · optimal prefix+HashMap O(N) · sliding window (positive only) | ✅ | |
| Spiral matrix | step03-arrays/medium/SpiralMatrix.java | 4-boundary traversal (left/right/top/bottom) | ✅ | |
| Pascal Triangle | step03-arrays/hard/PascalTriangle.java | brute individual nCr O(N³) · optimal math recurrence O(N²) | ✅ | |
| Single Element in Sorted Array | step03-arrays/hard/SingleElementInSortedArr.java | brute XOR O(N) · optimal binary search O(log N) | ✅ | |
| Majority Element II | step03-arrays/hard/MajorityElement_2.java | brute HashMap O(N) SC:O(N) · optimal Boyer-Moore Voting O(N) SC:O(1) | ✅ | |
| Three Sum | step03-arrays/medium/ThreeSum.java | brute 3-loops O(N³) · better Hashing O(N²) SC:O(N) · optimal Two-Pointers O(N²) SC:O(1) | ✅ verified | |
| Four Sum | step03-arrays/medium/FourSum.java | brute 4-loops O(N⁴) · better Hashing O(N³) SC:O(N) · optimal Two-Pointers O(N³) SC:O(1) | ✅ verified | |

## Step 4 — Binary Search ← current
| Problem | File | Approaches | Status | Revisit |
|---|---|---|---|---|
| Binary search fundamentals | step04-binary-search/BinarySearch.java | iterative + recursive · lower bound · upper bound | ✅ | |
| Search insert · floor · ceil | step04-binary-search/SearchInsertFloorCeil.java | lower/upper-bound cousins | ✅ | |
| First & last occurrence · count | step04-binary-search/FirstLastCountOccurrence.java | first/last via bounds; count = last−first+1 | ✅ | |

## LeetCode extras
| Problem | File | Approaches | Status | Revisit |~
|---|---|---|---|---|
| GCD sum (daily, Jul 16) | leetcode/GcdSum_20260716.java | prefix max + prefix gcd | ✅ | |
| Find GCD of min & max (daily, Jul 18) | leetcode/FindGcd_20260718.java | min/max scan + Euclid | ✅ | |
| Max product of two elements (daily, Jul 27) | leetcode/MaxProduct_20260727.java | single pass — track top two, `(max-1)*(secondMax-1)` | ✅ | |
| Min pushes to type word I (daily, Jul 30) | leetcode/MinNumOfPushesToTypeWord_1_20260730.java | greedy length-brackets (1/2/3/4 pushes) | ✅ | |
| Min pushes to type word II (daily, Jul 31) | leetcode/MinNumOfPushesToTypeWord_2_20260730.java | freq count + sort desc → bucket into 1/2/3/4-push tiers | ✅ | |
