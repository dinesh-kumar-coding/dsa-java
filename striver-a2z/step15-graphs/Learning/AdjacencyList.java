/*
 * Problem: GraphRepresentation — Adjacency List (Unweighted)
 * Solved: 18-08-2026 | TC: O(V + E) to print, O(E) to build | SC: O(V + E)
 * Revisit: [date]
 */
import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyList {
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    String input = "3 3\n1 2\n2 3\n1 3\n"; 
    Scanner scanner = new Scanner(input);
    
    int V = scanner.nextInt();
    int E = scanner.nextInt();

    ArrayList<Integer>[] adj = new ArrayList[V + 1];

    for (int i = 0; i <= V; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 1; i <= E; i++) {
      int u = scanner.nextInt();
      int v = scanner.nextInt();
      adj[u].add(v);
      adj[v].add(u);
    }

    System.out.println("--- Adjacency List ---");
    for (int i = 1; i <= V; i++) {
      System.out.print(i + " -> ");
      for (int neighbors : adj[i]) {
        System.out.print(neighbors + " ");
      }
      System.out.println(); 
    }
    scanner.close();
  }
}