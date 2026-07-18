/*
 * Problem: Find GCD of smallest and largest number (LeetCode 1979, daily) — solved 2026-07-18
 * TC: O(N) min/max scan + Euclidean GCD
 * Revisit: [date]
 */
public class FindGcd_20260718 {
  public static void main(String[] args) {
    int[] nums = {2, 5, 6, 9, 10};
    System.out.println(findGCD(nums));
  }

  public static int findGCD(int[] nums) {
    int max = nums[0];
    int min = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > max)
        max = nums[i];
      if (nums[i] < min)
        min = nums[i];
    }
    return gcd(max, min);
  }

  public static int gcd(int a, int b) {
    while (a != 0 && b != 0) {
      if (a > b) {
        a %= b;
      } else {
        b %= a;
      }
    }
    if (a == 0)
      return b;
    return a;
  }
}
