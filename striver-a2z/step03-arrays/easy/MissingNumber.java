/*
 * Problem: Missing number 1..N (XOR trick) — Striver A2Z Step 3 (easy)
 * Migrated: 2026-07-17 | TC: O(N), SC: O(1)
 * Revisit: [date]
 */
public class MissingNumber {
  public static void main(String[] args) {
    int[] arr = {1, 2, 4, 5};
    System.out.println(missingNumber(arr, 5));
  }

  public static int missingNumber(int[] arr, int n){
    int XOR1 = 0, XOR2 = 0;
    for(int i = 0; i < n - 1; i++){
      XOR1 ^= i + 1;
      XOR2 ^= arr[i];
    }
    return (XOR1^n)^XOR2;
  }
}
