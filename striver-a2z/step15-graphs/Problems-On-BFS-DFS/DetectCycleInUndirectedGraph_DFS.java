/*
 * Problem: Detect Cycle in an Undirected Graph — Optimal: DFS
 * Solved: 26-08-2026 | TC: O(V + E) | SC: O(V)
 * Revisit: [date]
 */
import java.util.*;

public class DetectCycleInUndirectedGraph_DFS {
  public static void main(String[] args) {
    // Test 1: Graph with a cycle
    // 0 - 1 - 2
    //     |   |
    //     4 - 3
    int V1 = 5;
    ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
    for(int i = 0; i < V1; i++) adj1.add(new ArrayList<>());
    addEdge(adj1, 0, 1);
    addEdge(adj1, 1, 2);
    addEdge(adj1, 2, 3);
    addEdge(adj1, 3, 4);
    addEdge(adj1, 4, 1); // This edge creates the cycle
    System.out.println("Test 1 (Has Cycle): " + isCycle(V1, adj1)); // Expected: true

    // Test 2: Graph without a cycle
    // 0 - 1 - 2
    //     |
    //     3
    int V2 = 4;
    ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
    for(int i = 0; i < V2; i++) adj2.add(new ArrayList<>());
    addEdge(adj2, 0, 1);
    addEdge(adj2, 1, 2);
    addEdge(adj2, 1, 3);
    System.out.println("Test 2 (No Cycle): " + isCycle(V2, adj2)); // Expected: false
  }

  // Helper method to add edges to the undirected graph
  private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
    adj.get(u).add(v);
    adj.get(v).add(u);
  }

  public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
    boolean[] vis = new boolean[V];
    for(int i = 0; i < V; i++){
      if(!vis[i]){
        if(dfs(i, -1, adj, vis)) return true;
      }
    }
    return false;
  }

  public static boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
    vis[node] = true;
    for(int adjacentNode: adj.get(node)){
      if(!vis[adjacentNode]){
        if(dfs(adjacentNode, node, adj, vis)) return true;
      } else if(adjacentNode != parent) return true;
    }
    return false;
  }
}