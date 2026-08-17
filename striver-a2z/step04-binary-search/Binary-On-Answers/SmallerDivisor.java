/*
 * Problem: SmallerDivisor — Optimal: Binary Search on Answer
 * Solved: 17-08-2026 | TC: O(N * log(maxVal)) | SC: O(1)
 * Revisit: [date]
 */

public class SmallerDivisor {
  public static void main(String[] args) {
    int[] test1 = {1, 2, 5, 9};
    int threshold1 = 6;
    System.out.println("Test 1: " + smallestDivisor(test1, threshold1)); // Expected: 5

    int[] test2 = {2, 3, 5, 7, 11};
    int threshold2 = 11;
    System.out.println("Test 2: " + smallestDivisor(test2, threshold2)); // Expected: 3

    int[] test3 = {19};
    int threshold3 = 5;
    System.out.println("Test 3: " + smallestDivisor(test3, threshold3)); // Expected: 4

    int[] test4 = {44, 22, 33, 11, 1};
    int threshold4 = 5;
    System.out.println("Test 4: " + smallestDivisor(test4, threshold4)); // Expected: 44
    
    int[] test5 = {21212, 10101, 12121};
    int threshold5 = 1000000;
    System.out.println("Test 5: " + smallestDivisor(test5, threshold5)); // Expected: 1
  }

  public static int smallestDivisor(int[] nums, int threshold){
    int maxVal = -1;
    for(int num: nums){
      if(num > maxVal) maxVal = num; 
    }
    int low = 1;
    int high = maxVal;
    int result = maxVal;
    while(high >= low){
      int mid = low + (high - low)/2;
      int sum = 0;
      for(int num: nums){
        sum += (num + mid - 1)/mid;
        if(sum > threshold) break;
      }
      if(sum <= threshold){
        result = mid;
        high = mid - 1;
      } else{
        low = mid + 1;
      }
    }
    return result;
  }
}