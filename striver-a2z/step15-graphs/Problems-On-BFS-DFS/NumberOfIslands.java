/*
 * Problem: Number of Islands (4 Directions & 8 Directions) — Optimal: BFS
 * Solved: 19-08-2026 | TC: O(M * N) | SC: O(M * N)
 * Revisit: [date]
 */
import java.util.*;

class Pair<X, Y> {
  public X first;
  public Y second;

  public Pair(X first, Y second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public String toString() {
    return "(" + first + ", " + second + ")";
  }
}

public class NumberOfIslands {
  public static void main(String[] args) {
    // Test 1: Diagonal connection
    // 1 0 0
    // 0 1 0
    // 0 0 1
    char[][] grid1 = {
      {'1', '0', '0'},
      {'0', '1', '0'},
      {'0', '0', '1'}
    };
    System.out.println("Test 1 (Diagonal)");
    System.out.println("8 Directions: " + noOfIslands_8Directions(grid1)); // Expected: 1
    System.out.println("4 Directions: " + noOfIslands_4Directions(grid1)); // Expected: 3
    System.out.println();

    // Test 2: Standard multiple islands
    // 0 1 1 1 0 0 0
    // 0 0 1 1 0 1 0
    char[][] grid2 = {
      {'0', '1', '1', '1', '0', '0', '0'},
      {'0', '0', '1', '1', '0', '1', '0'}
    };
    System.out.println("Test 2 (Standard)");
    System.out.println("8 Directions: " + noOfIslands_8Directions(grid2)); // Expected: 2
    System.out.println("4 Directions: " + noOfIslands_4Directions(grid2)); // Expected: 2
    System.out.println();

    // Test 3: Disconnected corners
    // 1 0 1
    // 0 0 0
    // 1 0 1
    char[][] grid3 = {
      {'1', '0', '1'},
      {'0', '0', '0'},
      {'1', '0', '1'}
    };
    System.out.println("Test 3 (Corners)");
    System.out.println("8 Directions: " + noOfIslands_8Directions(grid3)); // Expected: 4
    System.out.println("4 Directions: " + noOfIslands_4Directions(grid3)); // Expected: 4
  } 

  // GFG Version: Checks all 8 directions including diagonals
  public static int noOfIslands_8Directions(char[][] grid){
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] vis = new boolean[m][n];
    int result = 0;
    
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        if(grid[i][j] == '1' && !vis[i][j]){
          result++;
          vis[i][j] = true;
          Queue<Pair<Integer, Integer>> q = new LinkedList<>();
          q.add(new Pair<>(i, j));
          
          while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            
            for(int delrow = -1; delrow <= 1; delrow++){
              for(int delcol = -1; delcol <= 1; delcol++){
                int nrow = row + delrow;
                int ncol = col + delcol;
                if(nrow >= 0 && ncol >= 0 && nrow < m && ncol < n
                  && grid[nrow][ncol] == '1' && !vis[nrow][ncol]){
                    q.add(new Pair<>(nrow, ncol));
                    vis[nrow][ncol] = true;
                }
              }
            }
          }
        }
      }
    }
    return result;
  }

  // LeetCode Version: Checks only Up, Down, Left, Right
  public static int noOfIslands_4Directions(char[][] grid){
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] vis = new boolean[m][n];
    int result = 0;
    
    // Direction vectors for Up, Right, Down, Left
    int[] dRow = {-1, 0, 1, 0};
    int[] dCol = {0, 1, 0, -1};
    
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        if(grid[i][j] == '1' && !vis[i][j]){
          result++;
          vis[i][j] = true;
          Queue<Pair<Integer, Integer>> q = new LinkedList<>();
          q.add(new Pair<>(i, j));
          
          while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            
            // Loop exactly 4 times for the 4 directions
            for(int d = 0; d < 4; d++){
              int nrow = row + dRow[d];
              int ncol = col + dCol[d];
              
              if(nrow >= 0 && ncol >= 0 && nrow < m && ncol < n
                && grid[nrow][ncol] == '1' && !vis[nrow][ncol]){
                  q.add(new Pair<>(nrow, ncol));
                  vis[nrow][ncol] = true;
              }
            }
          }
        }
      }
    }
    return result;
  }
}