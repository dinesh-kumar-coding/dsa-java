# DSA progress log — Striver A2Z (Java)

Every problem name links to its full notes in the README of its folder: the question, each approach in the file with its time and extra space, and the traps to remember. The Idea column is the one-sentence version.

Rules: aim for brute → better → optimal on every problem; an approach that is not written yet is listed under "Not in the file yet" in the notes. Re-solve each medium 3–4 days later (fill Revisit).

Legend: ✅ done · 🔁 due for revisit · 🔨 in progress

## Step 1 — Basics

### Basic maths (BasicMaths.java)
| Problem | File | Idea | Status | Revisit |
|---|---|---|---|---|
| [Reverse a number](striver-a2z/step01-basics/README.md#reverse-a-number) | step01-basics/BasicMaths.java | Peel digits off the end of the number one at a time and append each one to a new number. | ✅ | |
| [Check if a number is a palindrome](striver-a2z/step01-basics/README.md#check-if-a-number-is-a-palindrome) | step01-basics/BasicMaths.java | Reverse the number and compare the result with the original. | ✅ | |
| [Check if a number is an Armstrong number](striver-a2z/step01-basics/README.md#check-if-a-number-is-an-armstrong-number) | step01-basics/BasicMaths.java | Raise every digit to the power of the digit count, add them up, and compare the total with the original. | ✅ | |
| [Find all divisors of a number](striver-a2z/step01-basics/README.md#find-all-divisors-of-a-number) | step01-basics/BasicMaths.java | Divisors come in pairs, so test only up to the square root and collect both members of each pair. | ✅ | |
| [Check if a number is prime](striver-a2z/step01-basics/README.md#check-if-a-number-is-prime) | step01-basics/BasicMaths.java | Look for any divisor between 2 and the square root; finding none means the number is prime. | ✅ | |
| [Greatest common divisor of two numbers](striver-a2z/step01-basics/README.md#greatest-common-divisor-of-two-numbers) | step01-basics/BasicMaths.java | Keep replacing the larger number with the remainder of dividing it by the smaller one until one of them becomes zero. | ✅ | |

### Basic recursion (Recursion.java)
| Problem | File | Idea | Status | Revisit |
|---|---|---|---|---|
| [Print 1 to N using recursion](striver-a2z/step01-basics/README.md#print-1-to-n-using-recursion) | step01-basics/Recursion.java | Print the current number and let the next call print the rest, or recurse first and print while the calls return. | ✅ | |
| [Print N to 1 using recursion](striver-a2z/step01-basics/README.md#print-n-to-1-using-recursion) | step01-basics/Recursion.java | The same two patterns as printing 1 to N, with the direction of the counter reversed. | ✅ | |
| [Sum of the first N numbers](striver-a2z/step01-basics/README.md#sum-of-the-first-n-numbers) | step01-basics/Recursion.java | The sum up to N is N plus the sum up to N − 1, ending at zero. | ✅ | |
| [Factorial of N](striver-a2z/step01-basics/README.md#factorial-of-n) | step01-basics/Recursion.java | The factorial of N is N times the factorial of N − 1, ending at 1. | ✅ | |
| [Reverse an array using recursion](striver-a2z/step01-basics/README.md#reverse-an-array-using-recursion) | step01-basics/Recursion.java | Swap the two ends, then reverse whatever is left between them. | ✅ | |
| [Check if a string is a palindrome](striver-a2z/step01-basics/README.md#check-if-a-string-is-a-palindrome) | step01-basics/Recursion.java | Compare characters from both ends moving inwards, either with a loop or with recursion. | ✅ | |

### Basic hashing (Hashing.java)
| Problem | File | Idea | Status | Revisit |
|---|---|---|---|---|
| [Number hashing with an array](striver-a2z/step01-basics/README.md#number-hashing-with-an-array) | step01-basics/Hashing.java | Count every number once into an array indexed by the number itself, then answer each query by reading one slot. | ✅ | |
| [Character hashing with an array](striver-a2z/step01-basics/README.md#character-hashing-with-an-array) | step01-basics/Hashing.java | Count every character into an array of 256 slots, using the character's numeric code as the position. | ✅ | |
| [Hashing with a HashMap](striver-a2z/step01-basics/README.md#hashing-with-a-hashmap) | step01-basics/Hashing.java | Count with a map from each value to how often it appears, which works for any value, including negative or very large ones. | ✅ | |
| [Frequency of every element in an array](striver-a2z/step01-basics/README.md#frequency-of-every-element-in-an-array) | step01-basics/Hashing.java | Count each element in a map, then print every value with its count. | ✅ | |
| [Highest-frequency element in an array](striver-a2z/step01-basics/README.md#highest-frequency-element-in-an-array) | step01-basics/Hashing.java | Count each element in a map, then scan the counts for the largest one. | ✅ | |

## Step 2 — Sorting
| Problem | File | Idea | Status | Revisit |
|---|---|---|---|---|
| [Selection sort](striver-a2z/step02-sorting/README.md#selection-sort) | step02-sorting/SelectionSort.java | Repeatedly find the smallest remaining element and swap it into the next position. | ✅ | |
| [Bubble sort](striver-a2z/step02-sorting/README.md#bubble-sort) | step02-sorting/BubbleSort.java | Keep swapping neighbours that are out of order so the largest element drifts to the end, and stop early when a pass makes no swaps. | ✅ | |
| [Insertion sort](striver-a2z/step02-sorting/README.md#insertion-sort) | step02-sorting/InsertionSort.java | Grow a sorted section from the left, sliding each new element back until it sits in the right place. | ✅ | |
| [Merge sort](striver-a2z/step02-sorting/README.md#merge-sort) | step02-sorting/MergeSort.java | Split the array in half, sort each half recursively, and merge the two sorted halves. | ✅ | |
| [Quick sort](striver-a2z/step02-sorting/README.md#quick-sort) | step02-sorting/QuickSort.java | Put one pivot in its final position, with nothing larger on its left and nothing smaller on its right, then sort each side the same way. | ✅ | |

## Step 3 — Arrays

### Easy problems (easy/)
| Problem | File | Idea | Status | Revisit |
|---|---|---|---|---|
| [Largest element in an array](striver-a2z/step03-arrays/easy/README.md#largest-element-in-an-array) | step03-arrays/easy/LargestElement.java | Walk the array once, keeping the largest value seen so far. | ✅ | |
| [Second largest and second smallest element](striver-a2z/step03-arrays/easy/README.md#second-largest-and-second-smallest-element) | step03-arrays/easy/SecondLargestSmallest.java | Keep the largest and second largest in one pass, moving the old largest down whenever a new one arrives, and mirror the comparisons for the two smallest. | ✅ | |
| [Remove duplicates from a sorted array](striver-a2z/step03-arrays/easy/README.md#remove-duplicates-from-a-sorted-array) | step03-arrays/easy/RemoveDuplicatesSorted.java | Keep one pointer on the last unique value and let a second pointer scan ahead, copying each new value into the next slot. | ✅ | |
| [Check if an array is sorted](striver-a2z/step03-arrays/easy/README.md#check-if-an-array-is-sorted) | step03-arrays/easy/CheckSorted.java | Compare every element with the one before it; a single drop means the array is not sorted. | ✅ | |
| [Check if an array is sorted and rotated](striver-a2z/step03-arrays/easy/README.md#check-if-an-array-is-sorted-and-rotated) | step03-arrays/easy/CheckSorted.java | Find the place where the values drop, rotate the array back with three reversals, and check whether the result is sorted. | ✅ | |
| [Rotate an array by K places](striver-a2z/step03-arrays/easy/README.md#rotate-an-array-by-k-places) | step03-arrays/easy/RotateArray.java | Reduce K modulo the length, then reverse the two blocks and the whole array, in the order that matches the direction. | ✅ | |
| [Move all zeros to the end](striver-a2z/step03-arrays/easy/README.md#move-all-zeros-to-the-end) | step03-arrays/easy/MoveZeros.java | Let one pointer mark where the next non-zero element belongs and swap each non-zero element into that spot as the other pointer scans. | ✅ | |
| [Union of two sorted arrays](striver-a2z/step03-arrays/easy/README.md#union-of-two-sorted-arrays) | step03-arrays/easy/UnionIntersectionSorted.java | Merge the arrays with two pointers, as in merge sort, adding a value only if it differs from the last one added. | ✅ | |
| [Intersection of two sorted arrays](striver-a2z/step03-arrays/easy/README.md#intersection-of-two-sorted-arrays) | step03-arrays/easy/UnionIntersectionSorted.java | Walk both arrays with two pointers, moving the one on the smaller value, and record a value whenever both pointers hold the same one. | ✅ | |
| [Find the missing number](striver-a2z/step03-arrays/easy/README.md#find-the-missing-number) | step03-arrays/easy/MissingNumber.java | Take the exclusive or of every number from 1 to N and of every element; each number that is present cancels itself out, leaving the missing one. | ✅ | |
| [Find the number that appears once](striver-a2z/step03-arrays/easy/README.md#find-the-number-that-appears-once) | step03-arrays/easy/SingleNumber.java | Take the exclusive or of every element; each pair cancels itself out, leaving the single number. | ✅ | |
| [Longest subarray with sum K](striver-a2z/step03-arrays/easy/README.md#longest-subarray-with-sum-k) | step03-arrays/easy/LongestSubarraySumK.java | With negative numbers, look up the first position of the prefix sum minus K in a hash map; with no negative numbers, slide a window that shrinks whenever its sum passes K. | ✅ | |

### Medium problems (medium/)
| Problem | File | Idea | Status | Revisit |
|---|---|---|---|---|
| [Two Sum](striver-a2z/step03-arrays/medium/README.md#two-sum) | step03-arrays/medium/TwoSum.java | For each number, check a hash map for the partner that completes the target before storing the number with its index. | ✅ | |
| [Sort an array of 0s, 1s and 2s](striver-a2z/step03-arrays/medium/README.md#sort-an-array-of-0s-1s-and-2s) | step03-arrays/medium/SortColors.java | Grow a region of 0s at the front and a region of 2s at the back with three pointers, sorting everything in one pass. | ✅ | |
| [Majority element (more than half)](striver-a2z/step03-arrays/medium/README.md#majority-element-more-than-half) | step03-arrays/medium/MajorityElement_1.java | Keep a candidate and a count that goes up on a match and down on anything else; the majority survives every cancellation. | ✅ | |
| [Maximum subarray sum (Kadane's algorithm)](striver-a2z/step03-arrays/medium/README.md#maximum-subarray-sum-kadanes-algorithm) | step03-arrays/medium/MaximumSubarraySum.java | Keep a running sum, record the best sum seen, and reset the running sum to zero whenever it drops below zero. | ✅ | |
| [Best time to buy and sell a stock](striver-a2z/step03-arrays/medium/README.md#best-time-to-buy-and-sell-a-stock) | step03-arrays/medium/StockBuySell.java | Track the cheapest price so far and, on every day, check the profit of selling at that day's price. | ✅ | |
| [Rearrange array elements by sign](striver-a2z/step03-arrays/medium/README.md#rearrange-array-elements-by-sign) | step03-arrays/medium/RearrangeBySign.java | Write positive numbers into the even positions and negative numbers into the odd positions of a result array, or split and merge when the counts differ. | ✅ | |
| [Next permutation](striver-a2z/step03-arrays/medium/README.md#next-permutation) | step03-arrays/medium/NextPermutation.java | Find the rightmost value smaller than the one after it, swap it with the smallest larger value to its right, and reverse everything after its position. | ✅ | |
| [Leaders in an array](striver-a2z/step03-arrays/medium/README.md#leaders-in-an-array) | step03-arrays/medium/LeadersInArray.java | Scan from the right with a running maximum; every element larger than everything to its right is a leader. | ✅ | |
| [Longest consecutive sequence](striver-a2z/step03-arrays/medium/README.md#longest-consecutive-sequence) | step03-arrays/medium/LongestConsecutiveSequence.java | Put every number in a hash set and only count a run starting from a number whose predecessor is missing. | ✅ | |
| [Set matrix zeroes](striver-a2z/step03-arrays/medium/README.md#set-matrix-zeroes) | step03-arrays/medium/SetMatrixZeroes.java | Use the first row and first column as markers for the rows and columns to clear, remembering separately whether they held a zero themselves. | ✅ | |
| [Rotate a matrix by 90 degrees](striver-a2z/step03-arrays/medium/README.md#rotate-a-matrix-by-90-degrees) | step03-arrays/medium/RotateMatrix.java | Transpose the matrix, then reverse every row. | ✅ | |
| [Count subarrays with sum K](striver-a2z/step03-arrays/medium/README.md#count-subarrays-with-sum-k) | step03-arrays/medium/SubArraysSumK.java | Keep a running prefix sum and add how many earlier prefix sums equal the current one minus K, counting them in a hash map. | ✅ | |
| [Spiral traversal of a matrix](striver-a2z/step03-arrays/medium/README.md#spiral-traversal-of-a-matrix) | step03-arrays/medium/SpiralMatrix.java | Walk the top row, the right column, the bottom row and the left column in turn, shrinking each boundary after it is used. | ✅ | |

### Hard problems (hard/)
| Problem | File | Idea | Status | Revisit |
|---|---|---|---|---|
| [Pascal's triangle](striver-a2z/step03-arrays/hard/README.md#pascals-triangle) | step03-arrays/hard/PascalTriangle.java | Build each row from left to right, multiplying the previous value by (row − position) and dividing by (position + 1). | ✅ | |
| [Majority element (more than a third)](striver-a2z/step03-arrays/hard/README.md#majority-element-more-than-a-third) | step03-arrays/hard/MajorityElement_2.java | Run Boyer-Moore voting with two candidates, then count both candidates again to confirm them. | ✅ | |
| [3-Sum](striver-a2z/step03-arrays/hard/README.md#3-sum) | step03-arrays/hard/ThreeSum.java | Sort the array, fix one number, and close in on the other two with two pointers, skipping repeated values. | ✅ | |
| [4-Sum](striver-a2z/step03-arrays/hard/README.md#4-sum) | step03-arrays/hard/FourSum.java | Sort the array, fix two numbers, and close in on the other two with two pointers, skipping repeated values. | ✅ | |
| [Longest subarray with sum 0](striver-a2z/step03-arrays/hard/README.md#longest-subarray-with-sum-0) | step03-arrays/hard/LongestSubArrayWithSumZero.java | Remember the first position of every prefix sum; when a prefix sum repeats, the elements in between add up to zero. | ✅ | |
| [Count subarrays with XOR equal to K](striver-a2z/step03-arrays/hard/README.md#count-subarrays-with-xor-equal-to-k) | step03-arrays/hard/SubArrayWithXOR_K.java | Keep a running exclusive or of the prefix and add how many earlier prefixes equal the current value combined with K by exclusive or, counting them in a hash map. | ✅ | |
| [Merge two sorted arrays without extra space](striver-a2z/step03-arrays/hard/README.md#merge-two-sorted-arrays-without-extra-space) | step03-arrays/hard/MergeTwoSortedArray.java | Swap the largest values of the first array with the smallest values of the second until the boundary pair is in order and sort both, or compare elements a shrinking gap apart. | ✅ | |
| [Merge sorted array (LeetCode 88)](striver-a2z/step03-arrays/hard/README.md#merge-sorted-array-leetcode-88) | step03-arrays/hard/MergeTwoSortedArray.java | Fill the first array from the back, placing the larger of the two last unplaced elements each time. | ✅ | |
| [Maximum product subarray](striver-a2z/step03-arrays/hard/README.md#maximum-product-subarray) | step03-arrays/hard/MaxProductSubArray.java | Multiply from both ends at once, restarting a product at 1 after a zero, and keep the largest product seen. | ✅ | |

## Step 4 — Binary Search

### Binary search on one-dimensional arrays (Binary-1D/)
| Problem | File | Idea | Status | Revisit |
|---|---|---|---|---|
| [Binary search for a target](striver-a2z/step04-binary-search/Binary-1D/README.md#binary-search-for-a-target) | step04-binary-search/Binary-1D/BinarySearch.java | Compare the target with the middle element and throw away the half that cannot contain it. | ✅ | |
| [Lower bound](striver-a2z/step04-binary-search/Binary-1D/README.md#lower-bound) | step04-binary-search/Binary-1D/BinarySearch.java | Find the first position whose value is at least the target, recording each candidate and searching further left. | ✅ | |
| [Upper bound](striver-a2z/step04-binary-search/Binary-1D/README.md#upper-bound) | step04-binary-search/Binary-1D/BinarySearch.java | Find the first position whose value is strictly greater than the target, using the lower-bound search with a strict comparison. | ✅ | |
| [Search insert position](striver-a2z/step04-binary-search/Binary-1D/README.md#search-insert-position) | step04-binary-search/Binary-1D/SearchInsertFloorCeil.java | Return the lower bound, the first position whose value is at least the target. | ✅ | |
| [Floor and ceil in a sorted array](striver-a2z/step04-binary-search/Binary-1D/README.md#floor-and-ceil-in-a-sorted-array) | step04-binary-search/Binary-1D/SearchInsertFloorCeil.java | Find the largest value at most the target and the smallest value at least the target with two mirror-image binary searches. | ✅ | |
| [First and last occurrence](striver-a2z/step04-binary-search/Binary-1D/README.md#first-and-last-occurrence) | step04-binary-search/Binary-1D/FirstLastCountOccurrence.java | Keep binary searching after a match, to the left for the first copy and to the right for the last. | ✅ | |
| [Count occurrences](striver-a2z/step04-binary-search/Binary-1D/README.md#count-occurrences) | step04-binary-search/Binary-1D/FirstLastCountOccurrence.java | Subtract the first position from the last position and add one. | ✅ | |
| [Single element in a sorted array](striver-a2z/step04-binary-search/Binary-1D/README.md#single-element-in-a-sorted-array) | step04-binary-search/Binary-1D/SingleElementInSortedArr.java | Binary search for the side of the middle pair that holds an odd number of elements, because the single element always sits there. | ✅ | |
| [Search in a rotated sorted array](striver-a2z/step04-binary-search/Binary-1D/README.md#search-in-a-rotated-sorted-array) | step04-binary-search/Binary-1D/SearchElementInRotArr.java | One half is always sorted, so check whether the target lies inside that half and search there or in the other half. | ✅ | |
| [Search in a rotated sorted array with duplicates](striver-a2z/step04-binary-search/Binary-1D/README.md#search-in-a-rotated-sorted-array-with-duplicates) | step04-binary-search/Binary-1D/SearchElementInRotArr.java | Search as without duplicates, but shrink both ends by one whenever the low, middle and high values are equal. | ✅ | |
| [Minimum in a rotated sorted array](striver-a2z/step04-binary-search/Binary-1D/README.md#minimum-in-a-rotated-sorted-array) | step04-binary-search/Binary-1D/MinInRotArr.java | Compare the middle with the right end; if the middle is larger, the minimum lies to its right, otherwise at the middle or to its left. | ✅ | |
| [Minimum in a rotated sorted array with duplicates](striver-a2z/step04-binary-search/Binary-1D/README.md#minimum-in-a-rotated-sorted-array-with-duplicates) | step04-binary-search/Binary-1D/MinInRotArr.java | Search as without duplicates, but shrink the right end by one whenever the middle and the right end are equal. | ✅ | |
| [Number of times a sorted array has been rotated](striver-a2z/step04-binary-search/Binary-1D/README.md#number-of-times-a-sorted-array-has-been-rotated) | step04-binary-search/Binary-1D/TimesSortArrRot.java | Find the position of the smallest element; that position is the number of rotations. | ✅ | |
| [Find a peak element](striver-a2z/step04-binary-search/Binary-1D/README.md#find-a-peak-element) | step04-binary-search/Binary-1D/PeakElement.java | Compare the middle with its right neighbour and move towards the larger side, because a peak always lies uphill. | ✅ | |

### Binary search on answers (Binary-On-Answers/)
| Problem | File | Idea | Status | Revisit |
|---|---|---|---|---|
| [Nth root of a number](striver-a2z/step04-binary-search/Binary-On-Answers/README.md#nth-root-of-a-number) | step04-binary-search/Binary-On-Answers/NthRoot.java | Binary search the whole numbers from 1 to M for one whose Nth power equals M. | ✅ | |
| [Koko eating bananas](striver-a2z/step04-binary-search/Binary-On-Answers/README.md#koko-eating-bananas) | step04-binary-search/Binary-On-Answers/KokoEatingBanana.java | Binary search the eating speed between 1 and the largest pile for the slowest speed that still finishes within the given hours. | ✅ | |
| [Smallest divisor given a threshold](striver-a2z/step04-binary-search/Binary-On-Answers/README.md#smallest-divisor-given-a-threshold) | step04-binary-search/Binary-On-Answers/SmallerDivisor.java | Binary search the divisor between 1 and the largest element for the smallest one whose total of rounded-up quotients stays within the threshold. | ✅ | |
| [Minimum days to make M bouquets](striver-a2z/step04-binary-search/Binary-On-Answers/README.md#minimum-days-to-make-m-bouquets) | step04-binary-search/Binary-On-Answers/MinDaysToMakeBouquets.java | Binary search the day between the earliest and latest bloom for the first day with enough runs of K neighbouring bloomed flowers. | ✅ | |

### Binary search on two-dimensional arrays (Binary-2D/)
| Problem | File | Idea | Status | Revisit |
|---|---|---|---|---|
| [Search in a 2D matrix](striver-a2z/step04-binary-search/Binary-2D/README.md#search-in-a-2d-matrix) | step04-binary-search/Binary-2D/SearchIn2DMatrix.java | Treat the matrix as one sorted array and turn each middle index back into a row and a column. | ✅ | |
| [Row with the maximum number of 1s](striver-a2z/step04-binary-search/Binary-2D/README.md#row-with-the-maximum-number-of-1s) | step04-binary-search/Binary-2D/RowWithMaximumOnes.java | In each sorted row, binary search for the first 1 to count the 1s, and keep the row with the most. | ✅ | |
| [Search in a 2D matrix II](striver-a2z/step04-binary-search/Binary-2D/README.md#search-in-a-2d-matrix-ii) | step04-binary-search/Binary-2D/SearchIn2DMatrixII.java | Start at the bottom-left corner and move up when the value is too large or right when it is too small. | ✅ | |

## Step 8 — Linked List

### Learn the singly linked list (Learn-Singly-LL/)
| Problem | File | Idea | Status | Revisit |
|---|---|---|---|---|
| [Convert an array to a linked list and print it](striver-a2z/step08-linkedlist/Learn-Singly-LL/README.md#convert-an-array-to-a-linked-list-and-print-it) | step08-linkedlist/Learn-Singly-LL/SinglyLL_Basics.java | Create the head from the first element, then keep attaching each new node after the current last node. | ✅ | |
| [Length of a linked list](striver-a2z/step08-linkedlist/Learn-Singly-LL/README.md#length-of-a-linked-list) | step08-linkedlist/Learn-Singly-LL/SinglyLL_Basics.java | Walk from the head to the end, counting the nodes. | ✅ | |
| [Search for a value in a linked list](striver-a2z/step08-linkedlist/Learn-Singly-LL/README.md#search-for-a-value-in-a-linked-list) | step08-linkedlist/Learn-Singly-LL/SinglyLL_Basics.java | Walk from the head, comparing each node's value, and stop at the first match. | ✅ | |
| [Delete a node from a linked list](striver-a2z/step08-linkedlist/Learn-Singly-LL/README.md#delete-a-node-from-a-linked-list) | step08-linkedlist/Learn-Singly-LL/SinglyLL_Basics.java | Stop at the node before the one to delete and point its next past it; deleting the head just moves the head forward. | ✅ | |
| [Insert a node into a linked list](striver-a2z/step08-linkedlist/Learn-Singly-LL/README.md#insert-a-node-into-a-linked-list) | step08-linkedlist/Learn-Singly-LL/SinglyLL_Basics.java | Stop at the node before the position, point the new node at that node's next, and then point that node at the new one. | ✅ | |

### Learn the doubly linked list (Learn-Doubly-LL/)
| Problem | File | Idea | Status | Revisit |
|---|---|---|---|---|
| [Convert an array to a doubly linked list and print it](striver-a2z/step08-linkedlist/Learn-Doubly-LL/README.md#convert-an-array-to-a-doubly-linked-list-and-print-it) | step08-linkedlist/Learn-Doubly-LL/DoublyLL_Basics.java | Attach each new node after the last one in both directions, so the old last node points forward to it and it points back to the old last node. | ✅ | |
| [Length of a doubly linked list](striver-a2z/step08-linkedlist/Learn-Doubly-LL/README.md#length-of-a-doubly-linked-list) | step08-linkedlist/Learn-Doubly-LL/DoublyLL_Basics.java | Walk from the head to the end, counting the nodes. | ✅ | |
| [Search for a value in a doubly linked list](striver-a2z/step08-linkedlist/Learn-Doubly-LL/README.md#search-for-a-value-in-a-doubly-linked-list) | step08-linkedlist/Learn-Doubly-LL/DoublyLL_Basics.java | Walk from the head, comparing each node's value, and stop at the first match. | ✅ | |
| [Delete a node from a doubly linked list](striver-a2z/step08-linkedlist/Learn-Doubly-LL/README.md#delete-a-node-from-a-doubly-linked-list) | step08-linkedlist/Learn-Doubly-LL/DoublyLL_Basics.java | Point the previous node forward to the following node and the following node back to the previous one, treating the head and the tail separately. | ✅ | |
| [Insert a node into a doubly linked list](striver-a2z/step08-linkedlist/Learn-Doubly-LL/README.md#insert-a-node-into-a-doubly-linked-list) | step08-linkedlist/Learn-Doubly-LL/DoublyLL_Basics.java | Create the new node already pointing at both neighbours, then point the neighbours at it. | ✅ | |
| [Reverse a doubly linked list](striver-a2z/step08-linkedlist/Learn-Doubly-LL/README.md#reverse-a-doubly-linked-list) | step08-linkedlist/Learn-Doubly-LL/ReverseDLL.java | Swap the forward and backward references of every node; the last node visited becomes the new head. | ✅ | |

### Medium problems on singly linked lists (Medium-Singly-LL/)
| Problem | File | Idea | Status | Revisit |
|---|---|---|---|---|
| [Middle of a linked list](striver-a2z/step08-linkedlist/Medium-Singly-LL/README.md#middle-of-a-linked-list) | step08-linkedlist/Medium-Singly-LL/MiddleOfLL.java | Move one reference one step and another two steps at a time; when the fast one runs out, the slow one is at the middle. | ✅ | |
| [Reverse a linked list](striver-a2z/step08-linkedlist/Medium-Singly-LL/README.md#reverse-a-linked-list) | step08-linkedlist/Medium-Singly-LL/ReverseLL.java | Walk the list turning each next reference backwards, keeping track of the previous node and the next node. | ✅ | |
| [Detect a loop in a linked list](striver-a2z/step08-linkedlist/Medium-Singly-LL/README.md#detect-a-loop-in-a-linked-list) | step08-linkedlist/Medium-Singly-LL/DetectLoop.java | Move a slow reference one step and a fast reference two steps at a time; they meet only if the list has a loop. | ✅ | |
| [Starting point of the loop](striver-a2z/step08-linkedlist/Medium-Singly-LL/README.md#starting-point-of-the-loop) | step08-linkedlist/Medium-Singly-LL/StartingNodeOfLoop.java | After the slow and fast references meet, move one back to the head and step both one node at a time; they meet again at the start of the loop. | ✅ | |
| [Length of the loop](striver-a2z/step08-linkedlist/Medium-Singly-LL/README.md#length-of-the-loop) | step08-linkedlist/Medium-Singly-LL/LengthOfLoop.java | After the slow and fast references meet, walk around the loop once from the meeting point, counting the steps. | ✅ | |
| [Check if a linked list is a palindrome](striver-a2z/step08-linkedlist/Medium-Singly-LL/README.md#check-if-a-linked-list-is-a-palindrome) | step08-linkedlist/Medium-Singly-LL/CheckPalindrome.java | Find the middle, reverse the second half, compare it with the first half, and reverse it back. | ✅ | |
| [Odd even linked list](striver-a2z/step08-linkedlist/Medium-Singly-LL/README.md#odd-even-linked-list) | step08-linkedlist/Medium-Singly-LL/OddEvenLL.java | Build one chain of the nodes in odd positions and one of the nodes in even positions, then attach the even chain after the odd one. | ✅ | |
| [Remove the Nth node from the end](striver-a2z/step08-linkedlist/Medium-Singly-LL/README.md#remove-the-nth-node-from-the-end) | step08-linkedlist/Medium-Singly-LL/RemoveNthFromEnd.java | Move a fast reference N nodes ahead, then move both until the fast one is on the last node, so the slow one stops just before the node to remove. | ✅ | |
| [Delete the middle node](striver-a2z/step08-linkedlist/Medium-Singly-LL/README.md#delete-the-middle-node) | step08-linkedlist/Medium-Singly-LL/DeleteMiddle.java | Give the fast reference a head start of two nodes so the slow one stops just before the middle, then skip over the middle node. | ✅ | |
| [Sort a linked list of 0s, 1s and 2s](striver-a2z/step08-linkedlist/Medium-Singly-LL/README.md#sort-a-linked-list-of-0s-1s-and-2s) | step08-linkedlist/Medium-Singly-LL/Sort0s1s2s.java | Split the nodes into three chains by value, each behind a dummy head, then join the chains in order. | ✅ | |
| [Intersection point of two Y-shaped linked lists](striver-a2z/step08-linkedlist/Medium-Singly-LL/README.md#intersection-point-of-two-y-shaped-linked-lists) | step08-linkedlist/Medium-Singly-LL/IntersectionPointOfYLL.java | Walk both lists at once and switch each reference to the other list's head when it reaches the end; they meet at the shared node, or both reach the end together. | ✅ | |
| [Add two numbers](striver-a2z/step08-linkedlist/Medium-Singly-LL/README.md#add-two-numbers) | step08-linkedlist/Medium-Singly-LL/AddTwoNumbers.java | Add the digits node by node with a carry, building the result after a dummy node. | ✅ | |

### Medium problems on doubly linked lists (Medium-Doubly-LL/)
| Problem | File | Idea | Status | Revisit |
|---|---|---|---|---|
| [Delete all occurrences of a key](striver-a2z/step08-linkedlist/Medium-Doubly-LL/README.md#delete-all-occurrences-of-a-key) | step08-linkedlist/Medium-Doubly-LL/DeleteAllOccurrencesDLL.java | Walk the list once and cut out every matching node by linking its previous and next nodes to each other. | ✅ | |
| [Remove duplicates from a sorted doubly linked list](striver-a2z/step08-linkedlist/Medium-Doubly-LL/README.md#remove-duplicates-from-a-sorted-doubly-linked-list) | step08-linkedlist/Medium-Doubly-LL/RemoveDuplicatesInSortedDLL.java | Keep a reference on the last unique node, skip the equal nodes after it, and link it to the next new value in both directions. | ✅ | |

## Step 10 — Greedy Algorithms
| Problem | File | Idea | Status | Revisit |
|---|---|---|---|---|
| [Assign cookies](striver-a2z/step10-greedy_algo/README.md#assign-cookies) | step10-greedy_algo/AssignCookies.java | Sort the greed factors and the cookie sizes, then match the least greedy child with the smallest cookie that is big enough. | ✅ | |
| [Lemonade change](striver-a2z/step10-greedy_algo/README.md#lemonade-change) | step10-greedy_algo/LemonadeChange.java | Count the 5 and 10 notes, and give change for a 20 as a 10 plus a 5 whenever possible, saving the 5s for later. | ✅ | |
| [Fractional knapsack](striver-a2z/step10-greedy_algo/README.md#fractional-knapsack) | step10-greedy_algo/FractionalKnapsack.java | Sort the items by value per unit of weight, take whole items while they fit, and then take a fraction of the next one. | ✅ | |
| [Maximum units on a truck](striver-a2z/step10-greedy_algo/README.md#maximum-units-on-a-truck) | step10-greedy_algo/FractionalKnapsack.java | Sort the box types by units per box, largest first, and load boxes until the truck is full. | ✅ | |
| [Jump game I](striver-a2z/step10-greedy_algo/README.md#jump-game-i) | step10-greedy_algo/JumpGame_I.java | Track the furthest position reachable so far; if the walk ever goes past it, the end cannot be reached. | ✅ | |
| [Jump game II](striver-a2z/step10-greedy_algo/README.md#jump-game-ii) | step10-greedy_algo/JumpGame_II.java | Treat the positions reachable with each number of jumps as a window, and grow one window per jump until it covers the last position. | ✅ | |

## Step 15 — Graphs

### Learning the basics (Learning/)
| Problem | File | Idea | Status | Revisit |
|---|---|---|---|---|
| [Graph representation with an adjacency matrix](striver-a2z/step15-graphs/Learning/README.md#graph-representation-with-an-adjacency-matrix) | step15-graphs/Learning/AdjacencyMatrix.java · AdjacencyMatrixWeighted.java | Store the graph in a V × V grid where row u and column v hold 1, or the weight, when u and v are joined. | ✅ | |
| [Graph representation with an adjacency list](striver-a2z/step15-graphs/Learning/README.md#graph-representation-with-an-adjacency-list) | step15-graphs/Learning/AdjacencyList.java · AdjacencyListWeighted.java | Store a list of neighbours for every vertex, adding each undirected edge in both directions. | ✅ | |
| [Breadth-first search of a graph](striver-a2z/step15-graphs/Learning/README.md#breadth-first-search-of-a-graph) | step15-graphs/Learning/Traversals.java | Visit the vertices level by level with a queue, marking each one visited when it is added. | ✅ | |
| [Depth-first search of a graph](striver-a2z/step15-graphs/Learning/README.md#depth-first-search-of-a-graph) | step15-graphs/Learning/Traversals.java | Visit a vertex, then recursively visit each unvisited neighbour before backing up. | ✅ | |
| [Number of connected components](striver-a2z/step15-graphs/Learning/README.md#number-of-connected-components) | step15-graphs/Learning/ConnectedComponents.java | Start a new search from every vertex that is still unvisited; each new search is one more component. | ✅ | |
| [Count the number of complete components](striver-a2z/step15-graphs/Learning/README.md#count-the-number-of-complete-components) | step15-graphs/Learning/ConnectedComponents.java | For each component, count its K vertices and add up their degrees; the component is complete when the total equals K × (K − 1). | ✅ | |

### Problems on breadth-first and depth-first search (Problems-On-BFS-DFS/)
| Problem | File | Idea | Status | Revisit |
|---|---|---|---|---|
| [Number of provinces](striver-a2z/step15-graphs/Problems-On-BFS-DFS/README.md#number-of-provinces) | step15-graphs/Problems-On-BFS-DFS/NumberOfProvinces.java | Count the connected components of the adjacency matrix with a depth-first search from every unvisited city. | ✅ | |
| [Number of islands](striver-a2z/step15-graphs/Problems-On-BFS-DFS/README.md#number-of-islands) | step15-graphs/Problems-On-BFS-DFS/NumberOfIslands.java | Start a breadth-first search from every unvisited land cell and count one island per search, moving in 8 or 4 directions depending on the version. | ✅ | |
| [Rotting oranges](striver-a2z/step15-graphs/Problems-On-BFS-DFS/README.md#rotting-oranges) | step15-graphs/Problems-On-BFS-DFS/RottenOranges.java | Start a breadth-first search from every rotten orange at once and count its levels, one per minute, until nothing fresh is left. | ✅ | |
| [Flood fill](striver-a2z/step15-graphs/Problems-On-BFS-DFS/README.md#flood-fill) | step15-graphs/Problems-On-BFS-DFS/FloodFill.java | Run a breadth-first search from the starting pixel, painting each neighbour that still has the original colour as it is queued. | ✅ | |
| [Detect a cycle in an undirected graph using breadth-first search](striver-a2z/step15-graphs/Problems-On-BFS-DFS/README.md#detect-a-cycle-in-an-undirected-graph-using-breadth-first-search) | step15-graphs/Problems-On-BFS-DFS/DetectCycleInUndirectedGraph_BFS.java | Run a breadth-first search that remembers each vertex's parent; a visited neighbour other than the parent means a cycle. | ✅ | |
| [Detect a cycle in an undirected graph using depth-first search](striver-a2z/step15-graphs/Problems-On-BFS-DFS/README.md#detect-a-cycle-in-an-undirected-graph-using-depth-first-search) | step15-graphs/Problems-On-BFS-DFS/DetectCycleInUndirectedGraph_DFS.java | Run a depth-first search that passes each vertex's parent down; a visited neighbour other than the parent means a cycle. | ✅ | |
| [Distance of the nearest cell having 1](striver-a2z/step15-graphs/Problems-On-BFS-DFS/README.md#distance-of-the-nearest-cell-having-1) | step15-graphs/Problems-On-BFS-DFS/NearestCell.java | Start a breadth-first search from every 1 at once, at distance 0, so each cell is first reached from its nearest 1. | ✅ | |
| [Surrounded regions](striver-a2z/step15-graphs/Problems-On-BFS-DFS/README.md#surrounded-regions) | step15-graphs/Problems-On-BFS-DFS/SurroundedRegions.java | Mark every 'O' connected to the border with a depth-first search, then turn every unmarked 'O' into 'X'. | ✅ | |
| [Number of enclaves](striver-a2z/step15-graphs/Problems-On-BFS-DFS/README.md#number-of-enclaves) | step15-graphs/Problems-On-BFS-DFS/NumberOfEnclaves.java | Mark every land cell connected to the border with a depth-first search, then count the land cells left unmarked. | ✅ | |
| [Word ladder I](striver-a2z/step15-graphs/Problems-On-BFS-DFS/README.md#word-ladder-i) | step15-graphs/Problems-On-BFS-DFS/WordLadder_I.java | Run a breadth-first search from the start word, trying every one-letter change and removing each new word from the set as it is queued. | ✅ | |
| [Detect a cycle in a directed graph using depth-first search](striver-a2z/step15-graphs/Problems-On-BFS-DFS/README.md#detect-a-cycle-in-a-directed-graph-using-depth-first-search) | step15-graphs/Problems-On-BFS-DFS/DetectCycleInDirectedGraph_DFS.java | Keep track of the vertices on the current path of the depth-first search; reaching one of them again means a cycle. | ✅ | |
| [Detect a cycle in a directed graph using breadth-first search](striver-a2z/step15-graphs/Problems-On-BFS-DFS/README.md#detect-a-cycle-in-a-directed-graph-using-breadth-first-search) | step15-graphs/Problems-On-BFS-DFS/DetectCycleInDirectedGraph_BFS.java | Run Kahn's algorithm and count the vertices it places; placing fewer than V means a cycle. | ✅ | |
| [Bipartite graph](striver-a2z/step15-graphs/Problems-On-BFS-DFS/README.md#bipartite-graph) | step15-graphs/Problems-On-BFS-DFS/BipartiteGraph.java | Give every vertex the opposite colour to the neighbour it was reached from; a neighbour that already has the same colour means the graph is not bipartite. | ✅ | |

### Topological sort (Topo-Sort/)
| Problem | File | Idea | Status | Revisit |
|---|---|---|---|---|
| [Topological sort](striver-a2z/step15-graphs/Topo-Sort/README.md#topological-sort) | step15-graphs/Topo-Sort/TopoSort.java | Push each vertex onto a stack once its depth-first search finishes and pop them all, or keep taking out vertices with no incoming edges left (Kahn's algorithm). | ✅ | |
