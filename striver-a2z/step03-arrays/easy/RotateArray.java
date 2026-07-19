/*
 * Problem: Rotate array left/right by K (reversal algorithm) — Striver A2Z Step 3 (easy)
 * Migrated: 2026-07-17 | TC: O(N), SC: O(1)
 * Revisit: [date]
 */
import java.util.*;

public class RotateArray {
  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 6, 7};
    leftRotateArray(a, 2);
    System.out.println(Arrays.toString(a));
    int[] b = {1, 2, 3, 4, 5, 6, 7};
    rightRotateArray(b, 2);
    System.out.println(Arrays.toString(b));
  }

  public static void leftRotateArray(int[] nums, int k) {
    int resultK = k%nums.length;
    reverseArray(nums, 0, resultK - 1);
    reverseArray(nums, resultK, nums.length - 1);
    reverseArray(nums, 0, nums.length - 1);
  }

  public static void rightRotateArray(int[] nums, int k){
    int resultK = k%nums.length;
    reverseArray(nums, 0, nums.length - 1);
    reverseArray(nums, 0, resultK - 1);
    reverseArray(nums, resultK, nums.length - 1);
  }

  public static void reverseArray(int arr[], int start, int end) {
    if (start >= end) {
      return;
    }
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;

    reverseArray(arr, start + 1, end - 1);
  }
}
