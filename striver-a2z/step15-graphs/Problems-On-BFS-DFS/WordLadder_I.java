/*
 * Problem: Word Ladder I — Optimal: BFS
 * Solved: 10-09-2026 | TC: O(N * M^2) | SC: O(N * M) 
 * Revisit: [date]
 * Note: N = number of words in list, M = length of each word
 */
import java.util.*;

class Pair_ {
  String first;
  int second;

  Pair_(String first, int second) {
    this.first = first;
    this.second = second;
  }
}

public class WordLadder_I {
  public static void main(String[] args) {
    // Test 1: Standard case (hit -> hot -> dot -> dog -> cog)
    String begin1 = "hit";
    String end1 = "cog";
    List<String> list1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
    System.out.println("Test 1: " + wordLadder_I(begin1, end1, list1)); // Expected: 5

    // Test 2: Target word is not in the list
    String begin2 = "hit";
    String end2 = "cog";
    List<String> list2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
    System.out.println("Test 2: " + wordLadder_I(begin2, end2, list2)); // Expected: 0

    // Test 3: Short path where a single change reaches the target
    String begin3 = "a";
    String end3 = "c";
    List<String> list3 = Arrays.asList("a", "b", "c");
    System.out.println("Test 3: " + wordLadder_I(begin3, end3, list3)); // Expected: 2
  }

  public static int wordLadder_I(String beginWord, String endWord, List<String> wordList) {
    Queue<Pair_> q = new LinkedList<>();
    q.add(new Pair_(beginWord, 1));
    Set<String> st = new HashSet<String>();
    int len = wordList.size();
    for (int i = 0; i < len; i++) {
      st.add(wordList.get(i));
    }

    st.remove(beginWord);

    while (!q.isEmpty()) {
      String word = q.peek().first;
      int steps = q.peek().second;
      q.remove();

      if(word.equals(endWord)) return steps;

      for(int i = 0; i < word.length(); i++){
        for(char ch = 'a'; ch <= 'z'; ch++){
          char[] replacedCharArray = word.toCharArray();
          replacedCharArray[i] = ch;
          String replacedWord = new String(replacedCharArray);

          if(st.contains(replacedWord)){
            st.remove(replacedWord);
            q.add(new Pair_(replacedWord, steps + 1));
          }
        }
      }
    }
    return 0;
  }
}