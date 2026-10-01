/*
 * Problem: MaxProductSubArray —
 * Question: Find the maximum product of any contiguous subarray — negatives flip the sign, so the running minimum matters too.
 * Solved: 23-08-2026 | TC:
 * Revisit: [date]
 */

public class MaxProductSubArray {
  public static void main(String[] args) {

  }

  public static int maxProductSubArray(int[] arr){
    int n = arr.length;
    int pre = 1;
    int suff = 1;
    int ans = Integer.MIN_VALUE;
    for(int i = 0; i < n; i++){
      if(pre == 0) pre = 1;
      if(suff == 0) suff = 1;
      pre *= arr[i];
      suff *= arr[n - i - 1];
      ans = Math.max(ans, Math.max(pre, suff));
    }
    return ans;
  }
}
