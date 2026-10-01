/*
 * Problem: Detect Cycle in a Directed Graph — Optimal: DFS (Path Visited Array)
 * Question: Detect a cycle in a DIRECTED graph using DFS with both a visited and a path-visited array.
 * Solved: 11-09-2026 | TC: O(V + E) | SC: O(V + E)
 * Revisit: [date]
 */
import java.util.*;

public class DetectCycleInDirectedGraph_DFS {
  public static void main(String[] args) {
    // Test 1: Graph with a cycle (0 -> 1 -> 2 -> 0)
    int V1 = 3;
    int[][] edges1 = {{1, 0}, {2, 1}, {0, 2}};
    System.out.println("Test 1 (Has Cycle): " + detectCycle(V1, edges1)); // Expected: true

    // Test 2: Graph without a cycle (0 -> 1 -> 2)
    int V2 = 3;
    int[][] edges2 = {{1, 0}, {2, 1}};
    System.out.println("Test 2 (No Cycle): " + detectCycle(V2, edges2)); // Expected: false

    // Test 3: Disconnected graph where one component has a cycle
    // 0 -> 1, 2 -> 3 -> 4 -> 2
    int V3 = 5;
    int[][] edges3 = {{1, 0}, {3, 2}, {4, 3}, {2, 4}};
    System.out.println("Test 3 (Has Cycle): " + detectCycle(V3, edges3)); // Expected: true
  }

  public static boolean detectCycle(int V, int[][] edges) {
    int n = edges.length;
    boolean[] visited = new boolean[V];
    boolean[] pathVisited = new boolean[V];

    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }
    for (int i = 0; i < n; i++) {
      int course = edges[i][0];
      int prerequisite = edges[i][1];
      adj.get(prerequisite).add(course);
    }

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        if (dfs(i, visited, pathVisited, adj))
          return true;
      }
    }

    return false;
  }

  public static boolean dfs(int node, boolean[] visited, boolean[] pathVisited, List<List<Integer>> adj) {
    visited[node] = true;
    pathVisited[node] = true;

    for (int neighbor : adj.get(node)) {
      if (!visited[neighbor]) {
        if (dfs(neighbor, visited, pathVisited, adj))
          return true;
      } else if (pathVisited[neighbor]) {
        return true;
      }
    }

    pathVisited[node] = false;
    return false;
  }
}