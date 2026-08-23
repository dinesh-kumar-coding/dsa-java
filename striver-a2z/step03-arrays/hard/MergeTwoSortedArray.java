/*
 * Problem: MergeTwoSortedArray — Optimal 1 (Two Pointers + Sort) | Optimal 2 (Shell Sort) | LeetCode 88
 * Solved: 23-08-2026 | TC: O(min(N,M) + NlogN + MlogM) Opt1, O((N+M) * log(N+M)) Opt2, O(M+N) LeetCode | SC: O(1)
 * Revisit: [date]
 */

import java.util.*;

public class MergeTwoSortedArray {
  public static void main(String[] args) {
    System.out.println("--- Optimal 1 (Two Pointers + Sort) ---");
    long[] arr1_opt1 = {1, 3, 5, 7};
    long[] arr2_opt1 = {0, 2, 6, 8, 9};
    merge_optimal1(arr1_opt1, arr2_opt1, arr1_opt1.length, arr2_opt1.length);
    System.out.println("Arr1: " + Arrays.toString(arr1_opt1)); // Expected: [0, 1, 2, 3]
    System.out.println("Arr2: " + Arrays.toString(arr2_opt1)); // Expected: [5, 6, 7, 8, 9]

    System.out.println("\n--- Optimal 2 (Gap Method / Shell Sort) ---");
    long[] arr1_opt2 = {1, 4, 8, 10};
    long[] arr2_opt2 = {2, 3, 9};
    merge_optimal2(arr1_opt2, arr2_opt2, arr1_opt2.length, arr2_opt2.length);
    System.out.println("Arr1: " + Arrays.toString(arr1_opt2)); // Expected: [1, 2, 3, 4]
    System.out.println("Arr2: " + Arrays.toString(arr2_opt2)); // Expected: [8, 9, 10]

    System.out.println("\n--- LeetCode 88 (Merge into first array) ---");
    int[] num1 = {1, 2, 3, 0, 0, 0}; 
    int m = 3;
    int[] num2 = {2, 5, 6};
    int n = 3;
    merge_leetcode(num1, m, num2, n);
    System.out.println("Arr1 (Merged): " + Arrays.toString(num1)); // Expected: [1, 2, 2, 3, 5, 6]
  }

  public static void merge_optimal1(long[] arr1, long[] arr2, int n, int m){
    int left = n - 1;
    int right = 0;
    while(left >= 0 && right < m){
      if(arr1[left] > arr2[right]){
        long temp = arr1[left];
        arr1[left] = arr2[right];
        arr2[right] = temp;
        left--;
        right++;
      } else{
        break;
      }
    }
    Arrays.sort(arr1);
    Arrays.sort(arr2);
  }

  public static void merge_leetcode(int[] num1, int m, int[] num2, int n){
    int left = m - 1;
    int right = n - 1;
    int index = m + n - 1;
    while(left >= 0 && right >= 0){
      if(num1[left] > num2[right]){
        num1[index--] = num1[left--];
      } else{
        num1[index--] = num2[right--];
      }
    }

    while(right >= 0){
      num1[index--] = num2[right--];
    }
  }

  // shell sort (Gap Method)
  public static void merge_optimal2(long[] arr1, long[] arr2, int n, int m){
    int len = (n + m);
    int gap = (len / 2) + (len % 2);
    while(gap > 0){
      int left = 0;
      int right = left + gap;
      
      while(right < len){
        if(left < n && right >= n){
          swapIfGreater(arr1, arr2, left, right - n);
        } else if(left >= n){
          swapIfGreater(arr2, arr2, left - n, right - n);
        } else{
          swapIfGreater(arr1, arr1, left, right);
        }
        left++;
        right++;
      }
      if(gap == 1) break;
      gap = (gap / 2) + (gap % 2);
    }
  }

  public static void swapIfGreater(long[] arr1, long[] arr2, int idx1, int idx2){
    if(arr1[idx1] > arr2[idx2]){
      long temp = arr1[idx1];
      arr1[idx1] = arr2[idx2];
      arr2[idx2] = temp;
    } 
  }
}