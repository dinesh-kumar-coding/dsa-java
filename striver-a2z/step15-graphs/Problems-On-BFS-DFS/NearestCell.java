/*
 * Problem: Distance of nearest cell having 1 (01 Matrix variant) — Optimal: Multi-source BFS
 * Solved: 26-08-2026 | TC: O(M * N) | SC: O(M * N)
 * Revisit: [date]
 */
import java.util.*;

public class NearestCell {
  public static void main(String[] args) {
    // Test 1: Standard grid with 1s and 0s
    // 0 0 0
    // 0 1 0
    // 0 0 0
    int[][] grid1 = {
      {0, 0, 0},
      {0, 1, 0},
      {0, 0, 0}
    };
    System.out.println("Test 1:");
    printMatrix(nearest(grid1));
    // Expected Output:
    // [2, 1, 2]
    // [1, 0, 1]
    // [2, 1, 2]

    // Test 2: Multiple 1s in a non-square grid (Tests the ncol < n fix)
    // 0 1 1 0
    // 1 1 0 0
    // 0 0 1 1
    int[][] grid2 = {
      {0, 1, 1, 0},
      {1, 1, 0, 0},
      {0, 0, 1, 1}
    };
    System.out.println("\nTest 2:");
    printMatrix(nearest(grid2));
    // Expected Output:
    // [1, 0, 0, 1]
    // [0, 0, 1, 2]
    // [1, 1, 0, 0]
  }

  // Helper method to print 2D array
  private static void printMatrix(int[][] matrix) {
    for (int[] row : matrix) {
      System.out.println(Arrays.toString(row));
    }
  }

  public static int[][] nearest(int[][] grid){
    int m = grid.length;
    int n = grid[0].length;

    boolean[][] vis = new boolean[m][n];
    int[][] dist = new int[m][n];
    Queue<int[]> q = new LinkedList<>();
    
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        if(grid[i][j] == 1){
          q.add(new int[] {i, j, 0});
          vis[i][j] = true;
        }
      }
    }
    
    int[] delrow = {-1, 0, 1, 0};
    int[] delcol = {0, -1, 0, 1};

    while(!q.isEmpty()){
      int[] cell = q.poll();
      int row = cell[0];
      int col = cell[1];
      int steps = cell[2];

      dist[row][col] = steps;

      for(int i = 0; i < 4; i++){
        int nrow = row + delrow[i];
        int ncol = col + delcol[i];

        if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && !vis[nrow][ncol]){
          vis[nrow][ncol] = true;
          q.add(new int[] {nrow, ncol, steps + 1});
        }
      }
    }
    return dist;
  }
}