/*
 * Problem: MinInRotArr I & II — Optimal: Binary Search
 * Solved: 07-08-2026 | TC: O(log N) Avg, O(N) Worst (Duplicates) | SC: O(1)
 * Revisit: [date]
 */

public class MinInRotArr {
  public static void main(String[] args) {
    int[] test1 = {3, 4, 5, 1, 2};
    System.out.println("Test 1 (Unique): " + minInRotatedArr(test1));

    int[] test2 = {4, 5, 6, 7, 0, 1, 2};
    System.out.println("Test 2 (Unique): " + minInRotatedArr(test2));

    int[] test3 = {11, 13, 15, 17};
    System.out.println("Test 3 (Unique): " + minInRotatedArr(test3));

    int[] test4 = {2, 1};
    System.out.println("Test 4 (Unique): " + minInRotatedArr(test4));

    int[] test5 = {1, 3, 5};
    System.out.println("Test 5 (Dupes): " + minInRotatedArr_withDuplicates(test5));

    int[] test6 = {2, 2, 2, 0, 1, 2};
    System.out.println("Test 6 (Dupes): " + minInRotatedArr_withDuplicates(test6));

    int[] test7 = {3, 3, 1, 3};
    System.out.println("Test 7 (Dupes): " + minInRotatedArr_withDuplicates(test7));
  }

  public static int minInRotatedArr(int[] arr){
    int low = 0;
    int high = arr.length - 1;
    while(high >= low){
      if(high == low) break;
      int mid = low + (high - low)/2;
      if(arr[mid] > arr[high]) low = mid + 1;
      else high = mid;
    }
    return arr[low];
  }

  public static int minInRotatedArr_withDuplicates(int[] arr){
    int low = 0;
    int high = arr.length - 1;
    while(high >= low){
      if(high == low) break;
      int mid = low + (high - low)/2;
      if(arr[low] == arr[mid] && arr[mid] == arr[high]){
        high--;
      }
      else if(arr[mid] > arr[high]) low = mid + 1;
      else high = mid;
    }
    return arr[low];
  }
}