/*
 * Topic: Binary Search — Striver A2Z Step 4 (fundamentals)
 * Written: 2026-07-29
 * Approaches: iterative + recursive binary search · lower bound · upper bound
 * Revisit: [date when re-solved from scratch]
 * Keep in mind:  mid = low + (high - low)/2  (overflow-safe)  ·  low <= high vs low < high  ·  shrink with mid+1 / mid-1
 */

public class BinarySearch {
  public static void main(String[] args) {
    int[] arr = { 3, 5, 8, 8, 8, 11, 15, 22 }; // sorted
    // Expected:
    //   search(8)     -> an index of 8  (2, 3, or 4)
    //   search(9)     -> -1  (not present)
    //   lowerBound(8) -> 2   (first i with arr[i] >= 8)
    //   upperBound(8) -> 5   (first i with arr[i] >  8)
    System.out.println("iterative search(8): " + binarySearch_iterative(arr, 8));
    System.out.println("iterative search(9): " + binarySearch_iterative(arr, 9));
    System.out.println("recursive search(8): " + binarySearch_recursive(arr, 8, 0, arr.length - 1));
    System.out.println("lowerBound(8):       " + lowerBound(arr, 8));
    System.out.println("upperBound(8):       " + upperBound(arr, 8));
  }

  // Return an index i such that arr[i] == target, else -1.
  public static int binarySearch_iterative(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    while(high >= low){
      int mid = low + (high - low)/2;
      if(arr[mid] == target) return mid;
      else if(arr[mid] < target) low = mid + 1;
      else high = mid - 1;
    }
    return -1;
  }

  // Same thing, recursively. Return index of target within arr[low..high], else -1.
  public static int binarySearch_recursive(int[] arr, int target, int low, int high) {
    if(high < low) return -1;
    int mid = low + (high - low)/2;
    if(arr[mid] == target) return mid;
    else if(arr[mid] < target) return binarySearch_recursive(arr, target, mid + 1, high);
    else return binarySearch_recursive(arr, target, low, mid - 1);
  }

  // First index i where arr[i] >= target   (returns arr.length if none). Classic "lower bound".
  public static int lowerBound(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int resultIndex = arr.length;
    while(high >= low){
      int mid = low + (high - low)/2;
      if(arr[mid] >= target){
        resultIndex = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return resultIndex;
  }

  // First index i where arr[i] >  target    (returns arr.length if none). Classic "upper bound".
  public static int upperBound(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int resultIndex = arr.length;
    while(high >= low){
      int mid = low + (high - low)/2;
      if(arr[mid] > target){
        resultIndex = mid;
        high = mid - 1;
      } else{
        low = mid + 1;
      }
    }
    return resultIndex;
  }
}
