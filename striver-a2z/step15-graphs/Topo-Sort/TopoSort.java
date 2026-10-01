/*
 * Problem: Topological Sort — Optimal 1: DFS + Stack | Optimal 2: BFS (Kahn's Algorithm)
 * Question: Produce a topological ordering of a DAG — for every edge u->v, u must appear before v.
 * Solved: 11-09-2026 | TC: O(V + E) for both | SC: O(V) for both
 * Revisit: [date]
 */
import java.util.*;

public class TopoSort {
  public static void main(String[] args) {
    // Test 1: Simple Linear DAG (0 -> 1 -> 2)
    int V1 = 3;
    ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
    for(int i = 0; i < V1; i++) adj1.add(new ArrayList<>());
    adj1.get(0).add(1);
    adj1.get(1).add(2);
    System.out.println("--- Test 1 (Simple DAG) ---");
    System.out.println("DFS:   " + Arrays.toString(topoSort(V1, adj1))); // Expected: [0, 1, 2]
    System.out.println("Kahn's: " + Arrays.toString(topoSort_kahnsAlgorithm(V1, adj1))); // Expected: [0, 1, 2]

    // Test 2: Standard DAG with multiple dependencies
    // 5 -> 0, 4 -> 0, 5 -> 2, 4 -> 1, 2 -> 3, 3 -> 1
    int V2 = 6;
    ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
    for(int i = 0; i < V2; i++) adj2.add(new ArrayList<>());
    adj2.get(5).add(0);
    adj2.get(4).add(0);
    adj2.get(5).add(2);
    adj2.get(4).add(1);
    adj2.get(2).add(3);
    adj2.get(3).add(1);
    System.out.println("\n--- Test 2 (Complex DAG) ---");
    System.out.println("DFS:   " + Arrays.toString(topoSort(V2, adj2))); 
    // Expected DFS Output: A valid ordering like [5, 4, 2, 3, 1, 0]
    System.out.println("Kahn's: " + Arrays.toString(topoSort_kahnsAlgorithm(V2, adj2))); 
    // Expected Kahn's Output: A valid ordering like [4, 5, 0, 2, 3, 1] 
    // Note: BFS and DFS often produce different but equally valid topological sorts!
  }

  // Optimal 1: DFS Approach
  public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
    boolean[] vis = new boolean[V];
    Stack<Integer> st = new Stack<Integer>();
    for(int i = 0; i < V; i++){
      if(!vis[i]){
        dfs(i, vis, st, adj);
      }
    }

    int[] ans = new int[V];
    int i = 0;
    while(!st.isEmpty()){
      ans[i++] = st.peek();
      st.pop();
    }
    return ans;
  }

  public static void dfs(int node, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){
    vis[node] = true;
    for(int it : adj.get(node)){
      if(!vis[it]){
        dfs(it, vis, st, adj);
      }
    }
    st.push(node);
  }

  // Optimal 2: BFS Approach (Kahn's Algorithm)
  public static int[] topoSort_kahnsAlgorithm(int V, ArrayList<ArrayList<Integer>> adj){
    int indegree[] = new int[V];
    for(int i = 0; i < V; i++){
      for(int it: adj.get(i)){
        indegree[it]++;
      }
    }

    Queue<Integer> q = new LinkedList<>();
    for(int i = 0; i < V; i++){
      if(indegree[i] == 0){
        q.add(i);
      }
    }

    int topo[] = new int[V];
    int i = 0;
    while(!q.isEmpty()){
      int node = q.peek();
      q.remove();
      topo[i++] = node;
      
      for(int it: adj.get(node)){
        indegree[it]--;
        if(indegree[it] == 0){
          q.add(it);
        }
      }
    }
    return topo;
  }
}