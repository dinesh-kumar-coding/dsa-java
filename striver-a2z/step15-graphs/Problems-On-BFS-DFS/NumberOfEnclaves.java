/*
 * Problem: Number of Enclaves — Optimal: DFS from Boundaries
 * Question: Count the land cells that cannot reach the boundary — flood inward from the border first, then count what survives.
 * Solved: 10-09-2026 | TC: O(M * N) | SC: O(M * N)
 * Revisit: [date]
 */
public class NumberOfEnclaves {
  public static void main(String[] args) {
    // Test 1: Standard case with enclaves
    // The 1 at (1,0) is on the boundary. 
    // The three 1s in the middle are trapped.
    int[][] grid1 = {
      {0, 0, 0, 0},
      {1, 0, 1, 0},
      {0, 1, 1, 0},
      {0, 0, 0, 0}
    };
    System.out.println("Test 1: " + numEnclaves(grid1)); // Expected: 3

    // Test 2: All 1s are connected to the boundary (No enclaves)
    int[][] grid2 = {
      {0, 0, 0, 1},
      {0, 1, 1, 1},
      {0, 0, 0, 0}
    };
    System.out.println("Test 2: " + numEnclaves(grid2)); // Expected: 0

    // Test 3: Completely enclosed large island
    int[][] grid3 = {
      {0, 0, 0, 0, 0},
      {0, 1, 1, 1, 0},
      {0, 1, 0, 1, 0},
      {0, 1, 1, 1, 0},
      {0, 0, 0, 0, 0}
    };
    System.out.println("Test 3: " + numEnclaves(grid3)); // Expected: 8
  }

  public static int numEnclaves(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    int[] delrow = { -1, 0, 1, 0 };
    int[] delcol = { 0, -1, 0, 1 };

    boolean[][] vis = new boolean[m][n];

    for (int j = 0; j < n; j++) {
      if (!vis[0][j] && grid[0][j] == 1) {
        dfs(0, j, vis, grid, delrow, delcol);
      }

      if (!vis[m - 1][j] && grid[m - 1][j] == 1) {
        dfs(m - 1, j, vis, grid, delrow, delcol);
      }
    }

    for (int i = 0; i < m; i++) {
      if (!vis[i][0] && grid[i][0] == 1) {
        dfs(i, 0, vis, grid, delrow, delcol);
      }

      if (!vis[i][n - 1] && grid[i][n - 1] == 1) {
        dfs(i, n - 1, vis, grid, delrow, delcol);
      }
    }

    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!vis[i][j] && grid[i][j] == 1)
          count++;
      }
    }

    return count;
  }

  public static void dfs(int row, int col, boolean[][] vis, int[][] grid, int[] delrow, int[] delcol) {
    vis[row][col] = true;
    int m = grid.length;
    int n = grid[0].length;

    for (int k = 0; k < 4; k++) {
      int nrow = row + delrow[k];
      int ncol = col + delcol[k];

      if (nrow >= 0 && ncol >= 0 && nrow < m && ncol < n && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
        dfs(nrow, ncol, vis, grid, delrow, delcol);
      }
    }
  }
}