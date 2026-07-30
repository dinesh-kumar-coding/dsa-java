/*
 * Topic: Minimum Number of Pushes to Type Word I — LeetCode 3014 (daily, 2026-07-30)
 * Written: 2026-07-30
 * Greedy: cheapest slots first — first 8 letters cost 1 push each, next 8 cost 2, next 8 cost 3, last 2 cost 4.
 *         Letters are distinct, so the total depends only on word length (bracketed). TC O(1), SC O(1).
 * Revisit: [date when re-solved from scratch]
 */
public class MinNumOfPushesToTypeWord20260730 {

  public static void main(String[] args){
    System.out.println("abcde (5):  " + minimumPushes("abcde"));                       // expected 5
    System.out.println("a..j  (10): " + minimumPushes("abcdefghij"));                  // expected 12
    System.out.println("a..z  (26): " + minimumPushes("abcdefghijklmnopqrstuvwxyz"));  // expected 56
    
  }

  public static int minimumPushes(String word) {
      int length = word.length();
      if(length <= 8){
        return length;
      } else if(length <= 16){
        return 8 + (length - 8)*2;
      } else if(length <= 24){
        return 24 + (length - 16)*3;
      } else return 48 + (length - 24)* 4;
    }
}
