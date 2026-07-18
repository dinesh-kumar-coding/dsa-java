/*
 * Problem: Best time to buy and sell stock — Striver A2Z Step 3 (medium) / LeetCode 121
 * Solved: 2026-07-18 | TC: O(N), SC: O(1) — track min-so-far, max the diff
 * Revisit: [date]
 */
public class StockBuySell {
  public static void main(String[] args) {
    int[] prices = {7, 1, 5, 3, 6, 4};
    System.out.println(maximumProfit(prices));
  }

  public static int maximumProfit(int[] arr) {
    int profit = 0;
    int buy = arr[0];
    for (int i = 1; i < arr.length; i++) {
      int diff = arr[i] - buy;
      if (diff > profit)
        profit = diff;
      if (arr[i] < buy)
        buy = arr[i];
    }
    return profit;
  }
}
