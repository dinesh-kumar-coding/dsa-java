/*
 * Problem: Move zeros to end — Striver A2Z Step 3 (easy)
 * Migrated: 2026-07-17 | Brute: O(N) + O(N) space; Optimal: O(N), O(1) space (two pointers)
 * Revisit: [date]
 */
import java.util.*;

public class MoveZeros {
  public static void main(String[] args) {
    int[] arr = {0, 1, 0, 3, 12};
    moveZeros_optimal(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void moveZeros_bruteforce(int []arr) {
    List<Integer> temp = new ArrayList<>();
    for(int i = 0; i < arr.length; i++){
        if(arr[i] != 0) temp.add(arr[i]);
    }
    for(int i = 0; i < temp.size(); i++){
        arr[i] = temp.get(i);
    }
    for(int i = temp.size(); i < arr.length; i++){
        arr[i] = 0;
    }
  }

  public static void moveZeros_optimal(int arr[]){
    for(int i = 0,j = 0; i < arr.length; i++){
      if(arr[i] != 0){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        j++;
      }
    }
  }
}
