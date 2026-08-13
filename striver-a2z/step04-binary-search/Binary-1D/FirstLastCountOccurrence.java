/*
 * Topic: Binary Search — First & Last Occurrence · Count Occurrences (Striver A2Z Step 4)
 * Written: 2026-07-30
 * first/last are lower/upper-bound cousins · count = (first == -1) ? 0 : last - first + 1
 * Revisit: [date when re-solved from scratch]
 */
public class FirstLastCountOccurrence {
  public static void main(String[] args) {
    int[] arr = { 2, 4, 6, 8, 8, 8, 11, 13 }; // sorted, 8 appears 3 times
    // Expected:
    //   first(8) -> 3    last(8) -> 5    count(8) -> 3
    //   first(7) -> -1   last(7) -> -1   count(7) -> 0
    System.out.println("first(8): " + firstOccurrence(arr, 8));
    System.out.println("last(8):  " + lastOccurrence(arr, 8));
    System.out.println("count(8): " + countOccurrences(arr, 8));
    System.out.println("count(7): " + countOccurrences(arr, 7));
  }

  // find first index of target using binary search
  public static int firstOccurrence(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int firstIndex = -1;
    while(high >= low){
      int mid = low + (high - low)/2;
      // when match found, store index and move left
      if(arr[mid] == target){
        firstIndex = mid;
        // Look for smaller index on the left
        high = mid - 1;
      }
      // when target is smaller, move left 
      else if(arr[mid] > target){
        high = mid - 1;
      }
      // otherwise move right
      else low = mid + 1;
    }
    // return first occurence or -1
    return firstIndex;
  }

  // find last index of target using binary search
  public static int lastOccurrence(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int lastIndex = -1;
    while(high >= low){
      int mid = low + (high - low)/2;
      // when match found, store index and move right
      if(arr[mid] == target){
        lastIndex = mid;
        // Look for larger index on the right
        low = mid + 1;
      }
      // when target is smaller, move left 
      else if(arr[mid] > target){
        high = mid - 1;
      }
      // otherwise move right 
      else low = mid + 1;
    }
    // return last occurance or -1
    return lastIndex;
  }

  //find occurences of the target in sorted array using binary search
  public static int countOccurrences(int[] arr, int target) {
    int f = firstOccurrence(arr, target);
    if(f == -1) return 0;
    return lastOccurrence(arr, target) - f + 1;
  }
}
