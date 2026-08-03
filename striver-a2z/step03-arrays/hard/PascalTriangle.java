/*
 * Problem: PascalTriangle — Row-by-row Math Recurrence (nCr)
 * Solved: 03-08-2026 | TC: O(N^2) Optimal, O(N^3) Brute | SC: O(N^2)
 * Revisit: [date]
 */
import java.util.*;

public class PascalTriangle {
  public static void main(String[] args) {
    System.out.println(pascalTriangle_optimal(5));
    System.out.println(pascalTriangle_brute(5));
  }

  public static List<List<Integer>> pascalTriangle_brute(int n){
    List<List<Integer>> result = new ArrayList<>();
    for(int i = 0; i < n; i++){
      List<Integer> combination = new ArrayList<>();
      for(int j = 0; j <= i; j++){
        combination.add(findCombination(i, j));
      }
      result.add(combination);
    }
    return result;
  }

  public static int findCombination(int n, int r) {
    double result = 1;
    int min = Math.min(r, n - r);
    for (int i = 0; i < min; i++) {
      result = result * (n - i);
      result = result / (i + 1);
    }
    return (int) result;
  }

  public static List<List<Integer>> pascalTriangle_optimal(int n){
    List<List<Integer>> result = new ArrayList<>();
    for(int i = 0; i < n; i++){
      result.add(combinations(i));
    }
    return result;
  }

  public static List<Integer> combinations(int n) {
    List<Integer> combination = new ArrayList<>();
    int temp = 1;
    combination.add(temp);
    for (int i = 0; i < n; i++) {
      temp = temp * (n - i) / (i + 1);
      combination.add(temp);
    }
    return combination;
  }

}
