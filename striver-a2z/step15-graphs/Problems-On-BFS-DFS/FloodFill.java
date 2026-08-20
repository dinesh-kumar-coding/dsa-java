/*
 * Problem: FloodFill — Optimal: BFS
 * Solved: 20-08-2026 | TC: O(M * N) | SC: O(M * N)
 * Revisit: [date]
 */
import java.util.*;

public class FloodFill {
  public static void main(String[] args) {
    // Test 1: Standard flood fill
    int[][] image1 = {
      {1, 1, 1},
      {1, 1, 0},
      {1, 0, 1}
    };
    System.out.println("Test 1:");
    int[][] res1 = floodFill(image1, 1, 1, 2); // sr = 1, sc = 1, color = 2
    printMatrix(res1);
    // Expected:
    // [2, 2, 2]
    // [2, 2, 0]
    // [2, 0, 1]

    // Test 2: Starting pixel is already the target color (Should do nothing)
    int[][] image2 = {
      {0, 0, 0},
      {0, 0, 0}
    };
    System.out.println("\nTest 2:");
    int[][] res2 = floodFill(image2, 0, 0, 0); // sr = 0, sc = 0, color = 0
    printMatrix(res2);
    // Expected:
    // [0, 0, 0]
    // [0, 0, 0]
  }

  // Helper method to print the 2D matrix
  private static void printMatrix(int[][] matrix) {
    for (int[] row : matrix) {
      System.out.println(Arrays.toString(row));
    }
  }

  public static int[][] floodFill(int[][] image, int sr, int sc, int color){
    if(image[sr][sc] != color){
      int m = image.length;
      int n = image[0].length;
      Queue<int[]> q = new LinkedList<>();
      int[] delrow = {-1, 0, 1, 0};
      int[] delcol = {0, -1, 0, 1};
      int startingPixel = image[sr][sc];
      image[sr][sc] = color;
      q.offer(new int[] {sr, sc});

      while(!q.isEmpty()){
        int[] node = q.poll();
        int row = node[0];
        int col = node[1];

        for(int k = 0; k < 4; k++){
          int nrow = row + delrow[k];
          int ncol = col + delcol[k];
          if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && image[nrow][ncol] == startingPixel){
            image[nrow][ncol] = color;
            q.add(new int[] {nrow, ncol});
          }
        }
      }
    }
    return image;
  }
}