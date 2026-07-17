/*
 * Problem: Second largest / second smallest — Striver A2Z Step 3 (easy)
 * Migrated: 2026-07-17 | TC: O(N) single pass
 * Revisit: [date]
 */
public class SecondLargestSmallest {
  public static void main(String[] args) {
    int[] arr = {1, 2, 4, 7, 7, 5};
    System.out.println("2nd largest: " + getSecondLargestElement(arr));
    System.out.println("2nd smallest: " + getSecondSmallestElement(arr));
  }

  public static int getSecondLargestElement(int arr[]){
    if(arr == null || arr.length <= 1) return -1;
    int largest = arr[0];
    int secondLargest = Integer.MIN_VALUE;
    for(int i = 1; i < arr.length; i++){
      if(largest < arr[i]){
        secondLargest = largest;
        largest = arr[i];
      } else if(arr[i] != largest && arr[i] > secondLargest){
        secondLargest = arr[i];
      }
    }
    if(secondLargest == Integer.MIN_VALUE) return -1;
    return secondLargest;
  }

  public static int getSecondSmallestElement(int[] arr){
    int smallest = arr[0];
    int secondSmallest = Integer.MAX_VALUE;
    for(int i = 1; i < arr.length; i++){
      if(smallest > arr[i]){
        secondSmallest = smallest;
        smallest = arr[i];
      } else if(arr[i] != smallest && arr[i] < secondSmallest){
        secondSmallest = arr[i];
      }
    }
    if(secondSmallest == Integer.MAX_VALUE) return -1;
    return secondSmallest;
  }
}
