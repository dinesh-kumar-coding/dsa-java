/*
 * Problem: MinDaysToMakeBouquets — Optimal: Binary Search on Answer
 * Solved: 23-08-2026 | TC: O(N * log(max - min)) | SC: O(1)
 * Revisit: [date]
 */
public class MinDaysToMakeBouquets {
  public static void main(String[] args) {
    // Test 1: Standard case
    int[] days1 = {1, 10, 3, 10, 2};
    int m1 = 3, k1 = 1;
    System.out.println("Test 1: " + minDays(days1, m1, k1)); // Expected: 3

    // Test 2: Impossible case (not enough flowers)
    int[] days2 = {1, 10, 3, 10, 2};
    int m2 = 3, k2 = 2;
    System.out.println("Test 2: " + minDays(days2, m2, k2)); // Expected: -1

    // Test 3: Requires waiting for the highest bloom day to get adjacent flowers
    int[] days3 = {7, 7, 7, 7, 12, 7, 7};
    int m3 = 2, k3 = 3;
    System.out.println("Test 3: " + minDays(days3, m3, k3)); // Expected: 12

    // Test 4: All bouquets can be made on the very first day
    int[] days4 = {1, 1, 1, 1};
    int m4 = 2, k4 = 2;
    System.out.println("Test 4: " + minDays(days4, m4, k4)); // Expected: 1
  }

  public static int minDays(int[] bloomDays, int m, int k){
    int n = bloomDays.length;
    if(n < (long)m*k) return -1;
    
    int min = bloomDays[0];
    int max = bloomDays[0];
    for(int i = 1; i < n; i++){
      if(bloomDays[i] > max) max = bloomDays[i];
      if(bloomDays[i] < min) min = bloomDays[i];
    }

    while(max >= min){
      int mid = min + (max - min)/2;
      int count = 0;
      int bouquets = 0;
      for(int i = 0; i < n; i++){
        if(bloomDays[i] <= mid){
          count++;
        } else{
          bouquets += count/k;
          count = 0;
        }
      } 
      bouquets += count/k;
      
      if(bouquets >= m){
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }
    return min;
  }
}