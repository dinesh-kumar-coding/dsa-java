import java.util.*;

public class NMeetingsInOneRoom {

  // Find the maximum number of meetings that can be scheduled in one 
  // room without overlapping.
  public static int maxMeetings(int[] start, int[] end){
    int n = start.length;

    int[][] meetings = new int[n][2];

    for(int i = 0; i < n; i++){
      meetings[i][0] = start[i];
      meetings[i][1] = end[i];
    }

    Arrays.sort(meetings, (a, b) -> {
      return Integer.compare(a[1], b[1]);
    });

    int lastEndTime = -1;

    int count = 0;

    for(int[] meeting: meetings){
      int currentStart = meeting[0];
      int currentEnd = meeting[1];

      if(currentStart > lastEndTime){
        count++;
        lastEndTime = currentEnd;
      }
    } 
    return count;
  }

  // Find the order of maximum number of meetings that can be scheduled 
  // in one room without overlapping.
  public static ArrayList<Integer> maxMeetings_order(int[] start, int[] end){
    int n = start.length;

    int[][] meetings = new int[n][3];

    for(int i = 0; i < n; i++){
      meetings[i][0] = i;
      meetings[i][1] = start[i];
      meetings[i][2] = end[i];
    }

    // Sort based on the end time but if end times are equal consider 
    // according to index
    Arrays.sort(meetings, (a, b) -> {
      int endCompare = Integer.compare(a[2], b[2]);
      if(endCompare == 0){
        return Integer.compare(a[0], b[0]);
      }
      return endCompare;
    });

    int lastEndTime = -1;
    ArrayList<Integer> order = new ArrayList<>();

    for(int[] meeting: meetings){
      int currentIndex = meeting[0];
      int currentStart = meeting[1];
      int currentEnd = meeting[2];

      if(currentStart > lastEndTime){
        order.add(currentIndex);
        lastEndTime = currentEnd;
      }
    }

    return order;
  }


  public static void main(String[] args){
    // ---- N meetings in one room: how many meetings fit ----
    // A meeting can only start AFTER the previous one ends - equal times clash.
    check("classic  start=[1,3,0,5,8,5] end=[2,4,6,7,9,9]",
          maxMeetings(new int[]{1, 3, 0, 5, 8, 5}, new int[]{2, 4, 6, 7, 9, 9}), 4);
    check("touching clashes  (1,2) (2,3)", maxMeetings(new int[]{1, 2}, new int[]{2, 3}), 1);
    check("one long meeting vs three short ones  (0,10) (1,2) (3,4) (5,6)",
          maxMeetings(new int[]{0, 1, 3, 5}, new int[]{10, 2, 4, 6}), 3);
    check("all overlap  (1,5) (2,6) (3,7)", maxMeetings(new int[]{1, 2, 3}, new int[]{5, 6, 7}), 1);
    check("meeting starting at time 0", maxMeetings(new int[]{0}, new int[]{1}), 1);
    check("no meetings", maxMeetings(new int[]{}, new int[]{}), 0);

    System.out.println();

    // ---- the order of the chosen meetings (0-based indices, in the order they are held) ----
    check("classic order", maxMeetings_order(new int[]{1, 3, 0, 5, 8, 5}, new int[]{2, 4, 6, 7, 9, 9}), "[0, 1, 3, 4]");
    check("order follows end times, not input order  (5,6) (1,2) (3,4)",
          maxMeetings_order(new int[]{5, 1, 3}, new int[]{6, 2, 4}), "[1, 2, 0]");
    // Same end time: the smaller index wins, even though meeting 1 starts earlier.
    check("tie on end time -> smaller index  (2,5) (1,5)", maxMeetings_order(new int[]{2, 1}, new int[]{5, 5}), "[0]");
    check("no meetings", maxMeetings_order(new int[]{}, new int[]{}), "[]");

  }

  // ---- test helpers ----

  private static void check(String label, Object got, Object expected){
    boolean ok = String.valueOf(got).equals(String.valueOf(expected));
    System.out.println((ok ? "PASS  " : "FAIL  ") + label + "  ->  " + got + (ok ? "" : "   (expected " + expected + ")"));
  }
}