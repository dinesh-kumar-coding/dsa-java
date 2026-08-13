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

  // Function to perform Binary Search on sorted array
  public static int binarySearch_iterative(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;

    // Keep searching until low crosses high
    while(high >= low){
      int mid = low + (high - low)/2; // Find the middle index
      if(arr[mid] == target) return mid; // Target found
      else if(arr[mid] < target) low = mid + 1; // Search to right half
      else high = mid - 1; // Search to left half
    }
    return -1; // Target not found
  }

  // Recursive Binary Search function
  public static int binarySearch_recursive(int[] arr, int target, int low, int high) {
    if(high < low) return -1; // Base case: target not found
    // Find middle index
    int mid = low + (high - low)/2;

    // If target is found at mid
    if(arr[mid] == target) return mid;

    // If target is greater, search right half
    else if(arr[mid] < target) return binarySearch_recursive(arr, target, mid + 1, high);

    // Otherwise, search left half
    else return binarySearch_recursive(arr, target, low, mid - 1);
  }

  // Function to find the lower bound index using binary search
  public static int lowerBound(int[] arr, int target) {
    int low = 0; // Start index
    int high = arr.length - 1; // End index
    int resultIndex = arr.length; // Default value if not found
    while(high >= low){
      int mid = low + (high - low)/2; // Find mid index
      if(arr[mid] >= target){
        resultIndex = mid; // Store possible answer
        high = mid - 1; // Move left
      } else {
        low = mid + 1; // Move right
      }
    }
    return resultIndex; // Return the lower bound index
  }

  // Binary search to find upper bound
  public static int upperBound(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int resultIndex = arr.length; // Default to length if not found
    while(high >= low){
      int mid = low + (high - low)/2;
      if(arr[mid] > target){
        resultIndex = mid; // Store current index as potential answer
        high = mid - 1; // Move left
      } else{
        low = mid + 1; // Move right
      }
    }
    return resultIndex; // Return final answer
  }
}
