/*
 * Problem: SearchIn2DMatrix — Optimal: Flattened Binary Search
 * Solved: 15-08-2026 | TC: O(log(M * N)) | SC: O(1)
 * Revisit: [date]
 */

public class SearchIn2DMatrix {
  public static void main(String[] args) {
    int[][] matrix = {
      {1, 3, 5, 7},
      {10, 11, 16, 20},
      {23, 30, 34, 60}
    };

    System.out.println("Test 1 (Find 3): " + searchIn2DMatrix(matrix, 3));   // true
    System.out.println("Test 2 (Find 16): " + searchIn2DMatrix(matrix, 16)); // true
    System.out.println("Test 3 (Find 13): " + searchIn2DMatrix(matrix, 13)); // false
    System.out.println("Test 4 (Find 60): " + searchIn2DMatrix(matrix, 60)); // true
    System.out.println("Test 5 (Find 0): " + searchIn2DMatrix(matrix, 0));   // false

    int[][] single = {{1}};
    System.out.println("Test 6 (1x1 matrix, find 1): " + searchIn2DMatrix(single, 1)); // true
  }

  public static boolean searchIn2DMatrix(int[][] arr, int target){
    int m = arr.length;
    int n = arr[0].length;
    int low = 0;
    int high = m * n - 1;
    
    while(high >= low){
      int mid = low + (high - low)/2;
      
      int row = mid / n;
      int col = mid % n;
      
      if(arr[row][col] == target) return true;
      else if(arr[row][col] < target) low = mid + 1;
      else high = mid - 1;
    }
    return false;
  }
}