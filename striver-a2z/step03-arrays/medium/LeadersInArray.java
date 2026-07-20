/*
 * Problem: Leaders in an array — Striver A2Z Step 3 (medium)
 * Solved: 2026-07-20 | TC: O(N), SC: O(1) extra — right-to-left running max
 * Revisit: [date]
 */
import java.util.*;

public class LeadersInArray {
  public static void main(String[] args) {
    int[] arr = {10, 22, 12, 3, 0, 6};
    System.out.println(LeadersInAnArray(arr));
  }

  public static ArrayList<Integer> LeadersInAnArray(int[] arr){
    int max = Integer.MIN_VALUE;
    ArrayList<Integer> result = new ArrayList<>();
    for(int i = arr.length - 1; i >= 0; i--){
      if(max < arr[i]){
        max = arr[i];
        result.add(max);
      }
    }
    Collections.reverse(result);
    return result;
  }
}
