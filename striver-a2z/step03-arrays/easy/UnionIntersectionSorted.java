/*
 * Problem: Union and intersection of two sorted arrays — Striver A2Z Step 3 (easy)
 * Migrated: 2026-07-17 | TC: O(N1+N2)
 * WARNING: known bug in union (j <= n2 out-of-bounds risk + flawed else) — fix session pending
 * Revisit: [date]
 */
import java.util.*;

public class UnionIntersectionSorted {
  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5};
    int[] b = {2, 3, 6};
    System.out.println("union: " + unionOfTwoSortedArrays(a, b));
    System.out.println("intersection: " + intersectionofTwoSortedArrays(a, b));
  }

  public static List<Integer> unionOfTwoSortedArrays(int[] a, int[] b){
    List<Integer> temp = new ArrayList<>();
    int i = 0, j = 0;
    int n1 = a.length, n2 = b.length;
    while(i <= n1 - 1 && j <= n2 - 1){
      if(a[i] <= b[j]){
        if(temp.isEmpty() || temp.get(temp.size() - 1) != a[i]) temp.add(a[i]);
        i++;
      }
      else{
        if(b[j] < a[i]){
          if(temp.isEmpty() || temp.get(temp.size() - 1) != b[j]) temp.add(b[j]);
          j++;
        }
      }

    }
    while(i <= n1 - 1){
      if(temp.isEmpty() || temp.get(temp.size() - 1) != a[i]) temp.add(a[i]);
      i++;
    }
    while(j <= n2 - 1){
      if(temp.isEmpty() || temp.get(temp.size() - 1) != b[j]) temp.add(b[j]);
      j++;
    }
    return temp;
  }

  public static List<Integer> intersectionofTwoSortedArrays(int[] a, int[] b){
    List<Integer> temp = new ArrayList<>();
    int i = 0, j = 0;
    int n1 = a.length, n2 = b.length;
    while(i < n1 && j < n2){
      if(a[i] == b[j]){
        temp.add(a[i]);
        i++;
        j++;
      }
      else{
        if(b[j] > a[i]){
          i++;
        }
        else{
          j++;
        }
      }
    }
    return temp;
  }
}
