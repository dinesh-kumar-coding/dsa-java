# Step 2 — Sorting

Full notes for every problem in this folder. Status and revisit dates are tracked in [PROGRESS.md](../../PROGRESS.md).

## Selection sort
**File:** [SelectionSort.java](SelectionSort.java), method `selectionSort`

**Question.** Sort an array in increasing order by repeatedly selecting the smallest element.

**Approach — select the minimum, then swap it into place.** The array is treated as a sorted part on the left and an unsorted part on the right. For each position i, the inner loop scans the unsorted part from i to the end and remembers where the smallest element is. That element is then swapped into position i, which grows the sorted part by one. After N − 1 rounds the whole array is sorted.

- **Time:** O(N²) in every case — the inner scan always covers the whole unsorted part, even when the array is already sorted.
- **Extra space:** O(1) — the sorting happens in place.

**Remember:** selection sort makes at most N − 1 swaps, fewer than any other simple sort, which is its one real advantage when writing to memory is expensive. It is not stable: a long-distance swap can carry an element past an equal one and change their original order.

## Bubble sort
**File:** [BubbleSort.java](BubbleSort.java), methods `bubbleSort` and `recursive_bubbleSort`

**Question.** Sort an array by repeatedly swapping neighbouring elements that are in the wrong order.

**Iterative — passes that shrink from the right, with an early exit.** Each pass walks from the start of the array to the end of the unsorted part, comparing every element with its right-hand neighbour and swapping the two if the left one is larger. This carries the largest unsorted element to the end, like a bubble rising, so the next pass can stop one position earlier. The method counts the swaps in each pass, and if a whole pass makes none, the array is already sorted and it stops.

- **Time:** O(N²) in the worst and average cases, and O(N) in the best case, when the array is already sorted and the first pass makes no swaps.
- **Extra space:** O(1).

**Recursive — one pass per call.** The recursive version makes a single pass over the first n elements, which moves the largest of them to position n − 1, and then calls itself on the first n − 1 elements. A flag records whether the pass swapped anything, and if it did not, the method returns immediately instead of recursing.

- **Time:** O(N²) in the worst case, O(N) in the best case.
- **Extra space:** O(N) for the call stack.

**Remember:** the early exit is what gives bubble sort its linear best case, and its condition is easy to invert by accident. The sort should stop when a pass made *no* swaps; stopping when a pass made some swaps quits exactly when there is still work left to do.

## Insertion sort
**File:** [InsertionSort.java](InsertionSort.java), methods `inserstionSort` and `recursive_inserstionSort`

**Question.** Sort an array by inserting each element into its correct place among the elements before it.

**Iterative — shift larger elements right, then drop the key in.** The part of the array to the left of position i is always sorted. The method lifts out the element at i, called the key, then moves left through the sorted part, shifting every element larger than the key one position to the right. When it reaches an element that is not larger, or the start of the array, it places the key in the gap left behind.

- **Time:** O(N²) in the worst case, when the array is in reverse order, and O(N) in the best case, when it is already sorted and nothing needs to shift.
- **Extra space:** O(1).

**Recursive — one element per call.** The recursive version takes the element at position i and swaps it backwards with its left-hand neighbour for as long as that neighbour is larger, then calls itself for position i + 1, stopping once i reaches the end.

- **Time:** O(N²) in the worst case, O(N) in the best case.
- **Extra space:** O(N) for the call stack.

**Remember:** shifting is cheaper than swapping. A shift writes one element per step, while a swap writes two and needs a temporary variable. Insertion sort is also fast on nearly sorted data, which is why real sorting libraries use it to finish off small pieces of an array.

## Merge sort
**File:** [MergeSort.java](MergeSort.java), methods `mergeSort`, `mS` and `merge`

**Question.** Sort an array using divide and conquer.

**Approach — split, sort each half, merge.** The recursive method `mS` takes the range from low to high. A range with one element or none is already sorted. Otherwise the method finds the middle, sorts the left half and the right half with two recursive calls, and then merges them. The merge walks two pointers along the two sorted halves, repeatedly copying the smaller of the two current elements into a temporary list, then copies whatever is left over in either half, and finally writes the merged list back over the original range.

- **Time:** O(N log N) in every case — the array is halved about log N times, and each level of halving does O(N) work merging.
- **Extra space:** O(N) for the temporary list used during merging, plus O(log N) for the call stack.

**Remember:** when the two current elements are equal, the merge takes from the left half first (`arr[left] <= arr[right]`). Using `<=` rather than `<` is what makes merge sort stable, so equal elements keep their original order.

## Quick sort
**File:** [QuickSort.java](QuickSort.java), methods `quickSort`, `quickSortHelper` and `partition`

**Question.** Sort an array in place by partitioning it around a pivot.

**Approach — partition around the first element, then recurse.** The pivot is the first element of the range. Pointer i moves right past every element that is less than or equal to the pivot, and pointer j moves left past every element that is greater than it. Whenever both have stopped and have not yet crossed, the two elements they point at are in the wrong halves, so they are swapped. Once the pointers cross, the pivot is swapped into position j, which is exactly where it belongs in the sorted array: nothing to its left is larger, and nothing to its right is smaller. The method then sorts the left part and the right part the same way.

- **Time:** O(N log N) on average, O(N²) in the worst case.
- **Extra space:** O(log N) for the call stack on average, and O(N) in the worst case; the sorting itself happens in place.

**Remember:** with the first element as the pivot, an already sorted array is the worst case. Every partition then splits off just one element, so the work grows quadratically and the call stack grows as deep as the array. The two scanning conditions must also split the elements cleanly: one pointer skips everything that belongs on the left of the pivot and the other skips everything that belongs on the right. If one of the conditions is written the wrong way round, the pointers stop on the wrong elements and the swapping can go on forever.
