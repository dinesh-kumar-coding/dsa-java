/*
 * Problem: Sort array of 0s, 1s, 2s (Dutch national flag) — Striver A2Z Step 3 (medium) / LeetCode 75
 * Migrated: 2026-07-17 | Target TC: O(N) one pass
 * Revisit: [date]
 */
import java.util.*;

public class SortColors {
  public static void main(String[] args) {
    int[] arr = {2, 0, 2, 1, 1, 0};
    sortArrayOfZeroes_Ones_Twos(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void sortArrayOfZeroes_Ones_Twos(int[] arr){
    int low = 0, mid = 0, high = arr.length - 1;
    while( high >= mid){
      if(arr[mid] == 0){
        swap(arr, low, mid);
        low++;
        mid++;
      } else if(arr[mid] == 1) mid++;
      else{
        swap(arr, mid, high);
        high--;
      }
    }
  }

  public static void swap(int[] arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
