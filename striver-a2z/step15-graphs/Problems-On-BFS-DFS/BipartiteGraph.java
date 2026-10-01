/*
 * Problem: BipartiteGraph — Optimal 1: DFS Colouring | Optimal 2: BFS Colouring
 * Question: Check whether an undirected graph can be coloured with just two colours so that
 *           no edge ever joins two vertices of the same colour. (A graph is bipartite exactly
 *           when it contains NO odd-length cycle — even cycles and trees are always fine.)
 * Solved: 01-10-2026 | TC: O(V + E) for both | SC: O(V) for both
 * Revisit: [date]
 */
import java.util.*;

public class BipartiteGraph {
  public static void main (String[] args){
    // Test 1: even cycle 0-1-2-3-0 -> bipartite (every even cycle is)
    int[][] e1 = {{0,1},{1,2},{2,3},{3,0}};
    check("Test 1 (4-cycle, even)", 4, e1, true);

    // Test 2: odd cycle 0-1-2-0 -> NOT bipartite (the whole point of the problem)
    int[][] e2 = {{0,1},{1,2},{2,0}};
    check("Test 2 (triangle, odd)", 3, e2, false);

    // Test 3: a tree -> always bipartite (no cycles at all)
    int[][] e3 = {{0,1},{0,2},{1,3},{1,4}};
    check("Test 3 (tree)", 5, e3, true);

    // Test 4: DISCONNECTED — a clean edge plus a triangle hiding in the second component.
    // Fails if you only start from node 0 and never loop over the rest.
    int[][] e4 = {{0,1},{2,3},{3,4},{4,2}};
    check("Test 4 (odd cycle in 2nd component)", 5, e4, false);

    // Test 5: single vertex, no edges -> trivially bipartite
    int[][] e5 = {};
    check("Test 5 (single vertex)", 1, e5, true);

    // Test 6: self loop 0-0 -> cannot be two-coloured
    int[][] e6 = {{0,0}};
    check("Test 6 (self loop)", 2, e6, false);
  }

  // ---- test helpers ----

  // Runs BOTH approaches and reports whether they agree with each other and with the expected answer.
  private static void check(String label, int V, int[][] edges, boolean expected){
    ArrayList<ArrayList<Integer>> adj = buildUndirected(V, edges);
    boolean dfsAns = isBipartite(V, adj);
    boolean bfsAns = isBipartite_bfs(V, adj);
    String verdict = (dfsAns == expected && bfsAns == expected) ? "PASS" : "FAIL";
    System.out.println(label + " -> DFS: " + dfsAns + " | BFS: " + bfsAns
                       + " | expected: " + expected + "  [" + verdict + "]");
  }

  private static ArrayList<ArrayList<Integer>> buildUndirected(int V, int[][] edges){
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
    for(int[] e: edges){
      adj.get(e[0]).add(e[1]);
      if(e[0] != e[1]) adj.get(e[1]).add(e[0]);   // undirected: add both ways
    }
    return adj;
  }

  private static boolean dfs(int node, int col, int[] color, ArrayList<ArrayList<Integer>> adj){
    color[node] = col;
    for(int it: adj.get(node)){
      if(color[it] == -1){
        if(dfs(it, 1 - col, color, adj) == false) return false;
      } else if(color[it] == col) return false;
    }
    return true;
  } 

  public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj){
    int[] color = new int[V];
    for(int i = 0; i < V; i++){
      color[i] = -1;
    }

    for(int i = 0; i < V; i++){
      if(color[i] == -1){
        if(dfs(i, 0, color, adj) == false) return false;
      }
    }
    return true;
  }

  public static boolean isBipartite_bfs(int V, ArrayList<ArrayList<Integer>> adj){
    int[] color = new int[V];
    for(int i = 0; i < V; i++){
      color[i] = -1;
    }
    Queue<Integer> q = new LinkedList<>();
    for(int i = 0; i < V; i++){
      if(color[i] == -1){
        q.add(i);
        color[i] = 0;
        while(!q.isEmpty()){
          int node = q.peek();
          q.remove();

          for(int it: adj.get(node)){
            if(color[it] == -1){
              q.add(it);
              color[it] = 1 - color[node]; 
            } else if(color[it] == color[node]){
              return false;
            }
          }
        }
      }
    }
    return true;
  }
}
