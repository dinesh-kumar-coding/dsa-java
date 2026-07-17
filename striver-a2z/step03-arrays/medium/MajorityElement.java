/*
 * Problem: Majority element (> N/2) — Striver A2Z Step 3 (medium) / LeetCode 169
 * Migrated: 2026-07-17
 * HashMap: O(N) time, O(N) space | Optimal: Boyer-Moore voting O(N) time, O(1) space
 * Revisit: [date]
 */
import java.util.*;

public class MajorityElement {
  public static void main(String[] args) {
    int[] arr = {2, 2, 1, 1, 1, 2, 2};
    System.out.println(majorityElement_optimal(arr));
  }

  public static int majorityElement(int[] nums) {
    Map<Integer, Integer> hash = new HashMap<>();
    int count = 0;
    int n = nums.length;
    for(int num: nums){
      count = hash.getOrDefault(num, 0) + 1;
      if(count > n/2) return num;
      hash.put(num, count);
    }
    return -1;
  }

  public static int majorityElement_optimal(int[] arr){
    int count = 0;
    int n = arr.length;
    int candidate = -1;
    for(int i = 0; i < n; i++){
      if(count == 0){
        count = 1;
        candidate = arr[i];
      }
      else if(arr[i] == candidate) count++;
      else{
        count --;
      }
    }

    int originalCount = 0;
    for(int i = 0; i < n; i++){
      if(arr[i] == candidate) originalCount++;
    }
    return originalCount > n/2? candidate: -1;
  }
}
