/*
 * Topic: Binary Search — Search Insert Position · Floor · Ceil (Striver A2Z Step 4)
 * Written: 2026-07-30
 * All three are lower/upper-bound cousins — build them on the bounds you just wrote.
 * Revisit: [date when re-solved from scratch]
 */
public class SearchInsertFloorCeil {
  public static void main(String[] args) {
    int[] arr = { 2, 4, 6, 8, 10, 12 }; // sorted
    // Expected:
    //   searchInsert(7) -> 3    floor(7) -> 6     ceil(7) -> 8
    //   searchInsert(8) -> 3    floor(8) -> 8     ceil(8) -> 8
    //   floor(1) -> -1          ceil(20) -> -1
    System.out.println("searchInsert(7): " + searchInsertPosition(arr, 7));
    System.out.println("searchInsert(8): " + searchInsertPosition(arr, 8));
    System.out.println("floor(7):        " + floor(arr, 7));
    System.out.println("ceil(7):         " + ceil(arr, 7));
    System.out.println("floor(1):        " + floor(arr, 1));
    System.out.println("ceil(20):        " + ceil(arr, 20));
  }

  // Index where target is, or where it would be inserted to keep sorted order.
  // (Hint: this is exactly lower bound — first i with arr[i] >= target.)
  public static int searchInsertPosition(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int resultIndex = arr.length;
    while(high >= low){
      int mid = low + (high - low)/2;
      if(arr[mid] >= target){
        resultIndex = mid;
        high = mid - 1;
      } else{
        low = mid + 1;
      }
    }
    return resultIndex;
  }

  // Largest VALUE in arr that is <= target, or -1 if none exists.
  public static int floor(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int resultIndex = -1;
    while(high >= low){
      int mid = low + (high - low)/2;
      if(arr[mid] <= target){
        resultIndex = arr[mid];
        low = mid + 1;
      } else{
        high = mid - 1;
      }
    }
    return resultIndex;
  }

  // Smallest VALUE in arr that is >= target, or -1 if none exists.
  public static int ceil(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int resultIndex = -1;
    while(high >= low){
      int mid = low + (high - low)/2;
      if(arr[mid] >= target){
        resultIndex = arr[mid];
        high = mid - 1;
      } else{
        low = mid + 1;
      }
    }
    return resultIndex;
  }
}
