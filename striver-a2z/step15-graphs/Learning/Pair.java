/*
 * Utility: Generic Pair Class for Weighted Graphs
 * Question: Small generic utility class holding two values — used when a queue or list needs to carry (node, distance) style pairs.
 * Created: 18-08-2026
 */
public class Pair<X, Y> {
  public X first;
  public Y second;

  public Pair(X first, Y second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public String toString() {
    return "(" + first + ", " + second + ")";
  }
}