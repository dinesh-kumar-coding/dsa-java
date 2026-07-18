/*
 * Problem: Maximum subarray sum (Kadane's algorithm) — Striver A2Z Step 3 (medium) / LeetCode 53
 * Solved: 2026-07-18 | TC: O(N), SC: O(1)
 * Includes follow-up variant: return the actual subarray (start/end tracking)
 * Revisit: [date]
 */
import java.util.*;

public class MaximumSubarraySum {
  public static void main(String[] args) {
    int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArraySum(arr));
    System.out.println(Arrays.toString(maxSubArray(arr)));
  }

  public static long maxSubArraySum(int[] arr) {
    long maxSum = 0;
    long sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (sum > maxSum) {
        maxSum = sum;
      }
      if (sum < 0) {
        sum = 0;
      }
    }
    return maxSum;
  }

  public static int[] maxSubArray(int[] arr) {
    if (arr == null || arr.length == 0) {
      return new int[0];
    }
    long maxSum = 0;
    long sum = 0;
    int start = 0;
    int ansStart = 0, ansEnd = 0;
    for (int i = 0; i < arr.length; i++) {
      if (sum == 0)
        start = i;
      sum += arr[i];
      if (sum > maxSum) {
        maxSum = sum;
        ansStart = start;
        ansEnd = i;
      }
      if (sum < 0) {
        sum = 0;
      }
    }
    int[] resultSubArray = new int[ansEnd - ansStart + 1];
    for (int k = 0, i = ansStart; i <= ansEnd; i++, k++) {
      resultSubArray[k] = arr[i];
    }
    return resultSubArray;
  }
}
