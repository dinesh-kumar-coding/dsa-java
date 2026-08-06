/*
 * Problem: FourSum — Optimal: Sort & Two Pointers | Better: Hashing | Brute: 4 Loops
 * Solved: 06-08-2026 | TC: O(N^3) Optimal, O(N^3) Better, O(N^4) Brute | SC: O(1) Optimal, O(N) Better
 * Revisit: [date]
 */
import java.util.*;

public class FourSum {
  public static void main(String[] args) {
    int[] test1 = {1, 0, -1, 0, -2, 2};
    int target1 = 0;
    System.out.println("Test 1 Brute: " + fourSum_brute(test1, target1));
    System.out.println("Test 1 Better: " + fourSum_better(test1, target1));
    System.out.println("Test 1 Optimal: " + fourSum_optimal(test1, target1));

    int[] test2 = {2, 2, 2, 2, 2};
    int target2 = 8;
    System.out.println("Test 2 Brute: " + fourSum_brute(test2, target2));
    System.out.println("Test 2 Better: " + fourSum_better(test2, target2));
    System.out.println("Test 2 Optimal: " + fourSum_optimal(test2, target2));

    int[] test3 = {-2, -1, -1, 1, 1, 2, 2};
    int target3 = 0;
    System.out.println("Test 3 Brute: " + fourSum_brute(test3, target3));
    System.out.println("Test 3 Better: " + fourSum_better(test3, target3));
    System.out.println("Test 3 Optimal: " + fourSum_optimal(test3, target3));
  }

  public static List<List<Integer>> fourSum_brute(int[] arr, int target){
    Set<List<Integer>> set = new HashSet<>();
    int n = arr.length;
    for(int i = 0; i < n - 3; i++){
      for(int j = i + 1; j < n - 2; j++){
        for(int k = j + 1; k < n - 1; k++){
          for(int l = k + 1; l < n; l++){
            if(arr[i] + arr[j] + arr[k] + arr[l] == target){
              List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
              Collections.sort(temp);
              set.add(temp);
            }
          }
        }
      }
    }
    return new ArrayList<>(set);
  } 

  public static List<List<Integer>> fourSum_better(int[] arr, int target){
    int n = arr.length;
    Set<List<Integer>> result = new HashSet<>();
    for(int i = 0; i < n - 3; i++){
      for(int j = i + 1; j < n - 2; j++){
        Set<Integer> set = new HashSet<>();
        for(int k = j + 1; k < n; k++){
          int x = target -(arr[i] + arr[j] + arr[k]);
          if(set.contains(x)){
            List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], x);
            Collections.sort(temp);
            result.add(temp); 
          }
          set.add(arr[k]);
        }
      }
    }
    return new ArrayList<>(result);
  }

  public static List<List<Integer>> fourSum_optimal(int[] arr, int target){
    Arrays.sort(arr);
    int n = arr.length;
    List<List<Integer>> result = new ArrayList<>();
    for(int i = 0; i < n - 3; i++){
      if(i > 0 && arr[i] == arr[i - 1]) continue;
      for(int j = i + 1; j < n - 2; j++){
        if(j > i + 1 && arr[j] == arr[j - 1]) continue;
        int k = j + 1;
        int l = n - 1;
        while(l > k){
          long sum = (long)arr[i] + arr[j] + arr[k] + arr[l];
          if(sum == target){
            result.add(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
            while(l > k && arr[k] == arr[k + 1]) k++;
            k++;
            while(l > k && arr[l] == arr[l - 1]) l--;
            l--; 
          } else if(sum > target){
            while(l > k && arr[l] == arr[l - 1]) l--;
            l--;
          } else{
            while(l > k && arr[k] == arr[k + 1]) k++;
            k++;
          }
        }
      }
    }
    return result;
  }
}
