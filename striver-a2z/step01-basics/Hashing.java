/*
 * Topic: Hashing basics — Striver A2Z Step 1
 * Migrated: 2026-07-17 (from original Main.java)
 * Revisit: [date when re-solved from scratch]
 */
import java.util.*;

public class Hashing {
  public static void main(String[] args) {
    int[] arr = {1, 2, 2, 3, 3, 3, 7};
    Frequency(arr, arr.length);
    highest_occuring_element_in_array(arr, arr.length);
  }

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
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
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
}
