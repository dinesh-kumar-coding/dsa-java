/*
 * Problem: Remove duplicates from sorted array (two pointers) — Striver A2Z Step 3 (easy)
 * Migrated: 2026-07-17 | TC: O(N)
 * Revisit: [date]
 */
public class RemoveDuplicatesSorted {
  public static void main(String[] args) {
    int[] arr = {1, 1, 2, 2, 2, 3, 3};
    System.out.println(getNumberOfNonDuplicatesFromSortedArray(arr));
  }

  public static int getNumberOfNonDuplicatesFromSortedArray(int[] arr){
    if(arr.length == 0) return 0;
    int i = 0;
    for(int j = 1; j < arr.length; j++){
      if(arr[i] != arr[j]){
        arr[++i] = arr[j];
      }
    }
    return i + 1;
  }
}
