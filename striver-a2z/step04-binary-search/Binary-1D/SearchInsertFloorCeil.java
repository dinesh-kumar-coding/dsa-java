/*
 * Topic: Binary Search — Search Insert Position · Floor · Ceil (Striver A2Z Step 4)
 * Written: 2026-07-30
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

  // Function to find the insert position of target in sorted array
  public static int searchInsertPosition(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int resultIndex = arr.length; // Default to end if target is greater than all elements 
    while(high >= low){
      int mid = low + (high - low)/2;
      if(arr[mid] >= target){
        resultIndex = mid; // Potential answer found, try to go left
        high = mid - 1;
      } else{
        low = mid + 1; // Go right
      }
    }
    return resultIndex;
  }

  // Function to find floor
  public static int floor(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int resultIndex = -1;
    while(high >= low){
      int mid = low + (high - low)/2;
      if(arr[mid] <= target){
        resultIndex = arr[mid];  // Potential floor
        low = mid + 1;
      } else{
        high = mid - 1;
      }
    }
    return resultIndex;
  }

  // Function to find ceiling
  public static int ceil(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int resultIndex = -1;
    while(high >= low){
      int mid = low + (high - low)/2;
      if(arr[mid] >= target){
        resultIndex = arr[mid];  // Potential ceil
        high = mid - 1;
      } else{
        low = mid + 1;
      }
    }
    return resultIndex;
  }
}
