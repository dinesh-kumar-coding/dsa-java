/*
 * Problem: Maximum Product of Two Elements in an Array (LeetCode daily) — solved 2026-07-27
 * Revisit: [date]
 */

public class MaxProduct_20260727 {
  public static void main(String[] args) {
    int[] nums = {6, 4, 8};
    System.out.println(maxProduct(nums));
  }

  public static int maxProduct(int[] nums) {
        if(nums.length <= 1){
            return -1;
        }
        int maxValue = nums[0];
        int secondMaxValue = Integer.MIN_VALUE;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > maxValue){
                secondMaxValue = maxValue;
                maxValue = nums[i];
            } else if( nums[i] > secondMaxValue){
                secondMaxValue = nums[i];
            }
        }
        return (maxValue - 1)*(secondMaxValue - 1);
    }
}
