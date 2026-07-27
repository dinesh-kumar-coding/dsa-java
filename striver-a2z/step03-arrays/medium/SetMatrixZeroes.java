/*
 * Topic: Set Matrix Zeroes — Striver A2Z Step 3 (Arrays medium)
 * Migrated: 2026-07-27 (from old-STRIVER monolith) | TC: brute O((N*M)*(N+M)), better O(N*M) + O(N+M) space, optimal O(N*M) + O(1) space
 * Revisit: [date when re-solved from scratch]
 */
import java.util.*;

public class SetMatrixZeroes {
  public static void main(String[] args) {
    int[][] matrix = { { 1, 0, 1 }, { 1, 1, 1 }, { 1, 1, 1 } }; // the single 0 should zero its whole row + column

    int[][] a = deepCopy(matrix);
    setMatrixZeroes_better(a);
    System.out.println("better (correct reference):");
    printMatrix(a);

    int[][] b = deepCopy(matrix);
    setMatrixZeroes_brute(b);
    System.out.println("brute:"); 
    printMatrix(b);

    int[][] c = deepCopy(matrix);
    setMatrixZeroes_optimal(c);
    System.out.println("optimal:"); 
    printMatrix(c);
  }

  static int[][] deepCopy(int[][] src) {
    int[][] copy = new int[src.length][];
    for (int i = 0; i < src.length; i++)
      copy[i] = src[i].clone();
    return copy;
  }

  static void printMatrix(int[][] m) {
    for (int[] row : m)
      System.out.println(Arrays.toString(row));
  }

  public static void setMatrixZeroes_brute(int[][] arr) {
    int n = arr.length;
    int m = arr[0].length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (arr[i][j] == 0) {
          fillZeroes(arr, i, j);
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (arr[i][j] == -1) {
          arr[i][j] = 0;
        }
      }
    }
  }

  public static void fillZeroes(int[][] arr, int i, int j) {
    for (int k = 0; k < arr.length; k++) {
      if (arr[k][j] == 1) {
        arr[k][j] = -1;
      }
    }
    for (int l = 0; l < arr[0].length; l++) {
      if (arr[i][l] == 1) {
        arr[i][l] = -1;
      }
    }
  }

  public static void setMatrixZeroes_better(int[][] arr) {
    int n = arr.length;
    int m = arr[0].length;
    boolean[] rowMatrix = new boolean[n];
    boolean[] columnMatrix = new boolean[m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (arr[i][j] == 0) {
          rowMatrix[i] = true;
          columnMatrix[j] = true;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (rowMatrix[i] || columnMatrix[j]) {
          arr[i][j] = 0;
        }
      }
    }
  }

  public static void setMatrixZeroes_optimal(int[][] arr) {
    int n = arr.length;
    int m = arr[0].length;
    // Flag to track if first row should be zeroes
    boolean firstRowZero = false;
    // Flag to track if first column should be zeroes
    boolean firstColZero = false;

    // Check if first row has any zeroes
    for (int i = 0; i < n; i++) {
      if (arr[i][0] == 0) {
        firstColZero = true;
        break;
      }
    }

    // Check if first column has any zeroes
    for (int j = 0; j < m; j++) {
      if (arr[0][j] == 0) {
        firstRowZero = true;
        break;
      }
    }

    // Use first row/column as markers
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (arr[i][j] == 0) {
          arr[i][0] = 0;
          arr[0][j] = 0;
        }
      }
    }

    // Set cells to zero based on markers
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (arr[i][j] != 0) {
          if (arr[0][j] == 0 || arr[i][0] == 0) {
            arr[i][j] = 0;
          }
        }
      }
    }

    // Zero the first column if needed
    if (firstColZero) {
      for (int i = 0; i < n; i++)
        arr[i][0] = 0;
    }

    // Zero the first row if needed
    if (firstRowZero) {
      for (int j = 0; j < m; j++)
        arr[0][j] = 0;
    }

  }
}
