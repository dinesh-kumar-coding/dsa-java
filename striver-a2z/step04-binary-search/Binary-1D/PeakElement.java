/*
 * Problem: PeakElement — Optimal: Binary Search
 * Solved: 14-08-2026 | TC: O(log N) | SC: O(1)
 * Revisit: [date]
 */

public class PeakElement {
  public static void main(String[] args) {
    int[] test1 = {1, 2, 3, 1};
    System.out.println("Test 1: " + findPeakElement(test1));

    int[] test2 = {1, 2, 1, 3, 5, 6, 4};
    System.out.println("Test 2: " + findPeakElement(test2));

    int[] test3 = {1, 2, 3, 4, 5};
    System.out.println("Test 3: " + findPeakElement(test3));

    int[] test4 = {5, 4, 3, 2, 1};
    System.out.println("Test 4: " + findPeakElement(test4));

    int[] test5 = {1};
    System.out.println("Test 5: " + findPeakElement(test5));
  }

  public static int findPeakElement(int[] arr){
    int low = 0;
    int high = arr.length - 1;
    while(high >= low){
      if(high == low) return low;
      int mid = low + (high - low)/2;
      if(arr[mid] > arr[mid + 1]) high = mid;
      else low = mid + 1;
    }
    return -1;
  }
}