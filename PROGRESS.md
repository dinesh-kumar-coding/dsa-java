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
| Quick sort | step02-sorting/QuickSort.java | partition | ✅ | |

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

## Step 3 — Arrays (medium)
| Problem | File | Approaches | Status | Revisit |
|---|---|---|---|---|
| Two sum | step03-arrays/medium/TwoSum.java | HashMap + two pointers | ✅ | |
| Sort colors (0/1/2) | step03-arrays/medium/SortColors.java | Dutch national flag | ✅ | |
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

## Step 3 — Arrays (hard)
| Problem | File | Approaches | Status | Revisit |
|---|---|---|---|---|
| Pascal's Triangle | step03-arrays/hard/PascalTriangle.java | brute individual nCr O(N³) · optimal math recurrence O(N²) | ✅ | |
| Majority Element II (>n/3) | step03-arrays/hard/MajorityElement_2.java | brute HashMap O(N)/O(N) · optimal extended Boyer-Moore O(N)/O(1) | ✅ | |
| 3-Sum | step03-arrays/hard/ThreeSum.java | brute 3-loops O(N³) · better hashing O(N²)/O(N) · optimal sort + two-pointers O(N²)/O(1) | ✅ | |
| 4-Sum | step03-arrays/hard/FourSum.java | brute 4-loops O(N⁴) · better hashing O(N³)/O(N) · optimal two-pointers O(N³)/O(1) | ✅ | |
| Longest subarray with sum 0 | step03-arrays/hard/LongestSubArrayWithSumZero.java | optimal prefix-sum + HashMap O(N)/O(N) | ✅ | |
| Count subarrays with XOR = K | step03-arrays/hard/SubArrayWithXOR_K.java | optimal prefix-XOR + HashMap O(N)/O(N) | ✅ | |

## Step 4 — Binary Search ← current

### Binary search on 1D arrays (Binary-1D/)
| Problem | File | Approaches | Status | Revisit |
|---|---|---|---|---|
| Binary search fundamentals | step04-binary-search/Binary-1D/BinarySearch.java | iterative + recursive · lower bound · upper bound | ✅ | |
| Search insert · floor · ceil | step04-binary-search/Binary-1D/SearchInsertFloorCeil.java | lower/upper-bound cousins | ✅ | |
| First & last occurrence · count | step04-binary-search/Binary-1D/FirstLastCountOccurrence.java | first/last via bounds; count = last−first+1 | ✅ | |
| Single element in sorted array | step04-binary-search/Binary-1D/SingleElementInSortedArr.java | brute XOR O(N) · optimal binary search O(log N) | ✅ | |
| Search in rotated sorted array I & II | step04-binary-search/Binary-1D/SearchElementInRotArr.java | binary search (shrink bounds on duplicates) O(log N) avg / O(N) worst | ✅ | |
| Minimum in rotated sorted array I & II | step04-binary-search/Binary-1D/MinInRotArr.java | binary search on the sorted half O(log N) avg / O(N) worst | ✅ | |
| Number of times array is rotated | step04-binary-search/Binary-1D/TimesSortArrRot.java | binary search → index of min O(log N) avg / O(N) worst | ✅ | |
| Find peak element | step04-binary-search/Binary-1D/PeakElement.java | binary search on the slope O(log N) | ✅ | |

### Binary search on answers (Binary-On-Answers/)
| Problem | File | Approaches | Status | Revisit |
|---|---|---|---|---|
| Square root / Nth root | step04-binary-search/Binary-On-Answers/NthRoot.java | binary search on the answer space O(N·log M) | ✅ | |
| Koko Eating Bananas | step04-binary-search/Binary-On-Answers/KokoEatingBanana.java | brute linear search O(N · maxVal) · optimal binary search on answer O(N log(maxVal)) SC:O(1) | ✅ | |
| Find the Smallest Divisor Given a Threshold | step04-binary-search/Binary-On-Answers/SmallerDivisor.java | optimal binary search on answer O(N log(maxVal)) SC:O(1) | ✅ | |

### Binary search on 2D matrices (Binary-2D/)
| Problem | File | Approaches | Status | Revisit |
|---|---|---|---|---|
| Search in a 2D matrix | step04-binary-search/Binary-2D/SearchIn2DMatrix.java | flattened binary search O(log(M·N)) | ✅ | |
| Row with maximum 1s | step04-binary-search/Binary-2D/RowWithMaximumOnes.java | brute O(M·N) · optimal binary search per row O(M·log N) | ✅ | |
| Search in a 2D Matrix II | step04-binary-search/Binary-2D/SearchIn2DMatrixII.java | better BS per row O(M log N) · optimal step-wise search O(M + N) SC:O(1) | ✅ | |

### Step-15 - Graphs

### Graph Learning (Learning/)
| Problem | File | Approaches | Status | Revisit |
|---|---|---|---|---|
| Graph Representation - Adjacency Matrix | step15-graphs/learning/ | Matrix O(V²) SC:O(V²) | ✅ | |
| Graph Representation - Adjacency List | step15-graphs/learning/ | List O(V+E) SC:O(V+E) | ✅ | |
| BFS of Graph | step15-graphs/learning/Traversals.java | queue based O(V + E) SC:O(V) | ✅ | |
| DFS of Graph | step15-graphs/learning/Traversals.java | recursion based O(V + E) SC:O(V) | ✅ | |
| Count the Number of Complete Components | step15-graphs/learning/ConnectedComponents.java | optimal BFS degree counting O(V + E) SC:O(V + E) | ✅ | |

### Problems-On-Traversal
| Problem | File | Approaches | Status | Revisit |
|---|---|---|---|---|
| Number of Provinces | step15-graphs/learning/NumberOfProvinces.java | optimal DFS on adjacency matrix O(V²) SC:O(V) | ✅ verified | |

## LeetCode extras
| Problem | File | Approaches | Status | Revisit |
|---|---|---|---|---|
| GCD sum (daily, Jul 16) | leetcode/GcdSum_20260716.java | prefix max + prefix gcd | ✅ | |
| Find GCD of min & max (daily, Jul 18) | leetcode/FindGcd_20260718.java | min/max scan + Euclid | ✅ | |
| Max product of two elements (daily, Jul 27) | leetcode/MaxProduct_20260727.java | single pass — track top two, `(max-1)*(secondMax-1)` | ✅ | |
| Min pushes to type word I (daily, Jul 30) | leetcode/MinNumOfPushesToTypeWord_1_20260730.java | greedy length-brackets (1/2/3/4 pushes) | ✅ | |
| Min pushes to type word II (daily, Jul 31) | leetcode/MinNumOfPushesToTypeWord_2_20260730.java | freq count + sort desc → bucket into 1/2/3/4-push tiers | ✅ | |
