/*
 * Problem: Check if array is sorted — Striver A2Z Step 3 (easy)
 * Migrated: 2026-07-17 | TC: O(N)
 * Revisit: [date]
 */
public class CheckSorted {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    System.out.println(checkArrayIsSorted(arr));
  }

  public static boolean checkArrayIsSorted(int[] arr){
    for(int i = 1; i < arr.length; i++){
      if(arr[i] < arr[i - 1]){
        return false;
      }
    }
    return true;
  }
}
