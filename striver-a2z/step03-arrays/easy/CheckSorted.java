/*
 * Problem: Check if array is sorted — Striver A2Z Step 3 (easy)
 * Migrated: 2026-07-17 | TC: O(N)
 * Revisit: [date]
 */
public class CheckSorted {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    System.out.println(checkArrayIsSorted(arr));
  }

  public static boolean checkArrayIsSorted(int[] arr){
    for(int i = 1; i < arr.length; i++){
      if(arr[i] < arr[i - 1]){
        return false;
      }
    }
    return true;
  }

  public static boolean check_leetcode1752(int[] nums){
    for(int i = 1; i < nums.length; i++){
      if(nums[i - 1] > nums[i]){
        reverseArray(nums, 0, i - 1);
        reverseArray(nums, i, nums.length - 1);
        reverseArray(nums, 0, nums.length - 1);
        for(int j = 1; j < nums.length; j++){
          if(nums[j - 1] > nums[j]) return false;
        }
      }
    }
    return true;
  }

  public static void reverseArray(int[] nums, int low, int high){
    while(high > low){
      int temp = nums[low];
      nums[low] = nums[high];
      nums[high] = temp;
      high--;
      low++;
    }
  }
  
}
