/*
 * Problem: SingleElementInSortedArr — Optimal: Binary Search | Brute: XOR Sweep
 * Solved: 04-08-2026 | TC: O(log N) Optimal, O(N) Brute | SC: O(1)
 * Revisit: [date]
 */

public class SingleElementInSortedArr {
  public static void main(String[] args) {
    int[] arr = {3,3,7,7,10,11,11};
    System.out.println(singleElementInASortedArray_brute(arr));
    System.out.println(singleElementInASortedArray_optimal(arr));
  }

  public static int singleElementInASortedArray_brute(int[] arr){
    int x = 0;
    for(int i = 0; i < arr.length; i++){
      x ^= arr[i];
    }
    return x;
  }

  public static int singleElementInASortedArray_optimal(int[] arr){
    int low = 0;
    int high = arr.length - 1;
    while(high >= low){
      int mid = low + (high - low)/2;
      boolean x = (high - low)%4 != 0; 
      if((mid - 1 >= 0 && arr[mid - 1] == arr[mid])){
        if(x) low = mid + 1;
        else high = mid - 2;
      } else if(mid + 1 < arr.length && arr[mid + 1] == arr[mid]){
        if(x) high = mid - 1;
        else low = mid + 2;
      } else{
        return arr[mid];
      }
    }
    return -1;
  }
}
