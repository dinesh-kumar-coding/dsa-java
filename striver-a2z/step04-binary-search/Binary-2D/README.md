# Step 4 — Binary search on two-dimensional arrays

Full notes for every problem in this folder. Status and revisit dates are tracked in [PROGRESS.md](../../../PROGRESS.md).

## Search in a 2D matrix
**File:** [SearchIn2DMatrix.java](SearchIn2DMatrix.java), method `searchIn2DMatrix`

**Question.** Each row of a matrix is sorted, and every row starts with a value larger than the last value of the row above it. Decide whether a target is in the matrix.

**Optimal — treat the matrix as one sorted array.** Reading the rows one after another gives a single sorted sequence of M × N values, so the method runs one binary search over positions 0 to M × N − 1. For any position, the row is the position divided by the number of columns, and the column is the remainder.

- **Time:** O(log(M × N)), where the matrix has M rows and N columns.
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which scans every cell in O(M × N) time; and the better approach, which first finds the one row whose range could contain the target and then binary searches inside it.

**Remember:** divide by the number of *columns*, not rows, when turning a position back into a row and a column. The trick only works because each row continues where the previous row ended; for a matrix whose rows and columns are sorted separately, use the staircase search instead.

## Row with the maximum number of 1s
**File:** [RowWithMaximumOnes.java](RowWithMaximumOnes.java), methods `rowAndMaximumOnes_leetcode_2643` and `rowWithMaximumOnes`

**Question.** In a matrix of 0s and 1s where every row is sorted, with all the 0s before all the 1s, find the row with the most 1s and how many it has.

**Brute — count every row.** The method counts the 1s in each row and keeps the row with the largest count. Because it never relies on the rows being sorted, this version also solves LeetCode 2643, where they are not.

- **Time:** O(M × N).
- **Extra space:** O(1).

**Optimal — binary search for the first 1 in each row.** In a sorted row, all the 1s come after the first 1, so the number of 1s is the row length minus the position of that first 1. The method finds that position with a lower-bound search on each row, starting from the row length so that a row with no 1s counts as zero.

- **Time:** O(M × log N).
- **Extra space:** O(1).

**Not in the file yet:** the staircase approach, which starts at the top-right corner, moves left past every 1 and down whenever it meets a 0, finishing in O(M + N) time.

**Remember:** to report the earliest row when two rows tie, update the answer only when a count is strictly greater than the best so far.

## Search in a 2D matrix II
**File:** [SearchIn2DMatrixII.java](SearchIn2DMatrixII.java), methods `searchIn2DMatrix_binarySearch` and `searchIn2DMatrix_optimal`

**Question.** Every row of a matrix is sorted from left to right and every column from top to bottom, but one row does not have to continue where the previous one ended. Find the row and column of a target.

**Better — binary search every row.** Each row is sorted on its own, so the method runs an ordinary binary search on one row after another.

- **Time:** O(M × log N).
- **Extra space:** O(1).

**Optimal — the staircase search from the bottom-left corner.** At the bottom-left corner, moving up makes the values smaller and moving right makes them larger. If the current value is larger than the target, nothing to its right in that row can be the target, so the search moves up a row; if it is smaller, nothing above it in that column can be the target, so it moves right a column. Each step rules out a whole row or a whole column.

- **Time:** O(M + N).
- **Extra space:** O(1).

**Remember:** start from a corner where the two possible moves go in opposite directions, either the bottom-left or the top-right. From the top-left or the bottom-right corner, both moves go the same way, so a comparison cannot rule anything out.
