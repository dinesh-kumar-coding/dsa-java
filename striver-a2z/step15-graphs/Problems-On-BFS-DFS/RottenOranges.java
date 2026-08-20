/*
 * Problem: RottenOranges — Optimal: Multi-source BFS
 * Solved: 20-08-2026 | TC: O(M * N) | SC: O(M * N)
 * Revisit: [date]
 */
import java.util.*;

public class RottenOranges {
  public static void main(String[] args) {
    // Test 1: All oranges can rot
    int[][] grid1 = {
      {2, 1, 1},
      {1, 1, 0},
      {0, 1, 1}
    };
    System.out.println("Test 1: " + orangesRotting(grid1)); // Expected: 4

    // Test 2: One orange is unreachable and will never rot
    int[][] grid2 = {
      {2, 1, 1},
      {0, 1, 1},
      {1, 0, 1}
    };
    System.out.println("Test 2: " + orangesRotting(grid2)); // Expected: -1

    // Test 3: No fresh oranges to begin with
    int[][] grid3 = {
      {0, 2}
    };
    System.out.println("Test 3: " + orangesRotting(grid3)); // Expected: 0
  }

  public static int orangesRotting(int[][] grid){
    int m = grid.length;
    int n = grid[0].length;
    int result = 0;
    int fresh = 0;

    Queue<int[]> q = new LinkedList<>();
    int[] delrow = {-1, 0, 1, 0};
    int[] delcol = {0, -1, 0, 1};

    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        if(grid[i][j] == 2){
          q.offer(new int[] {i, j});
        } else if(grid[i][j] == 1){
          fresh++;
        }
      }
    }

    while(!q.isEmpty() && fresh > 0){
      int size = q.size();
      for(int i = 0; i < size; i++){
        int row = q.peek()[0];
        int col = q.peek()[1];
        q.remove();

        for(int k = 0; k < 4; k++){
          int nrow = row + delrow[k];
          int ncol = col + delcol[k];
          if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1){
            grid[nrow][ncol] = 2;
            fresh--;
            q.offer(new int[] {nrow, ncol});
          }
        }
      }
      result++;
    }

    return fresh == 0 ? result : -1;
  }
}