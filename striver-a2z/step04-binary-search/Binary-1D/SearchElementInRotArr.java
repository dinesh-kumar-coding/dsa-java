/*
 * Problem: SearchElementInRotArr — Optimal: Binary Search
 * Solved: 07-08-2026 | TC: O(log N) | SC: O(1)
 * Revisit: [date]
 */

public class SearchElementInRotArr {
  public static void main(String[] args) {
    int[] test1 = {4, 5, 6, 7, 0, 1, 2};
    int target1 = 0;
    System.out.println("Test 1: " + searchEleInRotatedArray(test1, target1));

    int[] test2 = {4, 5, 6, 7, 0, 1, 2};
    int target2 = 3;
    System.out.println("Test 2: " + searchEleInRotatedArray(test2, target2));

    int[] test3 = {1};
    int target3 = 0;
    System.out.println("Test 3: " + searchEleInRotatedArray(test3, target3));
    
    int[] test4 = {5, 1, 3};
    int target4 = 5;
    System.out.println("Test 4: " + searchEleInRotatedArray(test4, target4));
  }

  public static int searchEleInRotatedArray(int[] arr, int target){
    int low = 0;
    int high = arr.length - 1;
    while(high >= low){
      int mid = low + (high - low)/2;
      
      if(arr[mid] == target) return mid;

      if(arr[low] <= arr[mid]){
        if(arr[low] <= target && arr[mid] >= target){
          high = mid - 1;
        } else low = mid + 1;
      } else{
        if(arr[mid] <= target && target <= arr[high]){
          low = mid + 1;
        } else high = mid - 1;
      }
    }
    return -1;
  }
}