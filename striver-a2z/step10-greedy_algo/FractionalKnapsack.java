import java.util.Arrays;

public class FractionalKnapsack {

  static class Pair {
    int weight;
    int value;

    Pair(int weight, int value) {
      this.weight = weight;
      this.value = value;
    }

  }

  public static void main(String[] args) {
    System.out.println("--- Fractional Knapsack (GFG) ---   Pair(weight, value)");
    checkDouble("W=50  [(10,60) (20,100) (30,120)]",
        maximumValue(new Pair[]{new Pair(10,60), new Pair(20,100), new Pair(30,120)}, 3, 50), 240.0);
    checkDouble("W=100 everything fits",
        maximumValue(new Pair[]{new Pair(10,60), new Pair(20,100)}, 2, 100), 160.0);
    checkDouble("W=10  only a fraction of (30,500)",
        maximumValue(new Pair[]{new Pair(30,500)}, 1, 10), 500.0 / 3);
    checkDouble("W=10  exactly one item (10,60)",
        maximumValue(new Pair[]{new Pair(10,60)}, 1, 10), 60.0);
    checkDouble("W=0",
        maximumValue(new Pair[]{new Pair(10,60), new Pair(20,100)}, 2, 0), 0.0);

    System.out.println();
    System.out.println("--- Maximum Units on a Truck (LeetCode 1710) ---   {boxes, unitsPerBox}");
    check("truck=4  [[1,3],[2,2],[3,1]]", maximumUnits(new int[][]{{1,3},{2,2},{3,1}}, 4), 8);
    check("truck=10 [[5,10],[2,5],[4,7],[3,9]]", maximumUnits(new int[][]{{5,10},{2,5},{4,7},{3,9}}, 10), 91);
    check("truck=100 (everything fits)", maximumUnits(new int[][]{{1,3},{2,2}}, 100), 7);
    check("truck=1 (take the single best box)", maximumUnits(new int[][]{{2,5},{3,9}}, 1), 9);
  }

  public static double maximumValue(Pair[] items, int n, int capacity) {
    Arrays.sort(items, (a, b) -> {
      double ratioA = (double) a.value / a.weight;
      double ratioB = (double) b.value / b.weight;

      return Double.compare(ratioB, ratioA);
    });

    double maxValue = 0;

    for (int i = 0; i < n; i++) {
      if (capacity == 0) {
        break;
      } else if (capacity >= items[i].weight) {
        maxValue += items[i].value;
        capacity -= items[i].weight;
      } else {
        maxValue += (double) (items[i].value * capacity) / (items[i].weight);
        capacity = 0;
      }
    }
    return maxValue;
  }

  public static int maximumUnits(int[][] boxTypes, int truckSize) {
    // Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]); // b[1] - a[1] may cause int
    // overflow
    Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
    int units = 0;
    for (int i = 0; i < boxTypes.length; i++) {
      if (truckSize == 0)
        break;
      if (truckSize >= boxTypes[i][0]) {
        truckSize -= boxTypes[i][0];
        units += boxTypes[i][1] * boxTypes[i][0];
      } else {
        units += truckSize * boxTypes[i][1];
        truckSize = 0;
      }
    }
    return units;
  }

  // ---- test helpers ----

  private static void check(String label, Object got, Object expected){
    boolean ok = String.valueOf(got).equals(String.valueOf(expected));
    System.out.println((ok ? "PASS  " : "FAIL  ") + label + "  ->  " + got + (ok ? "" : "   (expected " + expected + ")"));
  }

  private static void checkDouble(String label, double got, double expected){
    boolean ok = Math.abs(got - expected) < 1e-6;   // doubles: compare with a tolerance, never ==
    System.out.println((ok ? "PASS  " : "FAIL  ") + label + "  ->  " + got + (ok ? "" : "   (expected " + expected + ")"));
  }
}
