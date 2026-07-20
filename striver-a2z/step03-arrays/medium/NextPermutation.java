/*
 * Problem: Next permutation — Striver A2Z Step 3 (medium) / LeetCode 31
 * Solved: 2026-07-20 | TC: O(N), SC: O(1)
 * Steps: (1) first decreasing element from right (2) swap with rightmost greater (3) reverse suffix
 * Revisit: [date]
 */
import java.util.*;

public class NextPermutation {
  public static void main(String[] args) {
    int[] arr = {2, 1, 5, 4, 3, 0, 0};
    nextPermutation(arr);
    System.out.println(Arrays.toString(arr));
    int[] last = {3, 2, 1};
    nextPermutation(last);
    System.out.println(Arrays.toString(last));
  }

  public static void nextPermutation(int[] arr){
    int changingIndex = -1;

    // Step - 1: Find the first decreasing element from the right
    for(int i = arr.length - 2; i >= 0; i--){
      if(arr[i] < arr[i + 1]){
        changingIndex = i;
        break;
      }
    }

    // If no such element exists, we are at the highest permutation.
    // Reverse the whole array to get the lowest permutation.
    if(changingIndex == -1){
      reverseArray(arr, 0, arr.length - 1);
      return;
    }

    // Step - 2: Find the smallest element to the right of 'changingIndex'
    // that is strictly greater than arr[changingIndex].
    // Since the right side is descending, scanning from the right gives the smallest valid number.
    for(int i = arr.length - 1; i > changingIndex; i--){
      if(arr[i] > arr[changingIndex]){
        swap(arr, changingIndex, i);
        break;
      }
    }

    // Step - 3: Reverse the descending suffix to make it ascending (lowest order).
    reverseArray(arr, changingIndex + 1, arr.length - 1);
  }

  private static void swap(int[] arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private static void reverseArray(int[] arr, int start, int end){
    while(start < end){
      swap(arr, start++, end--);
    }
  }
}
