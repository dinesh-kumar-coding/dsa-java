/*
 * Problem: Rearrange array elements by sign (alternating +/-) — Striver A2Z Step 3 (medium) / LeetCode 2149
 * Solved: 2026-07-18 | Brute: O(N) two lists + refill | Optimal: O(N) single pass, indexed placement
 * Revisit: [date]
 */
import java.util.*;

public class RearrangeBySign {
  public static void main(String[] args) {
    int[] a = {3, 1, -2, -5, 2, -4};
    rearrangeArrayElementsBySign_OPTIMAL(a);
    System.out.println(Arrays.toString(a));
    int[] b = {3, 1, -2, -5, 2, -4};
    rearrangeArrayElementsBySign_BRUTE(b);
    System.out.println(Arrays.toString(b));
  }

  public static void rearrangeArrayElementsBySign_BRUTE(int[] arr) {
    ArrayList<Integer> positives = new ArrayList<>(), negatives = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > 0) {
        positives.add(arr[i]);
      } else {
        negatives.add(arr[i]);
      }
    }
    int minCount = Math.min(positives.size(), negatives.size());
    for (int i = 0; i < minCount; i++) {
      arr[2 * i] = negatives.get(i);
      arr[2 * i + 1] = positives.get(i);
    }

    int index = 2 * minCount;
    for (int i = minCount; i < positives.size(); i++) {
      arr[index++] = positives.get(i);
    }
    for (int i = minCount; i < negatives.size(); i++) {
      arr[index++] = negatives.get(i);
    }
  }

  public static void rearrangeArrayElementsBySign_OPTIMAL(int[] arr) {
    int[] resultArray = new int[arr.length];
    int positiveIndex = 0;
    int negativeIndex = 1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > 0) {
        resultArray[positiveIndex] = arr[i];
        positiveIndex += 2;
      } else {
        resultArray[negativeIndex] = arr[i];
        negativeIndex += 2;
      }
    }
    for (int i = 0; i < arr.length; i++) {
      arr[i] = resultArray[i];
    }
  }
}
