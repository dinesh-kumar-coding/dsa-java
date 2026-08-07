/*
 * Problem: MinInRotArr — Optimal: Binary Search
 * Solved: 07-08-2026 | TC: O(log N) | SC: O(1)
 * Revisit: [date]
 */

public class MinInRotArr {
  public static void main(String[] args) {
    int[] test1 = {3, 4, 5, 1, 2};
    System.out.println("Test 1: " + minInRotatedArr(test1));

    int[] test2 = {4, 5, 6, 7, 0, 1, 2};
    System.out.println("Test 2: " + minInRotatedArr(test2));

    int[] test3 = {11, 13, 15, 17};
    System.out.println("Test 3: " + minInRotatedArr(test3));

    int[] test4 = {2, 1};
    System.out.println("Test 4: " + minInRotatedArr(test4));
  }

  public static int minInRotatedArr(int[] arr){
    int low = 0;
    int high = arr.length - 1;
    while(high > low){
      int mid = low + (high - low)/2;
      if(arr[mid] > arr[high]) low = mid + 1;
      else high = mid;
    }
    return arr[low];
  }
}