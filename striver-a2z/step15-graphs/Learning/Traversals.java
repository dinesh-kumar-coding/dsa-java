/*
 * Problem: Graph Traversals (BFS & DFS)
 * Solved: 18-08-2026 | TC: O(V + E) | SC: O(V)
 * Revisit: [date]
 */
import java.util.*;

public class Traversals {
  public static void main(String[] args) {
    int V = 5;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    // Creating an undirected graph:
    // 0 --- 1 --- 3
    // |     |
    // 2 --- 4
    
    // Add edge 0-1
    adj.get(0).add(1); adj.get(1).add(0);
    // Add edge 0-2
    adj.get(0).add(2); adj.get(2).add(0);
    // Add edge 1-3
    adj.get(1).add(3); adj.get(3).add(1);
    // Add edge 1-4
    adj.get(1).add(4); adj.get(4).add(1);
    // Add edge 2-4
    adj.get(2).add(4); adj.get(4).add(2);

    System.out.println("Graph Adjacency List:");
    for(int i = 0; i < V; i++) {
      System.out.println(i + " -> " + adj.get(i));
    }

    System.out.println("\nBFS Traversal: " + bfsOfGraph(V, adj)); // Expected: [0, 1, 2, 3, 4]
    System.out.println("DFS Traversal: " + dfsOfGraph(V, adj)); // Expected: [0, 1, 3, 4, 2]
  }

  public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
    ArrayList<Integer> bfs = new ArrayList<>();
    boolean vis[] = new boolean[V];
    Queue <Integer> q = new LinkedList<>();
    q.add(0);
    vis[0] = true;
    while(!q.isEmpty()){
      int node = q.poll();
      bfs.add(node);

      for(int it: adj.get(node)){
        if(vis[it] == false){
          vis[it] = true;
          q.add(it);
        }
      }
    }
    return bfs;
  }

  public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> dfs){
    vis[node] = true;
    dfs.add(node);

    for(Integer it: adj.get(node)){
      if(vis[it] == false){
        dfs(it, adj, vis, dfs);
      }
    }
  }

  public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
    boolean[] vis = new boolean[V];
    ArrayList<Integer> dfs = new ArrayList<>();
    dfs(0, adj, vis, dfs);
    return dfs;
  }
}