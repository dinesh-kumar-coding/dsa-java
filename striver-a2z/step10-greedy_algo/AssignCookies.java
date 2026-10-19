import java.util.Arrays;

public class AssignCookies {
  public static void main(String[] args) {
    check("g=[1,2,3] c=[1,1]", assignCookies(new int[]{1,2,3}, new int[]{1,1}), 1);
    check("g=[1,2]   c=[1,2,3]", assignCookies(new int[]{1,2}, new int[]{1,2,3}), 2);
    check("g=[10,9,8,7] c=[5,6,7,8] (unsorted input)", assignCookies(new int[]{10,9,8,7}, new int[]{5,6,7,8}), 2);
    check("g=[2,2] c=[1,1,1,3] (small cookies wasted)", assignCookies(new int[]{2,2}, new int[]{1,1,1,3}), 1);
    check("no cookies", assignCookies(new int[]{1,2,3}, new int[]{}), 0);
    check("no children", assignCookies(new int[]{}, new int[]{1,2}), 0);
  }

  public static int assignCookies(int[] g, int[] c) {

    Arrays.sort(g);
    Arrays.sort(c);

    int childIndex = 0;
    int cookieIndex = 0;

    while (cookieIndex < c.length && childIndex < g.length) {

      if (c[cookieIndex] >= g[childIndex]) {
        childIndex++;
      }
      cookieIndex++;
    }

    return childIndex;
  }

  // ---- test helpers ----

  private static void check(String label, Object got, Object expected){
    boolean ok = String.valueOf(got).equals(String.valueOf(expected));
    System.out.println((ok ? "PASS  " : "FAIL  ") + label + "  ->  " + got + (ok ? "" : "   (expected " + expected + ")"));
  }
}
