/*
 * Problem: SearchIn2DMatrixII — Optimal: Step-wise Search | Better: Binary Search per Row
 * Solved: 17-08-2026 | TC: O(M + N) Optimal, O(M * log N) Better | SC: O(1)
 * Revisit: [date]
 */

import java.util.Arrays;

public class SearchIn2DMatrixII {
  public static void main(String[] args) {
    int[][] matrix = {
      {1,   4,  7, 11, 15},
      {2,   5,  8, 12, 19},
      {3,   6,  9, 16, 22},
      {10, 13, 14, 17, 24},
      {18, 21, 23, 26, 30}
    };

    System.out.println("Test 1 (Find 5) Better: " + Arrays.toString(searchIn2DMatrix_binarySearch(matrix, 5)));
    System.out.println("Test 1 (Find 5) Optimal: " + Arrays.toString(searchIn2DMatrix_optimal(matrix, 5)));

    System.out.println("Test 2 (Find 20) Better: " + Arrays.toString(searchIn2DMatrix_binarySearch(matrix, 20)));
    System.out.println("Test 2 (Find 20) Optimal: " + Arrays.toString(searchIn2DMatrix_optimal(matrix, 20)));

    System.out.println("Test 3 (Find 18) Better: " + Arrays.toString(searchIn2DMatrix_binarySearch(matrix, 18)));
    System.out.println("Test 3 (Find 18) Optimal: " + Arrays.toString(searchIn2DMatrix_optimal(matrix, 18)));

    System.out.println("Test 4 (Find 15) Better: " + Arrays.toString(searchIn2DMatrix_binarySearch(matrix, 15)));
    System.out.println("Test 4 (Find 15) Optimal: " + Arrays.toString(searchIn2DMatrix_optimal(matrix, 15)));
  }

  public static int[] searchIn2DMatrix_binarySearch(int[][] arr, int target){
    for(int i = 0; i < arr.length; i++){
      int low = 0;
      int high = arr[0].length - 1;
      while(high >= low){
        int mid = low + (high - low)/2;
        if(arr[i][mid] == target){
          return new int[] {i, mid};
        } else if(arr[i][mid] > target) high = mid - 1;
        else low = mid + 1;
      }
    }
    return new int[] {};
  }

  public static int[] searchIn2DMatrix_optimal(int[][] arr, int target){
    int row = arr.length - 1;
    int col = 0;
    while(col < arr[0].length && row >= 0){
      if(arr[row][col] == target) return new int[] {row, col};
      else if(arr[row][col] > target) row--;
      else col++;
    }
    return new int[] {};
  }
}