/*
 * Problem: MajorityElement-2 — Optimal: Boyer-Moore Voting | Brute: HashMap Counting
 * Solved: 03-08-2026 | TC: O(N) Optimal, O(N) Brute | SC: O(1) Optimal, O(N) Brute
 * Revisit: [date]
 */

import java.util.*;

public class MajorityElement_2 {
  public static void main(String[] args) {
    ArrayList<Integer> test1 = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2, 2, 3, 4));
    System.out.println("Test 1 Brute: " + majorityElementII_brute(test1));
    System.out.println("Test 1 Optimal: " + majorityElementII_optimal(test1));

    ArrayList<Integer> test2 = new ArrayList<>(Arrays.asList(3, 2, 3));
    System.out.println("Test 2 Brute: " + majorityElementII_brute(test2));
    System.out.println("Test 2 Optimal: " + majorityElementII_optimal(test2));

    ArrayList<Integer> test3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    System.out.println("Test 3 Brute: " + majorityElementII_brute(test3));
    System.out.println("Test 3 Optimal: " + majorityElementII_optimal(test3));
  }

  public static ArrayList<Integer> majorityElementII_brute(ArrayList<Integer> arr){
    ArrayList<Integer> result = new ArrayList<>();
    Map<Integer, Integer> hash = new HashMap<>();
    int n = arr.size();
    for(int i = 0; i < n; i++){
      hash.put(arr.get(i), hash.getOrDefault(arr.get(i), 0) + 1);
      if(hash.get(arr.get(i)) == Math.floor(n/3) + 1){
        result.add(arr.get(i));
        if(result.size() == 2) break;
      }
    }
    return result;
  }

  public static ArrayList<Integer> majorityElementII_optimal(ArrayList<Integer> arr){
    int n = arr.size();
    ArrayList<Integer> result = new ArrayList<>();
    int candidate1 = -1;
    int candidate2 = -1;
    int count1 = 0;
    int count2 = 0;
    for(int i = 0; i < n; i++){
      if(arr.get(i) == candidate1){
        count1++;
      } else if(arr.get(i) == candidate2){
        count2++;
      } else if(count1 == 0){
        candidate1 = arr.get(i);
        count1 = 1;
      } else if(count2 == 0){
        candidate2 = arr.get(i);
        count2 = 1;
      } else{
        count1--;
        count2--;
      }
    }
    int originalCount1 = 0, originalCount2 = 0;
    for(int i = 0; i < n; i++){
      if(arr.get(i) == candidate1) originalCount1++;
      else if(arr.get(i) == candidate2) originalCount2++;
    }
    if(originalCount1 > n/3) result.add(candidate1);
    if(originalCount2 > n/3) result.add(candidate2);
    return result;
  }
}