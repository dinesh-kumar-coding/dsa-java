/*
 * Problem: SearchElementInRotArr I & II — Optimal: Binary Search
 * Solved: 07-08-2026 | TC: O(log N) Avg, O(N) Worst (Duplicates) | SC: O(1)
 * Revisit: [date]
 */

public class SearchElementInRotArr {
  public static void main(String[] args) {
    int[] test1 = {4, 5, 6, 7, 0, 1, 2};
    int target1 = 0;
    System.out.println("Test 1 (Unique): " + searchEleInRotatedArray(test1, target1));

    int[] test2 = {4, 5, 6, 7, 0, 1, 2};
    int target2 = 3;
    System.out.println("Test 2 (Unique): " + searchEleInRotatedArray(test2, target2));

    int[] test3 = {1};
    int target3 = 0;
    System.out.println("Test 3 (Unique): " + searchEleInRotatedArray(test3, target3));
    
    int[] test4 = {5, 1, 3};
    int target4 = 5;
    System.out.println("Test 4 (Unique): " + searchEleInRotatedArray(test4, target4));

    int[] test5 = {2, 5, 6, 0, 0, 1, 2};
    int target5 = 0;
    System.out.println("Test 5 (Dupes): " + searchEleInRotatedArray_withDuplicates(test5, target5));

    int[] test6 = {2, 5, 6, 0, 0, 1, 2};
    int target6 = 3;
    System.out.println("Test 6 (Dupes): " + searchEleInRotatedArray_withDuplicates(test6, target6));

    int[] test7 = {1, 0, 1, 1, 1};
    int target7 = 0;
    System.out.println("Test 7 (Dupes): " + searchEleInRotatedArray_withDuplicates(test7, target7));
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

  public static boolean searchEleInRotatedArray_withDuplicates(int[] arr, int target){
    int low = 0;
    int high = arr.length - 1;
    while(high >= low){
      int mid = low + (high - low)/2;
      
      if(arr[mid] == target) return true;
      if(arr[low] == arr[mid] && arr[mid] == arr[high]){
        high--;
        low++;
        continue; 
      }
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
    return false;
  }
}