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

  // First index of target, or -1 if not present.
  public static int firstOccurrence(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int firstIndex = -1;
    while(high >= low){
      int mid = low + (high - low)/2;
      if(arr[mid] == target){
        firstIndex = mid;
        high = mid - 1;
      } else if(arr[mid] > target){
        high = mid - 1;
      } else low = mid + 1;
    }
    return firstIndex;
  }

  // Last index of target, or -1 if not present.
  public static int lastOccurrence(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int lastIndex = -1;
    while(high >= low){
      int mid = low + (high - low)/2;
      if(arr[mid] == target){
        lastIndex = mid;
        low = mid + 1;
      } else if(arr[mid] > target){
        high = mid - 1;
      } else low = mid + 1;
    }
    return lastIndex;
  }

  // How many times target appears. (Hint: build it from first & last.)
  public static int countOccurrences(int[] arr, int target) {
    int f = firstOccurrence(arr, target);
    if(f == -1) return 0;
    return lastOccurrence(arr, target) - f + 1;
  }
}
