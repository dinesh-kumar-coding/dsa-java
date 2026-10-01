/*
 * Problem: DetectCycleInDirectedGraph_BFS — Optimal: Kahn's Algorithm (indegree + BFS)
 * Question: Detect whether a DIRECTED graph contains a cycle, using BFS instead of DFS.
 *           Kahn's topological sort can only release a vertex once its indegree hits 0, so a
 *           vertex sitting on a cycle never gets released. If fewer than V vertices come out
 *           of the queue, the leftovers are stuck in a cycle.
 * Solved: 01-10-2026 | TC: O(V + E) | SC: O(V)
 * Revisit: [date]
 */
import java.util.*;

public class DetectCycleInDirectedGraph_BFS {
  public static void main(String[] args){
    // Test 1: linear DAG 0 -> 1 -> 2 -> no cycle
    int[][] e1 = {{0,1},{1,2}};
    check("Test 1 (linear DAG)", 3, e1, false);

    // Test 2: pure cycle 0 -> 1 -> 2 -> 0
    int[][] e2 = {{0,1},{1,2},{2,0}};
    check("Test 2 (pure cycle)", 3, e2, true);

    // Test 3: branching DAG, no cycle despite two paths reaching the same node
    // (a "diamond" is NOT a cycle — direction is what matters)
    int[][] e3 = {{0,1},{0,2},{1,3},{2,3}};
    check("Test 3 (diamond DAG)", 4, e3, false);

    // Test 4: DISCONNECTED — 0 -> 1 is fine, but 2 -> 3 -> 2 is a cycle.
    // Fails if you stop as soon as one component drains cleanly.
    int[][] e4 = {{0,1},{2,3},{3,2}};
    check("Test 4 (cycle in 2nd component)", 4, e4, true);

    // Test 5: self loop 0 -> 0 is the smallest possible cycle
    int[][] e5 = {{0,0}};
    check("Test 5 (self loop)", 2, e5, true);

    // Test 6: no edges at all -> no cycle
    int[][] e6 = {};
    check("Test 6 (no edges)", 3, e6, false);
  }

  // ---- test helpers ----

  private static void check(String label, int V, int[][] edges, boolean expected){
    boolean got = detectCycle(V, buildDirected(V, edges));
    System.out.println(label + " -> cycle: " + got + " | expected: " + expected
                       + "  [" + (got == expected ? "PASS" : "FAIL") + "]");
  }

  private static ArrayList<ArrayList<Integer>> buildDirected(int V, int[][] edges){
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
    for(int[] e: edges) adj.get(e[0]).add(e[1]);   // directed: one way only
    return adj;
  }

  public static boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj){
    int[] indegree = new int[V];
    for(int i = 0; i < V; i++){
      for(int it: adj.get(i)){
        indegree[it]++;
      }
    }
    Queue<Integer> q = new LinkedList<>();
    for(int i = 0; i < V; i++){
      if(indegree[i] == 0) q.add(i);
    }

    int count = 0;
    while(!q.isEmpty()){
      int node = q.peek();
      q.remove();
      count++;

      for(int it: adj.get(node)){
        indegree[it]--;
        if(indegree[it] == 0) q.add(it);
      }
    }

    return count != V;
  }
}

