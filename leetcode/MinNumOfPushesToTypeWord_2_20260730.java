/*
 * Topic: Minimum Number of Pushes to Type Word II — LeetCode 3016 (daily, 2026-07-30)
 * Written: 2026-07-30
 * Greedy: count letter frequencies, sort descending, give the most-frequent letters the cheapest keys —
 *         top 8 letters cost 1 push each, next 8 cost 2, next 8 cost 3, last 2 cost 4. TC O(N), SC O(1).
 * Revisit: [date when re-solved from scratch]
 */
import java.util.Arrays;

public class MinNumOfPushesToTypeWord_2_20260730 {

  public static void main(String[] args) {
    System.out.println("abcde        : " + minimumPushes("abcde"));         // expected 5
    System.out.println("xyzxyzxyzxyz : " + minimumPushes("xyzxyzxyzxyz"));  // expected 12
    System.out.println("a..m (13)    : " + minimumPushes("abcdefghijklm"));  // expected 18
  }

  public static int minimumPushes(String word) {
        int[] hash = new int[26];
        int count = 0;
        for(int i = 0; i < word.length(); i++){
            hash[word.charAt(i) - 'a']++;
        }

        Arrays.sort(hash);
        for(int i = 25; i >= 0; i--){
            if(i > 17){
                count += hash[i];
            } else if(i > 9){
                count += hash[i]*2;
            } else if(i > 1){
                count += hash[i]*3;
            } else count += hash[i]*4;
        }
        return count;
    }
}