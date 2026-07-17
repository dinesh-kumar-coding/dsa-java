/*
 * Problem: Two sum — Striver A2Z Step 3 (medium) / LeetCode 1
 * Migrated: 2026-07-17
 * HashMap (returns indices): O(N) | Two pointers after sort (yes/no variant): O(N log N)
 * Revisit: [date]
 */
import java.util.*;

public class TwoSum {
  public static void main(String[] args) {
    int[] arr = {2, 7, 11, 15};
    System.out.println(Arrays.toString(twoSum(arr, 9)));
  }

  public static int[] twoSum(int[] arr, int target){
    Map<Integer, Integer> hash = new HashMap<>();
    for(int i = 0; i < arr.length; i++){
      if(hash.containsKey(target - arr[i])){
        return new int[] {hash.get(target - arr[i]), i};
      }
      hash.put(arr[i], i);
    }
    return new int[] {};
  }

  public static String twoSumOptimal(int[] arr, int target){
    Arrays.sort(arr);
    int low = 0, high = arr.length - 1;
    int count = 0;
    while(high > low){
      count = arr[low] + arr[high];
      if(count == target) return "YES";
      else if(count > target) high --;
      else low++;
    }
    return "NO";
  }
}
