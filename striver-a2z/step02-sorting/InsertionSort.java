/*
 * Topic: Insertion sort (iterative + recursive) — Striver A2Z Step 2
 * Migrated: 2026-07-17 | TC: O(N^2) worst/avg, O(N) best
 * Revisit: [date when re-solved from scratch]
 */
import java.util.*;

public class InsertionSort {
  public static void main(String[] args) {
    int[] a = {13, 46, 24, 52, 20, 9};
    inserstionSort(a);
    System.out.println(Arrays.toString(a));
    int[] b = {5, 4, 3, 2, 1};
    recursive_inserstionSort(b, 0, b.length);
    System.out.println(Arrays.toString(b));
  }

  public static void inserstionSort(int[] arr){
    for(int i = 1; i < arr.length; i++){
      int j = i - 1;
      int key = arr[i];
      while(j >= 0 && arr[j] > key){
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }

  public static void recursive_inserstionSort(int[] arr, int i, int n){
    // Base case:
    if(i == n) return;

    int j = i;
    // Move the current element back until it's in the corret place
    while(j > 0 && arr[j - 1] > arr[j]){
      // Swap arr[j] and arr[j - 1]
      int temp = arr[j - 1];
      arr[j - 1] = arr[j];
      arr[j] = temp;
      j--;
    }

    // Recur for the next index
    recursive_inserstionSort(arr, i + 1, n);
  }
}
