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

    // Mean test: h == piles.length forces the answer to be max(piles)
    int[] test4 = {1, 1, 1, 999999999};
    System.out.println("Test 4 Optimal (h = n): " + minEatingSpeed_optimal(test4, 4)); // Expected: 999999999

    // Mean test: the overflow case — speed 1 sums every pile, which exceeds int range
    int[] test5 = {1000000000, 1000000000, 1000000000};
    System.out.println("Test 5 Optimal (overflow probe): " + minEatingSpeed_optimal(test5, 3)); // Expected: 1000000000
    System.out.println("Test 5 total hours at speed 1: " + calculateTotalHours(test5, 1)); // Expected: 3000000000 (needs long)
  }

  public static int minEatingSpeed_brute(int[] piles, int limit){
    int maxVal = Arrays.stream(piles).max().getAsInt();
    for(int speed = 1; speed <= maxVal; speed++){
      long hours = calculateTotalHours(piles, speed);
      if(hours <= limit) return speed;
    }
    return maxVal;
  }

  // Hours needed to finish every pile at this speed.
  // Returns the TRUE total (no early exit) — long, because at speed 1 the
  // total is the sum of all piles, which overflows int for large inputs.
  public static long calculateTotalHours(int[] piles, int speed){
    long totalHours = 0;
    for(int pile: piles){
      totalHours += (pile + speed - 1)/speed;   // integer ceiling, no floating point
    }
    return totalHours;
  }

  public static int minEatingSpeed_optimal(int[] piles, int limit){
    int maxVal = Arrays.stream(piles).max().getAsInt();
    int low = 1;
    int high = maxVal;
    int minSpeed = maxVal;
    while(high >= low){
      int mid = low + (high - low)/2;
      long hours = calculateTotalHours(piles, mid);
      if(hours > limit) low = mid + 1;
      else {
        minSpeed = mid;
        high = mid - 1;
      }
    }
    return minSpeed;
  }
}