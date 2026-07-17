/*
 * Topic: Basic maths — Striver A2Z Step 1
 * Migrated: 2026-07-17 (from original Main.java)
 * Revisit: [date when re-solved from scratch]
 */
import java.util.*;

public class BasicMaths {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long n = scanner.nextLong();
    System.out.println("reversed: " + reversedNumber(n));
    System.out.println("palindrome: " + checkPalidrome((int) n));
    System.out.println("armstrong: " + isArmstrong((int) n));
    System.out.println("divisors: " + printDivisors((int) n));
    System.out.println("prime: " + isPrime((int) n));
    scanner.close();
  }

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
}
