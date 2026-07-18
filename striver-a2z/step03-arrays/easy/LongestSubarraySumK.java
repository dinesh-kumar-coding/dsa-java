/*
 * Problem: Longest subarray with sum K — Striver A2Z Step 3 (easy)
 * Migrated: 2026-07-17
 * Brute: O(N^2) | Better (pos+neg): prefix-sum + HashMap O(N) | Optimal (pos only): two pointers O(N)
 * Revisit: [date]
 */
import java.util.*;

public class LongestSubarraySumK {
  public static void main(String[] args) {
    int[] arr = {2, 3, 5, 1, 9};
    System.out.println(longestSubArrayWithSumKOptimalForOnlyPositiveOrWithZeroes(arr, 10));
  }

  public static int longestSubArrayWithSumK(int[] arr, int k){
    int length = 0;
    int sum = 0;
    for(int i = 0; i < arr.length; i++){
      sum = 0;
      for(int j = i; j < arr.length; j++){
        sum += arr[j];
        if(sum == k){
          length = Math.max(length, j - i + 1);
        }
      }
    }
    return length;
  }

  public static int longestSubArrayWithSumKBetterForBothPositiveAndNegative(int[] arr, int k){
    int maxLength = 0;
    long sum = 0;
    Map<Long, Integer> hash = new HashMap<>();
    for(int i = 0; i < arr.length; i++){
      sum += arr[i];
      if(sum == k) maxLength = Math.max(maxLength, i + 1);
      long rem = sum - k;
      if(hash.containsKey(rem)){
        maxLength = Math.max(maxLength, i - hash.get(rem));
      }
      if(!hash.containsKey(sum)){
        hash.put(sum, i);
      }
    }
    return maxLength;
  }

  public static int longestSubArrayWithSumKOptimalForOnlyPositiveOrWithZeroes(int[] arr, int k){
    int maxLength = 0;
    long sum = 0;
    int i = 0, j = 0;
    while(j < arr.length){
      sum += arr[j];
      while(sum > k && i <= j){
        sum -= arr[i];
        i++;
      }
      if(sum == k){
        maxLength = Math.max(maxLength, j - i + 1);
      }
      j++;
    }
    return maxLength;
  }
}
