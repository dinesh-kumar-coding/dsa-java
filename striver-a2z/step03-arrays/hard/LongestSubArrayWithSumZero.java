/*
 * Problem: LongestSubArrayWithSumZero — Optimal: Prefix Sum & HashMap
 * Solved: 14-08-2026 | TC: O(N) | SC: O(N)
 * Revisit: [date]
 */
import java.util.*;

public class LongestSubArrayWithSumZero {
  public static void main(String[] args) {
    int[] test1 = {1, 3, -1, 4, -4};
    System.out.println("Test 1: " + LongestSubArrWithSum_Zero(test1));

    int[] test2 = {15, -2, 2, -8, 1, 7, 10, 23};
    System.out.println("Test 2: " + LongestSubArrWithSum_Zero(test2));

    int[] test3 = {0, 0, 0, 0};
    System.out.println("Test 3: " + LongestSubArrWithSum_Zero(test3));

    int[] test4 = {1, 2, 3};
    System.out.println("Test 4: " + LongestSubArrWithSum_Zero(test4));

    int[] test5 = {1, -1, 1, -1, 1, -1};
    System.out.println("Test 5: " + LongestSubArrWithSum_Zero(test5));
  }

  public static int LongestSubArrWithSum_Zero(int[] arr){
    int maxLength = 0;
    Map<Integer, Integer> hash = new HashMap<>();
    int sum = 0;
    for(int i = 0; i < arr.length; i++){
      sum += arr[i];
      if(sum == 0) maxLength = i + 1;
      
      if(hash.containsKey(sum)){
        maxLength = Math.max(maxLength, i - hash.get(sum));
      }
      else{
        hash.put(sum, i);
      }
    }
    return maxLength;
  }
}