/*
 * Problem: SubArrayWithXOR_K — Optimal: Prefix XOR & HashMap
 * Solved: 14-08-2026 | TC: O(N) | SC: O(N)
 * Revisit: [date]
 */
import java.util.*;

public class SubArrayWithXOR_K {
  public static void main(String[] args) {
    int[] test1 = {4, 2, 2, 6, 4};
    int k1 = 6;
    System.out.println("Test 1: " + subArraysWithXOR_k(test1, k1));

    int[] test2 = {5, 6, 7, 8, 9};
    int k2 = 5;
    System.out.println("Test 2: " + subArraysWithXOR_k(test2, k2));

    int[] test3 = {1, 1, 1, 1};
    int k3 = 0;
    System.out.println("Test 3: " + subArraysWithXOR_k(test3, k3));

    int[] test4 = {1, 2, 3, 2};
    int k4 = 2;
    System.out.println("Test 4: " + subArraysWithXOR_k(test4, k4));
  }

  public static int subArraysWithXOR_k(int[] arr, int K){
    int XOR = 0;
    int count = 0;
    Map<Integer, Integer> hash = new HashMap<>();
    hash.put(0 , 1);
    for(int i = 0; i < arr.length; i++){
      XOR ^= arr[i];
      int x = XOR ^ K;
      if(hash.containsKey(x)){
        count += hash.get(x);
      }
      hash.put(XOR, hash.getOrDefault(XOR, 0) + 1);
    }
    return count;
  }
}