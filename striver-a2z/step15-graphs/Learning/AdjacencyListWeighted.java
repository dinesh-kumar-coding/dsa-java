/*
 * Problem: GraphRepresentation — Adjacency List (Weighted)
 * Solved: 18-08-2026 | TC: O(V + E) to print, O(E) to build | SC: O(V + E)
 * Revisit: [date]
 */
import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyListWeighted {
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    String input = "3 3\n1 2 10\n2 3 20\n1 3 30\n"; 
    Scanner scanner = new Scanner(input);
    
    int V = scanner.nextInt();
    int E = scanner.nextInt();

    ArrayList<Pair<Integer, Integer>>[] adj = new ArrayList[V + 1];

    for (int i = 0; i <= V; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 1; i <= E; i++) {
      int u = scanner.nextInt();
      int v = scanner.nextInt();
      int weight = scanner.nextInt();
      adj[u].add(new Pair<>(v, weight));
      adj[v].add(new Pair<>(u, weight));
    }

    System.out.println("--- Weighted Adjacency List ---");
    for (int i = 1; i <= V; i++) {
      System.out.print(i + ": ");
      for (Pair<Integer, Integer> neighbor : adj[i]) {
        System.out.print(neighbor.first + "(" + neighbor.second + ")" + " -> ");
      } 
      System.out.println("null");
    }
    scanner.close();
  }
}