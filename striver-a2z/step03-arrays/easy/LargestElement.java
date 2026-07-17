/*
 * Problem: Largest element in array — Striver A2Z Step 3 (easy)
 * Migrated: 2026-07-17 | TC: O(N)
 * Revisit: [date]
 */
public class LargestElement {
  public static void main(String[] args) {
    int[] arr = {3, 9, 4, 1};
    System.out.println(getLargestElement(arr));
  }

  public static int getLargestElement(int[] arr){
    if(arr.length == 0) return -1;
    int largest = arr[0];
    for(int i = 1; i < arr.length; i++){
      if(largest < arr[i]) largest = arr[i];
    }
    return largest;
  }
}
