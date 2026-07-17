/*
 * Topic: Quick sort — Striver A2Z Step 2
 * Migrated: 2026-07-17 | TC: O(N log N) avg, O(N^2) worst
 * WARNING: known bug — partition deadlocks (infinite swap loop) when both pointers stall.
 * Found via automated run 2026-07-17. Fix session pending.
 * Revisit: [date when re-solved from scratch]
 */
import java.util.*;

public class QuickSort {
  public static void main(String[] args) {
    int[] arr = {13, 46, 24, 52, 20, 9};
    // quickSort(arr); // hangs — see WARNING above
    System.out.println(Arrays.toString(arr));
  }

  public static void quickSort(int[] arr){
    if(arr == null || arr.length <= 1) return;
    quickSortHelper(arr, 0, arr.length - 1);
  }

  private static void quickSortHelper(int[] arr, int low, int high){
    if(low < high){
      // Partition the array and get the final pivot index
      int pivotIndex = partition(arr, low, high);

      // Recursively sort elements before and after partition
      quickSortHelper(arr, low, pivotIndex - 1);
      quickSortHelper(arr, pivotIndex + 1, high);
    }
  }

  private static int partition(int[] arr, int low, int high){
    int pivot = arr[low];
    int i = low;
    int j = high;

    while(i < j){
      // Move i to the right as long as elements are <= pivot
      while(i <= high && arr[i] <= pivot){
        i++;
      }
      // Move j to the left as long as elements are > pivot
      while(arr[j] < pivot){
        j--;
      }
      // Swap elements if pointers haven't crossed
      if(i < j){
        swap(arr, i, j);
      }
    }

    // Place the pivot in its final sorted position
    swap(arr, low, j);
    return j;
  }

  private static void swap(int[] arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
