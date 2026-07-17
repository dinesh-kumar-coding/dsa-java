package STRIVER;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++)
      arr[i] = scanner.nextInt();

    System.out.println(majorityElement(arr));

    // for(int i : arr) System.out.print(i + " ");

    scanner.close();

  }

  // ***************************************
  // BASIC MATHS
  // ***************************************
  public static long reversedNumber(long n) {
    long reversedN = 0;
    while (n != 0) {
      if (reversedN > Long.MAX_VALUE / 10 || reversedN < Long.MIN_VALUE / 10) {
        return 0;
      }
      reversedN = reversedN * 10 + n % 10;
      n /= 10;
    }
    return reversedN;
  }

  public static boolean checkPalidrome(int n) {
    if (n < 0) {
      return false;
    }
    int originalN = n;
    int reversedN = 0;
    while (n != 0) {
      if (reversedN > Integer.MAX_VALUE / 10 || reversedN < Integer.MIN_VALUE / 10) {
        return false;
      }
      reversedN = reversedN * 10 + n % 10;
      n /= 10;
    }
    return reversedN == originalN;
  }

  public static boolean isArmstrong(int n) {
    int len = Integer.toString(n).length();
    int originalN = n;
    long sum = 0;
    while (n != 0) {
      if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
        return false;
      }
      sum += Math.pow(n % 10, len);
      n /= 10;
    }
    return sum == originalN;
  }

  public static List<Integer> printDivisors(int n) {
    List<Integer> divisors = new ArrayList<>();
    for (int i = 1; i * i <= n; i++) {
      if (n % i == 0) {
        divisors.add(i);
        if (n / i != i) {
          divisors.add(n / i);
        }
      }
    }
    Collections.sort(divisors);
    return divisors;
  }

  public static boolean isPrime(int n) {
    if (n <= 1) {
      return false;
    }
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static int GCD(int n1, int n2) {
    // for(int i = Math.min(n1, n2); i >= 1; i--){
    // if(n1%i == 0 && n2%i == 0){
    // return i;
    // }
    // }
    // return -1;

    // Euclidean Algorithm
    while (n1 > 0 && n2 > 0) {
      if (n1 > n2) {
        n1 %= n2;
      } else {
        n2 %= n1;
      }
    }
    return Math.max(n1, n2);
  }
  // ============================================================================================================================================================
  // ============================================================================================================================================================

  // ***************************************
  // RECURSION
  // ***************************************
  public static int recursion_1_to_N(int i, int n) {
    if (i > n) {
      return 0;
    }
    System.out.print(i + " ");
    return recursion_1_to_N(i + 1, n);
  }

  public static int recursion_N_to_1(int i, int n) {
    if (i > n) {
      return 0;
    }
    System.out.print(n + " ");
    return recursion_N_to_1(i, n - 1);
  }

  public static void recursion_1_to_N_backtracking(int i, int n) {
    if (n < i) {
      return;
    }
    recursion_1_to_N_backtracking(i, n - 1);
    System.out.print(n + " ");
  }

  public static void recursion_N_to_1_backtracking(int i, int n) {
    if (i > n) {
      return;
    }
    recursion_N_to_1_backtracking(i + 1, n);
    System.out.print(i + " ");
  }

  public static int recursion_sumOfFirstN(int n) {
    if (n <= 0) {
      return 0;
    }
    return n + recursion_sumOfFirstN(n - 1);
  }

  public static int recursion_factorial(int n) {
    if (n <= 1) {
      return 1;
    }
    return n * recursion_factorial(n - 1);
  }

  public static void reverseArray(int arr[], int start, int end) {
    if (start >= end) {
      return;
    }
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;

    reverseArray(arr, start + 1, end - 1);
  }

  public static boolean isPalindrome(String s) {
    String result = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    int lengthOfPhrase = result.length();
    for (int i = 0; i < lengthOfPhrase / 2; i++) {
      if (result.charAt(i) != result.charAt(lengthOfPhrase - i - 1)) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPalidrome_recursive(int i, String s) {
    if (i >= s.length() / 2)
      return true;
    if (s.charAt(i) != s.charAt(s.length() - 1 - i))
      return false;
    return isPalidrome_recursive(i + 1, s);
  }
  // ============================================================================================================================================================
  // ============================================================================================================================================================

  // ***************************************
  // HASHING
  // ***************************************
  public static void array_hashing() {
    Scanner scanner = new Scanner(System.in);

    int n;
    n = scanner.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scanner.nextInt();

    // precompute:
    int[] hash = new int[13];
    for (int i = 0; i < n; i++) {
      hash[arr[i]] += 1;
    }

    int q;
    q = scanner.nextInt();
    while (q-- != 0) {
      int number = scanner.nextInt();
      // fetching:
      System.out.println(hash[number]);
    }
    scanner.close();
  }

  public static void array_character_hashing() {
    Scanner scanner = new Scanner(System.in);

    String s = scanner.next();

    // precompute:
    int[] hash = new int[256];
    for (int i = 0; i < s.length(); i++) {
      hash[s.charAt(i)] += 1;
    }

    int q = scanner.nextInt();
    while (q-- > 0) {
      char c;
      c = scanner.next().charAt(0);
      // fetching:
      System.out.println(hash[c]);
    }
    scanner.close();
  }

  public static void hashing_using_map() {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }

    // precompute:
    HashMap<Integer, Integer> mp = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int key = arr[i];
      int freq = 0;
      if (mp.containsKey(key))
        freq = mp.get(key); // fetching from the map
      freq++;
      mp.put(key, freq); // inserting into the map(overwrites)
    }

    // Interate over the map:
    for (var it : mp.entrySet()) {
      System.out.println(it.getKey() + "->" + it.getValue());
    }

    int q = scanner.nextInt();
    while (q-- > 0) {
      int number = scanner.nextInt();
      // fetch:
      if (mp.containsKey(number))
        System.out.println(mp.get(number));
      else
        System.out.println(0);
    }

    scanner.close();
  }

  public static void Frequency(int[] arr, int n) {
    // Creating a HashMap to store frequency of each element
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      // int freq = 0;
      // int key = arr[i];
      // if(map.containsKey(key)) freq = map.get(key);
      // freq++;
      // map.put(key, freq);
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      System.out.println(entry.getKey() + "->" + entry.getValue());
    }
  }

  public static void highest_occuring_element_in_array(int[] arr, int n) {
    HashMap<Integer, Integer> map = new HashMap<>();

    // Count frequencies
    for (int i = 0; i < n; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }

    int maxFreq = 0;
    int maxKey = -1;

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() > maxFreq) {
        maxKey = entry.getKey();
        maxFreq = entry.getValue();
      }
    }
    System.out.println("Highest Occuring Element: " + maxKey + ". With " + maxFreq + " of frequency.");
  }
  // ============================================================================================================================================================
  // ============================================================================================================================================================

  // ***************************************
  // SORTING
  // ***************************************
  public static void selectionSort(int[] arr) {
    int temp = 0;
    for (int i = 0; i < arr.length - 1; i++) {
      int min = i;
      for (int j = i; j < arr.length; j++) {
        if (arr[min] > arr[j])
          min = j;
      }
      temp = arr[i];
      arr[i] = arr[min];
      arr[min] = temp;
    }

    // Time Complexity: O(N^2);
  }

  public static void bubbleSort(int[] arr) {
    int temp = 0;
    int count = 0;
    for (int i = arr.length - 1; i > 0; i--) {
      count = 0;
      for (int j = 0; j < i; j++) {
        if (arr[j] > arr[j + 1]) {
          temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          count++;
        }
        System.out.println("runs");
      }
      if (count == 0) break;
    }

    // Time Complexity: O(N^2) --> Worst and Average, O(N) --> Best
  }

  public static void recursive_bubbleSort(int[] arr, int n){
    if(n == 1) return;
    int temp = 0;
    boolean flag = false;
    for(int i = 0; i < n - 1; i++){
      if(arr[i] > arr[i + 1]){
        temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp;
        flag = true;
      }
    }
    if(flag){
      return;
    }
    recursive_bubbleSort(arr, n - 1);
  }

  public static void inserstionSort(int[] arr){
    for(int i = 1; i < arr.length; i++){
      int j = i - 1;
      int key = arr[i];
      while(j >= 0 && arr[j] > key){
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }

    // Time Complexity: O(N^2) --> Worst and Average, O(N) --> Best
  }

  public static void recursive_inserstionSort(int[] arr, int i, int n){
    // Base case:
    if(i == n) return;

    int j = i;
    // Move the current element back until it's in the corret place
    while(j > 0 && arr[j - 1] > arr[j]){
      // Swap arr[j] and arr[j - 1]
      int temp = arr[j - 1];
      arr[j - 1] = arr[j];
      arr[j] = temp;
      j--;
    }

    // Recur for the next index
    recursive_inserstionSort(arr, i + 1, n);
  }

  public static void mergeSort(int arr[]){
    mS(arr, 0, arr.length - 1);

    // Time Complexity: O(Nlog(N));
  }

  // Recursive merge sort
  public static void mS(int[] arr, int low, int high){

    // Base condition
    if(low >= high) return;

    // Find mid index
    int middle = (low + high)/ 2;
    
    // Sort left array 
    mS(arr, low, middle);

    // Sort right array
    mS(arr, middle + 1, high);

    // Merge both halves
    merge(arr, low, middle, high);
  }

  // Function to merge two halves
  public static void merge(int[] arr, int low, int middle, int high) {
    // Create temp array
    List<Integer> temp = new ArrayList<>();
    int left = low, right = middle + 1;

    // Merge both sorted parts
    while(left <= middle && right <= high){
      if(arr[left] <= arr[right]){
        temp.add(arr[left++]);
      } else{
        temp.add(arr[right++]);
      }
    }
    // Add remaining left elements
    while(left <= middle){
      temp.add(arr[left++]);
    }
    // Add remaining right elements
    while(right <= high){
      temp.add(arr[right++]);
    }

    // Copy back to original array
    for(int i = low; i <= high; i++){
      arr[i] = temp.get(i - low);
    }
    
  }

  class QuickSort{
    public static void quickSort(int[] arr){
      if(arr == null || arr.length <= 1) return;
      quickSortHelper(arr, 0, arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int low, int high){
      if(low < high){
        // Partition the array and get the final pivot index
        int pivotIndex = partition(arr, low, high);

        // Recursively sort elements before and after partition
        quickSortHelper(arr, low, pivotIndex - 1);
        quickSortHelper(arr, pivotIndex + 1, high);
      }
    }

    private static int partition(int[] arr, int low, int high){
      int pivot = arr[low];
      int i = low;
      int j = high;

      while(i < j){
        // Move i to the right as long as elements are <= pivot
        while(i <= high && arr[i] <= pivot){
          i++;
        }
        // Move j to the left as long as elements are > pivot
        while(arr[j] < pivot){
          j--;
        }
        // Swap elements if pointers haven't crossed
        if(i < j){
          swap(arr, i, j);
        }
      }

      // Place the pivot in its final sorted position
      swap(arr, low, j);
      return j;
    }

    private static void swap(int[] arr, int i, int j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }

    // Time Complexity: O(Nlog(N))
  }
  // ============================================================================================================================================================
  // ============================================================================================================================================================

  // ***************************************
  // ARRAYS -> (EASY)
  // ***************************************
  public static int getLargestElement(int[] arr){
    if(arr.length == 0) return -1;
    int largest = arr[0];
    for(int i = 1; i < arr.length; i++){
      if(largest < arr[i]) largest = arr[i];
    }
    return largest;
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

  public static int getNumberOfNonDubplicatesFromSortedArray(int[] arr){
    if(arr.length == 0) return 0;
    int i = 0;
    for(int j = 1; j < arr.length; j++){
      if(arr[i] != arr[j]){
        arr[++i] = arr[j];
      }
    }
    return i + 1;
  }

  public static boolean checkArrayIsSorted(int[] arr){
    for(int i = 1; i < arr.length; i++){
      if(arr[i] < arr[i - 1]){
        return false;
      }
    }
    return true;
  }

  public static void rotateArrayLeftByOne(int[] arr){
    
  }

  public static void leftRotateArray(int[] nums, int k) {
    int resultK = k%nums.length;
    reverseArray(nums, 0, resultK - 1);
    reverseArray(nums, resultK, nums.length - 1);
    reverseArray(nums, 0, nums.length - 1);
  }

  public static void rightRotateArray(int[] nums, int k){
    int resultK = k%nums.length;
    reverseArray(nums, 0, nums.length - 1);
    reverseArray(nums, 0, resultK - 1);
    reverseArray(nums, resultK, nums.length - 1);
  }

  public static void moveZeros_bruteforce(int []arr) {
    // Write your code here.
    List<Integer> temp = new ArrayList<>();
    for(int i = 0; i < arr.length; i++){
        if(arr[i] != 0) temp.add(arr[i]);
    }
    for(int i = 0; i < temp.size(); i++){
        arr[i] = temp.get(i);
    }
    for(int i = temp.size(); i < arr.length; i++){
        arr[i] = 0;
    }
  }

  public static void moveZeros_optimal(int arr[]){
    for(int i = 0,j = 0; i < arr.length; i++){
      if(arr[i] != 0){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
        j++;
      }
    }
  }

  public static List<Integer> unionOfTwoSortedArrays(int[] a, int[] b){
    List<Integer> temp = new ArrayList<>();
    int i = 0, j = 0;
    int n1 = a.length, n2 = b.length;
    while(i <= n1 - 1 && j <= n2){
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

  public static int missingNumber(int[] arr, int n){
    int XOR1 = 0, XOR2 = 0;
    for(int i = 0; i < n - 1; i++){
      XOR1 ^= i + 1;
      XOR2 ^= arr[i];
    }
    return (XOR1^n)^XOR2;
  }

  public static int findNumberThatAppearsOnceAndOtherNumberTwice(int[] arr){
    int XOR = 0;
    for(int i = 0; i < arr.length; i++){
      XOR ^= arr[i];
    }
    return XOR;
  }

  public static int longestSubArrayWithSumK(int[] arr, int k){
    int length = 0;
    int sum = 0;
    for(int i = 0; i < arr.length; i++){
      sum = 0;
      for(int j = i; j < arr.length; j++){
        sum += arr[j];
        if(sum == k){
          length = Math.max(length, j - i + 1);
        }
      }
    }
    return length;
  }

  public static int longestSubArrayWithSumKBetterForBothPositiveAndNegative(int[] arr, int k){
    int maxLength = 0;
    long sum = 0;
    Map<Long, Integer> hash = new HashMap<>();
    for(int i = 0; i < arr.length; i++){
      sum += arr[i];
      if(sum == k) maxLength = Math.max(maxLength, i + 1);
      long rem = sum - k;
      if(hash.containsKey(rem)){
        maxLength = Math.max(maxLength, i - hash.get(rem));
      }
      if(!hash.containsKey(sum)){
        hash.put(sum, i);
      }
    }
    return maxLength;
  }

  public static int longestSubArrayWithSumKOptimalForOnlyPositiveOrWithZeroes(int[] arr, int k){
    int maxLength = 0;
    long sum = 0;
    int i = 0, j = 0;
    while(j < arr.length){
      sum += arr[j];
      while(sum > k && i <= j){
        sum -= arr[i];
        i++;
      }
      if(sum == k){
        maxLength = Math.max(maxLength, j - i + 1);
      }
      j++;
    }
    return maxLength;
  }
  //********************************************************************
  // LEETCODE PROBLEM - 16TH JULY
  public static long gcdSum(int[] nums) {
        int n = nums.length;
        int[] maxI = new int[n];
        int[] prefixGcd = new int[n];
        maxI[0] = nums[0];
        prefixGcd[0] = nums[0];
        for(int i = 1; i < n; i++){
            maxI[i] = Math.max(maxI[i - 1], nums[i]);
            prefixGcd[i] = gcd(maxI[i], nums[i]);
        }
        Arrays.sort(prefixGcd);
        for (int i : maxI) {
          System.out.print(i + " ");
        } System.out.println();
        for (int i : prefixGcd) {
          System.out.print(i + " ");
        } System.out.println();
        long result = 0;
        for(int i = 0; i < n/2; i++){
            result += gcd(prefixGcd[i], prefixGcd[n - i - 1]);
        }
        return result;
    }

  public static int gcd(int a, int b){
        while(a != 0 && b != 0){
            if(a > b){
                a %= b;
            }else{
                b %= a;
            }
        }
        if(a == 0) return b;
        return a;
    }
  //********************************************************************

  public static int[] twoSum(int[] arr, int target){
    Map<Integer, Integer> hash = new HashMap<>();
    for(int i = 0; i < arr.length; i++){
      if(hash.containsKey(target - arr[i])){
        return new int[] {hash.get(target - arr[i]), i};
      }
      hash.put(arr[i], i);
    }
    return new int[] {};
  }

  public static String twoSumOptimal(int[] arr, int target){
    Arrays.sort(arr);
    int low = 0, high = arr.length - 1;
    int count = 0;
    while(high > low){
      count = arr[low] + arr[high];
      if(count == target) return "YES";
      else if(count > target) high --;
      else low++;
    }
    return "NO";
  }

  public static void sortArrayOfZeroes_Ones_Twos(int[] arr){
    int low = 0, mid = 0, high = arr.length;
    while( high >= low){
      if(arr[mid] == 0){
        swap(arr, low, mid);
        low++;
        mid++;
      } else if(arr[mid] == 1) mid++;
      else{
        swap(arr, mid, high);
        high--;
      }
    }
  } 

  public static void swap(int[] arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static int majorityElement(int[] nums) {
    Map<Integer, Integer> hash = new HashMap<>();
    int count = 0;
    int n = nums.length;
    for(int num: nums){
      count = hash.getOrDefault(num, 0) + 1;
      if(count > n/2) return num;
      hash.put(num, count);
    }
    return -1;
  }

  public static int majorityElement_optimal(int[] arr){
    int count = 0;
    int n = arr.length;
    int candidate = -1;
    for(int i = 0; i < n; i++){
      if(count == 0){
        count = 1;
        candidate = arr[i];
      }
      else if(arr[i] == candidate) count++;
      else{
        count --;
      }
    }

    int originalCount = 0;
    for(int i = 0; i < n; i++){
      if(arr[i] == candidate) originalCount++; 
    }
    return originalCount > n/2? candidate: -1;
  }


}