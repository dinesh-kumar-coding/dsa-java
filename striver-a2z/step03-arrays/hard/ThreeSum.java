/*
 * Problem: ThreeSum — Optimal: Sort & Two Pointers | Better: Hashing | Brute: 3 Loops
 * Solved: 06-08-2026 | TC: O(N^2) Optimal, O(N^2) Better, O(N^3) Brute | SC: O(1) Optimal, O(N) Better
 * Revisit: [date]
 */
import java.util.*;

public class ThreeSum {
  public static void main(String[] args) {

    // Original ThreeSum Tests (target = 0)
    int[] test1 = { -1, 0, 1, 2, -1, -4 };
    System.out.println("Test 1 Brute: " + threeSum_brute(test1));
    System.out.println("Test 1 Better: " + threeSum_better(test1));
    System.out.println("Test 1 Optimal: " + threeSum_optimal(test1));
    System.out.println();

    int[] test2 = { 0, 0, 0, 0 };
    System.out.println("Test 2 Brute: " + threeSum_brute(test2));
    System.out.println("Test 2 Better: " + threeSum_better(test2));
    System.out.println("Test 2 Optimal: " + threeSum_optimal(test2));
    System.out.println();

    int[] test3 = { 1, 2, -2, -1 };
    System.out.println("Test 3 Brute: " + threeSum_brute(test3));
    System.out.println("Test 3 Better: " + threeSum_better(test3));
    System.out.println("Test 3 Optimal: " + threeSum_optimal(test3));
    System.out.println();

    // ===============================
    // Generalized ThreeSum With Target
    // ===============================

    // 1. Positive target
    int[] targetTest1 = { -10, 5, 6 };
    System.out.println("Target Test 1 (target = 1): "
            + threeSum_optimal_withTarget(targetTest1, 1));

    // 2. Negative target 
    int[] targetTest2 = { -100, -5, -4, -1 };
    System.out.println("Target Test 2 (target = -10): "
            + threeSum_optimal_withTarget(targetTest2, -10));

    // 3. Multiple valid triplets
    int[] targetTest3 = { -2, -1, 0, 1, 2, 3, 4 };
    System.out.println("Target Test 3 (target = 3): "
            + threeSum_optimal_withTarget(targetTest3, 3));

    // 4. Duplicates
    int[] targetTest4 = { 1, 1, 1, 2, 2, 3, 4 };
    System.out.println("Target Test 4 (target = 6): "
            + threeSum_optimal_withTarget(targetTest4, 6));

    // 5. No solution
    int[] targetTest5 = { 1, 2, 3, 4 };
    System.out.println("Target Test 5 (target = 100): "
            + threeSum_optimal_withTarget(targetTest5, 100));

    // 6. Same as classic ThreeSum
    int[] targetTest6 = { -1, 0, 1, 2, -1, -4 };
    System.out.println("Target Test 6 (target = 0): "
            + threeSum_optimal_withTarget(targetTest6, 0));

    // 7. All zeros
    int[] targetTest7 = { 0, 0, 0, 0 };
    System.out.println("Target Test 7 (target = 0): "
            + threeSum_optimal_withTarget(targetTest7, 0));

    // 8. All negative numbers
    int[] targetTest8 = { -8, -7, -6, -5, -4 };
    System.out.println("Target Test 8 (target = -18): "
            + threeSum_optimal_withTarget(targetTest8, -18));

    // 9. Mixed positive & negative
    int[] targetTest9 = { -5, -2, -1, 0, 3, 4, 7 };
    System.out.println("Target Test 9 (target = 2): "
            + threeSum_optimal_withTarget(targetTest9, 2));

    // 10. Minimum valid array
    int[] targetTest10 = { 1, 2, 3 };
    System.out.println("Target Test 10 (target = 6): "
            + threeSum_optimal_withTarget(targetTest10, 6));

    System.out.println(threeSum_optimal_withTarget(null, 0));
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

  public static List<List<Integer>> threeSum_optimal_withTarget(int[] arr, int target) {
    List<List<Integer>> result = new ArrayList<>();
    if(arr == null) return result;
    int n = arr.length;
    Arrays.sort(arr);
    for (int i = 0; i < n - 2; i++) {
      if (i > 0 && arr[i] == arr[i - 1]) continue;
      int j = i + 1;
      int k = n - 1;
      while (j < k) {
        int sum = arr[i] + arr[j] + arr[k];
        if (sum == target) {
          result.add(Arrays.asList(arr[i], arr[j], arr[k]));
          while (j < k && arr[k] == arr[k - 1])
            k--;
          k--;
          while (j < k && arr[j] == arr[j + 1])
            j++;
          j++;
        } else if (sum > target) {
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
