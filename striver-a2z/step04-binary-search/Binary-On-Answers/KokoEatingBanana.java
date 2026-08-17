/*
 * Problem: KokoEatingBanana — Optimal: Binary Search on Answer | Brute: Linear Search
 * Solved: 17-08-2026 | TC: O(N * log(maxVal)) Optimal, O(N * maxVal) Brute | SC: O(1)
 * Revisit: [date]
 */

import java.util.*;

public class KokoEatingBanana {
  public static void main(String[] args) {
    int[] test1 = {3, 6, 7, 11};
    int h1 = 8;
    System.out.println("Test 1 Brute: " + minEatingSpeed_brute(test1, h1)); // Expected: 4
    System.out.println("Test 1 Optimal: " + minEatingSpeed_optimal(test1, h1)); 

    int[] test2 = {30, 11, 23, 4, 20};
    int h2 = 5;
    System.out.println("Test 2 Brute: " + minEatingSpeed_brute(test2, h2)); // Expected: 30
    System.out.println("Test 2 Optimal: " + minEatingSpeed_optimal(test2, h2)); 

    int[] test3 = {30, 11, 23, 4, 20};
    int h3 = 6;
    System.out.println("Test 3 Brute: " + minEatingSpeed_brute(test3, h3)); // Expected: 23
    System.out.println("Test 3 Optimal: " + minEatingSpeed_optimal(test3, h3)); 
  }

  public static int minEatingSpeed_brute(int[] arr, int h){
    int maxVal = Arrays.stream(arr).max().getAsInt();
    for(int i = 1; i <= maxVal; i++){
      int hours = calculateTotalHours(arr, i, h);
      if(hours <= h) return i;
    }
    return maxVal;
  }

  public static int calculateTotalHours(int[] piles, int h, int hours){
    int totalHours = 0;
    for(int pile: piles){
      totalHours += (int)Math.ceil((double)pile/h);
      if(totalHours > hours) break;
    }
    return totalHours;
  }

  public static int minEatingSpeed_optimal(int[] piles, int h){
    int maxVal = Arrays.stream(piles).max().getAsInt();
    int low = 1;
    int high = maxVal;
    int minSpeed = maxVal;
    while(high >= low){
      int mid = low + (high - low)/2;
      int hours = calculateTotalHours(piles, mid, h);
      if(hours > h) low = mid + 1;
      else {
        minSpeed = mid;
        high = mid - 1;
      }
    }
    return minSpeed;
  }
}