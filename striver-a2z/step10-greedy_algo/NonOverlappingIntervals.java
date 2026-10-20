import java.util.*;

public class NonOverlappingIntervals {

  // Return the minimum number of intervals you need to remove to make 
  // the rest of the intervals non-overlapping.
  // ith interval(intervals[i]) = [start_i, end_i]
  // Note: Intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping
  public static int eraseOverlappingIntervals(int[][] intervals){
    int n = intervals.length;

    Arrays.sort(intervals, (a, b) -> {
      return Integer.compare(a[1], b[1]);
    });

    int lastEndTime = Integer.MIN_VALUE;
    int count = 0;

    for(int[] interval: intervals){
      int currentStart = interval[0];
      int currentEnd = interval[1];

      if(currentStart >= lastEndTime){
        count++;
        lastEndTime = currentEnd;
      }
    }

    return n - count;
  }


  public static void main(String[] args){
    // ---- Non-overlapping intervals (LeetCode 435): fewest removals ----
    // Here touching is allowed: [1,2] and [2,3] do NOT overlap.
    check("[[1,2],[2,3],[3,4],[1,3]]", eraseOverlappingIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}), 1);
    check("[[1,2],[1,2],[1,2]]", eraseOverlappingIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}), 2);
    check("touching is fine  [[1,2],[2,3]]", eraseOverlappingIntervals(new int[][]{{1, 2}, {2, 3}}), 0);
    check("one long interval over three short  [[1,100],[2,3],[4,5],[6,7]]",
          eraseOverlappingIntervals(new int[][]{{1, 100}, {2, 3}, {4, 5}, {6, 7}}), 1);
    check("negative coordinates  [[-5,-3],[-4,-1],[-2,0]]",
          eraseOverlappingIntervals(new int[][]{{-5, -3}, {-4, -1}, {-2, 0}}), 1);
    check("single interval", eraseOverlappingIntervals(new int[][]{{0, 1}}), 0);
  }

  // ---- test helpers ----

  private static void check(String label, Object got, Object expected){
    boolean ok = String.valueOf(got).equals(String.valueOf(expected));
    System.out.println((ok ? "PASS  " : "FAIL  ") + label + "  ->  " + got + (ok ? "" : "   (expected " + expected + ")"));
  }
}