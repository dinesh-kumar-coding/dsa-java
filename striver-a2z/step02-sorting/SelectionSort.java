/*
 * Topic: Selection sort — Striver A2Z Step 2
 * Migrated: 2026-07-17 | TC: O(N^2)
 * Revisit: [date when re-solved from scratch]
 */
import java.util.*;

public class SelectionSort {
  public static void main(String[] args) {
    int[] arr = {13, 46, 24, 52, 20, 9};
    selectionSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void selectionSort(int[] arr) {
    int temp = 0;
    for (int i = 0; i < arr.length - 1; i++) {
      int min = i;
      for (int j = i; j < arr.length; j++) {
        if (arr[min] > arr[j])
          min = j;
      }
      temp = arr[i];
      arr[i] = arr[min];
      arr[min] = temp;
    }
  }
}
