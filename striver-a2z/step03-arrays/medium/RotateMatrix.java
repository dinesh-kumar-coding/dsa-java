/*
 * Topic: Rotate Matrix by 90° — Striver A2Z Step 3 (Arrays medium)
 * Migrated: 2026-07-27 (from old-STRIVER monolith) | TC: brute O(N^2) + O(N^2) space · optimal O(N^2) + O(1) space (transpose + reverse rows)
 * Revisit: [date when re-solved from scratch]
 * NOTE: optimal is correct. brute has 2 things to find — run main and watch what brute does (and doesn't) do to the matrix.
 */
import java.util.*;

public class RotateMatrix {
  public static void main(String[] args) {
    int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    // 90° clockwise should give:  {7,4,1},{8,5,2},{9,6,3}

    int[][] a = deepCopy(matrix);
    rotateMatrixBy90degrees_brute(a);
    System.out.println("brute:");
    printMatrix(a);

    int[][] b = deepCopy(matrix);
    rotateMatrixBy90degrees_optimal(b);
    System.out.println("optimal:");
    printMatrix(b);
  }

  public static void rotateMatrixBy90degrees_brute(int[][] arr) {
    int n = arr.length;
    int[][] temp = deepCopy(arr);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        temp[j][n - i - 1] = arr[i][j];
      }
    }
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        arr[i][j] = temp[i][j];
      }
    }

    // arr = temp; // If you don't care about the reference of arr.

  }

  public static int[][] deepCopy(int[][] src) {
    int[][] copy = new int[src.length][];
    for (int i = 0; i < src.length; i++)
      copy[i] = src[i].clone();
    return copy;
  }

  public static void rotateMatrixBy90degrees_optimal(int[][] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        swap(arr, i, j);
      }
    }

    for (int i = 0; i < n; i++) {
      reverseArray(arr[i]);
    }
  }

  public static void reverseArray(int[] arr) {
    int low = 0;
    int high = arr.length - 1;
    while (high > low) {
      int temp = arr[low];
      arr[low] = arr[high];
      arr[high] = temp;
      high--;
      low++;
    }
  }

  public static void swap(int[][] arr, int i, int j) {
    int temp = arr[i][j];
    arr[i][j] = arr[j][i];
    arr[j][i] = temp;
  }

  static void printMatrix(int[][] m) {
    for (int[] row : m)
      System.out.println(Arrays.toString(row));
  }
}
