/*
 * Problem: RowWithMaximumOnes — Optimal: Binary Search (Sorted Rows) | Brute: Full Traversal
 * Solved: 16-08-2026 | TC: O(M * log N) Optimal, O(M * N) Brute | SC: O(1)
 * Revisit: [date]
 */
import java.util.Arrays;

public class RowWithMaximumOnes {
  public static void main(String[] args) {
    System.out.println("--- Unsorted Matrices (LeetCode 2643 - Brute Force only) ---");
    int[][] test1 = {
      {0, 1},
      {1, 0}
    };
    System.out.println("Test 1 Brute: " + Arrays.toString(rowAndMaximumOnes_leetcode_2643(test1))); 

    int[][] test2 = {
      {0, 0, 0},
      {0, 1, 1}
    };
    System.out.println("Test 2 Brute: " + Arrays.toString(rowAndMaximumOnes_leetcode_2643(test2))); 

    System.out.println("\n--- Sorted Matrices (Optimal Binary Search) ---");
    int[][] test3 = {
      {0, 0, 1},
      {0, 1, 1},
      {1, 1, 1}
    };
    System.out.println("Test 3 Brute: " + Arrays.toString(rowAndMaximumOnes_leetcode_2643(test3))); 
    System.out.println("Test 3 Optimal: " + Arrays.toString(rowWithMaximumOnes(test3))); 
    
    int[][] test4 = {
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0}
    };
    System.out.println("Test 4 Brute: " + Arrays.toString(rowAndMaximumOnes_leetcode_2643(test4))); 
    System.out.println("Test 4 Optimal: " + Arrays.toString(rowWithMaximumOnes(test4))); 
  }

  public static int[] rowAndMaximumOnes_leetcode_2643(int[][] matrix){
    int maxCount = 0;
    int resultRow = 0;
    for(int i = 0; i < matrix.length; i++){
      int count = 0;
      for(int j = 0; j < matrix[0].length; j++){
        if(matrix[i][j] == 1) count++;
      }
      if(count > maxCount){
        maxCount = count;
        resultRow = i;
      }
    }
    return new int[] {resultRow, maxCount};
  }

  public static int[] rowWithMaximumOnes(int[][] matrix){
    int m = matrix.length;
    int n = matrix[0].length;
    int maxOnes = 0;
    int resultRow = 0;
    for(int i = 0; i < m; i++){
      int low = 0;
      int high = n - 1;
      int firstOne = n;
      while(high >= low){
        int mid = low + (high - low)/2;
        if(matrix[i][mid] == 1){
          high = mid - 1;
          firstOne = mid;
        } else{
          low = mid + 1;
        }
      }
      int count = n - firstOne;
      if(count > maxOnes){
        maxOnes = count;
        resultRow = i;
      }
    }
    return new int[] {resultRow, maxOnes};
  }
}