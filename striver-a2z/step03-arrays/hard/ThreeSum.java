/*
 * Problem: ThreeSum — Optimal: Sort & Two Pointers | Better: Hashing | Brute: 3 Loops
 * Solved: 06-08-2026 | TC: O(N^2) Optimal, O(N^2) Better, O(N^3) Brute | SC: O(1) Optimal, O(N) Better
 * Revisit: [date]
 */
import java.util.*;

public class ThreeSum {
  public static void main(String[] args) {
    int[] test1 = { -1, 0, 1, 2, -1, -4 };
    System.out.println("Test 1 Brute: " + threeSum_brute(test1));
    System.out.println("Test 1 Better: " + threeSum_better(test1));
    System.out.println("Test 1 Optimal: " + threeSum_optimal(test1));

    int[] test2 = { 0, 0, 0, 0 };
    System.out.println("Test 2 Brute: " + threeSum_brute(test2));
    System.out.println("Test 2 Better: " + threeSum_better(test2));
    System.out.println("Test 2 Optimal: " + threeSum_optimal(test2));

    int[] test3 = { 1, 2, -2, -1 };
    System.out.println("Test 3 Brute: " + threeSum_brute(test3));
    System.out.println("Test 3 Better: " + threeSum_better(test3));
    System.out.println("Test 3 Optimal: " + threeSum_optimal(test3));

    System.out.println(threeSum_brute(null));
  }

  public static List<List<Integer>> threeSum_brute(int[] arr) {
    Set<List<Integer>> set = new HashSet<>();
    for (int i = 0; i < arr.length - 2; i++) {
      for (int j = i + 1; j < arr.length - 1; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          if (arr[i] + arr[j] + arr[k] == 0) {
            List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
            Collections.sort(temp);
            set.add(temp);
          }
        }
      }
    }
    return new ArrayList<>(set);
  }

  public static List<List<Integer>> threeSum_better(int[] arr) {
    Set<List<Integer>> result = new HashSet<>();
    for (int i = 0; i < arr.length - 1; i++) {
      Set<Integer> set = new HashSet<>();
      for (int j = i + 1; j < arr.length; j++) {
        if (set.contains(-(arr[i] + arr[j]))) {
          List<Integer> temp = Arrays.asList(arr[i], arr[j], -(arr[i] + arr[j]));
          Collections.sort(temp);
          result.add(temp);
        }
        set.add(arr[j]);
      }
    }
    return new ArrayList<>(result);
  }

  public static List<List<Integer>> threeSum_optimal(int[] arr) {
    List<List<Integer>> result = new ArrayList<>();
    int n = arr.length;
    Arrays.sort(arr);
    for (int i = 0; i < n - 2; i++) {
      if (arr[i] > 0)
        break;
      if (i > 0 && arr[i] == arr[i - 1])
        continue;
      int j = i + 1;
      int k = n - 1;
      while (j < k) {
        int sum = arr[i] + arr[j] + arr[k];
        if (sum == 0) {
          result.add(Arrays.asList(arr[i], arr[j], arr[k]));
          while (j < k && arr[k] == arr[k - 1])
            k--;
          k--;
          while (j < k && arr[j] == arr[j + 1])
            j++;
          j++;
        } else if (sum > 0) {
          while (j < k && arr[k] == arr[k - 1])
            k--;
          k--;
        } else {
          while (j < k && arr[j] == arr[j + 1])
            j++;
          j++;
        }
      }
    }
    return result;
  }
}
