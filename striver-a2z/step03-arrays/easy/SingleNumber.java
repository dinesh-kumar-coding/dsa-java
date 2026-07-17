/*
 * Problem: Number appearing once, others twice (XOR) — Striver A2Z Step 3 (easy)
 * Migrated: 2026-07-17 | TC: O(N), SC: O(1)
 * Revisit: [date]
 */
public class SingleNumber {
  public static void main(String[] args) {
    int[] arr = {4, 1, 2, 1, 2};
    System.out.println(findNumberThatAppearsOnceAndOtherNumberTwice(arr));
  }

  public static int findNumberThatAppearsOnceAndOtherNumberTwice(int[] arr){
    int XOR = 0;
    for(int i = 0; i < arr.length; i++){
      XOR ^= arr[i];
    }
    return XOR;
  }
}
