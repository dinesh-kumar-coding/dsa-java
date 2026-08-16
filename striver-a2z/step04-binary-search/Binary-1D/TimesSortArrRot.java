/*
 * Problem: TimesSortArrRot — Optimal: Binary Search (Find Min Index)
 * Solved: 07-08-2026 | TC: O(log N) Avg, O(N) Worst (Duplicates) | SC: O(1)
 * Revisit: [date]
 */

public class TimesSortArrRot {
  public static void main(String[] args) {
    int[] test1 = {3, 4, 5, 1, 2};
    System.out.println("Test 1 (Unique): " + timesSortedArrayIsRotated(test1));

    int[] test2 = {4, 5, 6, 7, 0, 1, 2};
    System.out.println("Test 2 (Unique): " + timesSortedArrayIsRotated(test2));

    int[] test3 = {11, 13, 15, 17};
    System.out.println("Test 3 (Unique): " + timesSortedArrayIsRotated(test3));

    int[] test4 = {2, 1};
    System.out.println("Test 4 (Unique): " + timesSortedArrayIsRotated(test4));

    int[] test5 = {1, 3, 5};
    System.out.println("Test 5 (Dupes): " + timesSortedArrayIsRotated(test5));

    int[] test6 = {2, 2, 2, 0, 1, 2};
    System.out.println("Test 6 (Dupes): " + timesSortedArrayIsRotated(test6));

    int[] test7 = {3, 3, 1, 3};
    System.out.println("Test 7 (Dupes): " + timesSortedArrayIsRotated(test7));
  }

  public static int timesSortedArrayIsRotated(int[] arr){
    int low = 0;
    int high = arr.length - 1;
    while(high >= low){
      int mid = low + (high - low)/2;
      if(low == high){
        break;
      }
      if(arr[low] == arr[mid] && arr[mid] == arr[high]){
        high--;
      } else if(arr[mid] > arr[high]){
        low = mid + 1;
      } else high = mid;
    }
    return low;
  }
}