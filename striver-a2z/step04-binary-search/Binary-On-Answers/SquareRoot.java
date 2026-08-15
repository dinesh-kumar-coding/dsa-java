/*
 * Problem: SquareRoot (N-th Root) — Optimal: Binary Search
 * Solved: 15-08-2026 | TC: O(N * log(M)) where M is num | SC: O(1)
 * Revisit: [date]
 */
public class SquareRoot {
  public static void main(String[] args) {
    System.out.println("Test 1 (Cube root of 27): " + squareRoot(27, 3)); 
    System.out.println("Test 2 (Square root of 16): " + squareRoot(16, 2)); 
    System.out.println("Test 3 (5th root of 32): " + squareRoot(32, 5)); 
    System.out.println("Test 4 (Cube root of 28): " + squareRoot(28, 3)); 
    System.out.println("Test 5 (Square root of 9): " + squareRoot(9, 2)); 
  }

  // Functoin to find N-th root of num using binary search
  public static int squareRoot(int num, int n){
    int low = 1;
    int high = num;
    while(high >= low){
      int mid = low + (high - low)/2;
      // Store the result of mid^n
      long ans = 1;
      for(int i = 0; i < n; i++){
        ans *= mid;
        if(ans > num) break;
      }
      // If mid^n equals num
      if(ans == num) return mid;
      // If mid^n is more than num
      else if(ans > num) high = mid - 1;
      // If mid^n is less than num
      else low = mid + 1;
    }

    // Return -1 if not found
    return -1;
  }
}