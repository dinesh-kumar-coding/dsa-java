/*
 * Problem: GCD sum (LeetCode daily) — solved 2026-07-16
 * Approach: prefix max + prefix gcd, sort, pair ends
 * Note: debug prints from original kept commented for reference
 * Revisit: [date]
 */
import java.util.*;

public class GcdSum_20260716 {
  public static void main(String[] args) {
    int[] nums = {6, 4, 8};
    System.out.println(gcdSum(nums));
  }

  public static long gcdSum(int[] nums) {
    int n = nums.length;
    int[] maxI = new int[n];
    int[] prefixGcd = new int[n];
    maxI[0] = nums[0];
    prefixGcd[0] = nums[0];
    for(int i = 1; i < n; i++){
        maxI[i] = Math.max(maxI[i - 1], nums[i]);
        prefixGcd[i] = gcd(maxI[i], nums[i]);
    }
    Arrays.sort(prefixGcd);
    long result = 0;
    for(int i = 0; i < n/2; i++){
        result += gcd(prefixGcd[i], prefixGcd[n - i - 1]);
    }
    return result;
  }

  public static int gcd(int a, int b){
    while(a != 0 && b != 0){
        if(a > b){
            a %= b;
        }else{
            b %= a;
        }
    }
    if(a == 0) return b;
    return a;
  }
}
