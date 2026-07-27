/*
 * Topic: Longest Consecutive Sequence — Striver A2Z Step 3 (Arrays medium)
 * Migrated: 2026-07-27 (from old-STRIVER monolith) | TC: brute O(N^2), better O(N log N), optimal O(N)
 * Revisit: [date when re-solved from scratch]
 */
import java.util.*;

public class LongestConsecutiveSequence {
  public static void main(String[] args) {
    int[] arr = { 100, 4, 200, 1, 3, 2 }; // longest run = {1,2,3,4} -> expected 4
    System.out.println("brute:   " + longestConsecutiveSequence_brute(arr.clone()));
    System.out.println("better:  " + longestConsecutiveSequence_better(arr.clone()));
    System.out.println("optimal: " + longestConsecutiveSequence_optimal(arr.clone()));
  }

  public static int longestConsecutiveSequence_brute(int[] arr) {
    int count = 0;
    int maxCount = 0;
    for (int i = 0; i < arr.length; i++) {
      int x = arr[i];
      count = 1;
      while (linearSeach(arr, x + 1) == true) {
        x = x + 1;
        count = count + 1;
      }
      maxCount = Math.max(count, maxCount);
    }
    return maxCount;
  }

  public static boolean linearSeach(int[] arr, int num) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == num) {
        return true;
      }
    }
    return false;
  }

  public static int longestConsecutiveSequence_better(int[] arr) {
    int count = 1;
    int resultCount = 1;
    Arrays.sort(arr);
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] - 1 == arr[i - 1]) {
        count++;
        resultCount = Math.max(resultCount, count);
      } else if (arr[i] != arr[i - 1]) {
        count = 1;
      }
    }
    return resultCount;
  }

  public static int longestConsecutiveSequence_optimal(int[] arr) {
    int resultCount = 0;
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      set.add(arr[i]);
    }
    for (int it : set) {
      if (set.contains(it - 1) == false) {
        int count = 1;
        int x = it + 1;
        while (set.contains(x++)) {
          count++;
        }
        resultCount = Math.max(count, resultCount);
      }
    }
    return resultCount;
  }
}
