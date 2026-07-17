/*
 * Topic: Merge sort — Striver A2Z Step 2
 * Migrated: 2026-07-17 | TC: O(N log N), SC: O(N)
 * Revisit: [date when re-solved from scratch]
 */
import java.util.*;

public class MergeSort {
  public static void main(String[] args) {
    int[] arr = {13, 46, 24, 52, 20, 9};
    mergeSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void mergeSort(int arr[]){
    mS(arr, 0, arr.length - 1);
  }

  // Recursive merge sort
  public static void mS(int[] arr, int low, int high){

    // Base condition
    if(low >= high) return;

    // Find mid index
    int middle = (low + high)/ 2;

    // Sort left array
    mS(arr, low, middle);

    // Sort right array
    mS(arr, middle + 1, high);

    // Merge both halves
    merge(arr, low, middle, high);
  }

  // Function to merge two halves
  public static void merge(int[] arr, int low, int middle, int high) {
    // Create temp array
    List<Integer> temp = new ArrayList<>();
    int left = low, right = middle + 1;

    // Merge both sorted parts
    while(left <= middle && right <= high){
      if(arr[left] <= arr[right]){
        temp.add(arr[left++]);
      } else{
        temp.add(arr[right++]);
      }
    }
    // Add remaining left elements
    while(left <= middle){
      temp.add(arr[left++]);
    }
    // Add remaining right elements
    while(right <= high){
      temp.add(arr[right++]);
    }

    // Copy back to original array
    for(int i = low; i <= high; i++){
      arr[i] = temp.get(i - low);
    }
  }
}
