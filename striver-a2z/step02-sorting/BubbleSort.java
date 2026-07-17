/*
 * Topic: Bubble sort (iterative + recursive) — Striver A2Z Step 2
 * Migrated: 2026-07-17 | TC: O(N^2) worst/avg, O(N) best (early-exit flag)
 * Note: removed leftover debug println("runs") from original
 * Revisit: [date when re-solved from scratch]
 */
import java.util.*;

public class BubbleSort {
  public static void main(String[] args) {
    int[] a = {13, 46, 24, 52, 20, 9};
    bubbleSort(a);
    System.out.println(Arrays.toString(a));
    int[] b = {5, 4, 3, 2, 1};
    recursive_bubbleSort(b, b.length);
    System.out.println(Arrays.toString(b));
  }

  public static void bubbleSort(int[] arr) {
    int temp = 0;
    int count = 0;
    for (int i = arr.length - 1; i > 0; i--) {
      count = 0;
      for (int j = 0; j < i; j++) {
        if (arr[j] > arr[j + 1]) {
          temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          count++;
        }
      }
      if (count == 0) break;
    }
  }

  public static void recursive_bubbleSort(int[] arr, int n){
    if(n == 1) return;
    int temp = 0;
    boolean flag = false;
    for(int i = 0; i < n - 1; i++){
      if(arr[i] > arr[i + 1]){
        temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp;
        flag = true;
      }
    }
    if(flag){
      return;
    }
    recursive_bubbleSort(arr, n - 1);
  }
}
