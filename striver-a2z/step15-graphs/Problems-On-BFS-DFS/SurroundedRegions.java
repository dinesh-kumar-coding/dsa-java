/*
 * Problem: Surrounded Regions (Replace O's with X's) — Optimal: DFS from Boundaries
 * Solved: 10-09-2026 | TC: O(M * N) | SC: O(M * N)
 * Revisit: [date]
 */
import java.util.*;

public class SurroundedRegions {
  public static void main(String[] args) {
    // Test 1: Standard case with surrounded and unbounded regions
    char[][] mat1 = {
      {'X', 'X', 'X', 'X'},
      {'X', 'O', 'O', 'X'},
      {'X', 'X', 'O', 'X'},
      {'X', 'O', 'X', 'X'}
    };
    System.out.println("Test 1:");
    printMatrix(fill(mat1.length, mat1[0].length, mat1));
    // Expected Output:
    // [X, X, X, X]
    // [X, X, X, X]
    // [X, X, X, X]
    // [X, O, X, X]

    // Test 2: No 'O's are surrounded
    char[][] mat2 = {
      {'X', 'X', 'X'},
      {'X', 'O', 'X'},
      {'O', 'X', 'X'}
    };
    System.out.println("\nTest 2:");
    printMatrix(fill(mat2.length, mat2[0].length, mat2));
    // Expected Output:
    // [X, X, X]
    // [X, X, X]
    // [O, X, X]
  }

  // Helper to print matrix
  private static void printMatrix(char[][] matrix) {
    for (char[] row : matrix) {
      System.out.println(Arrays.toString(row));
    }
  }

  public static void dfs(int row, int col, boolean vis[][], char mat[][], int delrow[], int delcol[]){
    vis[row][col] = true;
    int m = mat.length;
    int n = mat[0].length;
    // try 4 directions
    for(int k = 0; k < 4; k++){
      int nrow = row + delrow[k];
      int ncol = col + delcol[k];

      if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && !vis[nrow][ncol] && mat[nrow][ncol] == 'O'){
        dfs(nrow, ncol, vis, mat, delrow, delcol);
      }
    }
  }

  public static char[][] fill(int m, int n, char mat[][]){
    int[] delrow = {-1, 0, 1, 0};
    int[] delcol = {0, -1, 0, 1};
    boolean[][] vis = new boolean[m][n];
    
    // traverse first row and last row
    for(int j = 0; j < n; j++){
      // DFS from top boundary 'O'
      if(!vis[0][j] && mat[0][j] == 'O') dfs(0, j, vis, mat, delrow, delcol);

      // DFS from bottom boundary 'O' (Fixed comment)
      if(!vis[m - 1][j] && mat[m - 1][j] == 'O') dfs(m - 1, j, vis, mat, delrow, delcol);
    }

    for(int i = 0; i < m; i++){
      // DFS from left boundary 'O'
      if(!vis[i][0] && mat[i][0] == 'O') dfs(i, 0, vis, mat, delrow, delcol);

      // DFS from right boundary '0'
      if(!vis[i][n - 1] && mat[i][n - 1] == 'O') dfs(i, n - 1, vis, mat, delrow, delcol);
    }

    // flip all unvisited 'O' to 'X'
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        // convert enclosed 'O' to 'X'
        if(!vis[i][j] && mat[i][j] == 'O'){
          mat[i][j] = 'X';
        }
      }
    }

    // return updated board
    return mat;
  }
}