/*
 * Problem: GraphRepresentation — Adjacency Matrix (Weighted)
 * Solved: 18-08-2026 | TC: O(V^2) to print, O(E) to build | SC: O(V^2)
 * Revisit: [date]
 */
import java.util.Scanner;

public class AdjacencyMatrixWeighted {
  public static void main(String[] args) {
    String input = "3 3\n1 2 10\n2 3 20\n1 3 30\n"; 
    Scanner scanner = new Scanner(input);
    
    int V = scanner.nextInt();
    int E = scanner.nextInt();
    int[][] adj = new int[V + 1][V + 1];
    
    for (int i = 1; i <= E; i++) {
      int u = scanner.nextInt();
      int v = scanner.nextInt();
      int weight = scanner.nextInt();
      adj[u][v] = weight;
      adj[v][u] = weight;
    }

    System.out.println("--- Weighted Adjacency Matrix ---");
    for (int i = 1; i <= V; i++) {
      for (int j = 1; j <= V; j++) {
        System.out.print(adj[i][j] + " "); 
      }
      System.out.println();
    }
    scanner.close();
  }
}