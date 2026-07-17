/*
 * Topic: Recursion basics — Striver A2Z Step 1
 * Migrated: 2026-07-17 (from original Main.java)
 * Revisit: [date when re-solved from scratch]
 */
public class Recursion {
  public static void main(String[] args) {
    recursion_1_to_N(1, 5); System.out.println();
    recursion_N_to_1(1, 5); System.out.println();
    recursion_1_to_N_backtracking(1, 5); System.out.println();
    recursion_N_to_1_backtracking(1, 5); System.out.println();
    System.out.println("sum 1..5 = " + recursion_sumOfFirstN(5));
    System.out.println("5! = " + recursion_factorial(5));
    System.out.println("palindrome: " + isPalidrome_recursive(0, "madam"));
  }

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
}
