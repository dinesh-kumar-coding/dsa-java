/*
 * Topic: Count Subarrays with Sum K — Striver A2Z Step 3 (Arrays medium) · LeetCode 560
 * Written: 2026-07-29
 * Approaches: brute O(N^2)/O(1) · optimal prefix-sum + HashMap O(N)/O(N) (works with negatives) · sliding window O(N)/O(1) (positive numbers only)
 * Revisit: [date when re-solved from scratch]
 */
import java.util.*;

public class SubArraysSumK {
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 1, 1, 1 };
    int k = 3; // expected: 3  ->  [1,2], [3], [1,1,1]
    System.out.println("brute:            " + subArraysSumK_brute(arr, k));
    System.out.println("optimal (prefix): " + subArraysSumK_optimal(arr, k));
    System.out.println("sliding (pos):    " + SubArraysSumKIfNumsOnlyPositive(arr, k));
  }

  public static int subArraysSumK_brute(int[] arr, int k){
    int n = arr.length;
    int count = 0;
    for(int i = 0; i < arr.length; i++){
      int currSum = 0;
      for(int j = i; j < n; j++){
        currSum += arr[j];
        if(currSum == k) count++; 
      }
    }
    return count;
  }

  public static int subArraysSumK_optimal(int[] arr, int k){
    int n = arr.length;
    long sum = 0;
    int count = 0;
    Map<Long, Integer> hash = new HashMap<>();
    hash.put(0L, 1);
    for(int i = 0; i < n; i++){
      sum += arr[i];
      long rem = sum - k;
      if(hash.containsKey(rem)) count += hash.get(rem);
      hash.put(sum , hash.getOrDefault(sum, 0) + 1);
    }
    return count;
  }

  public static int SubArraysSumKIfNumsOnlyPositive(int[] arr, int k){
    int n = arr.length;
    int sum = 0;
    int count = 0;
    int i = 0;
    for(int j = 0; j < n; j++){
      sum += arr[j];
      if(sum > k){
        while(sum > k && i < j){
          sum -= arr[i];
          i++;
        }
      }

      if(sum == k) count++;
    }
    return count;
  }
  
}
