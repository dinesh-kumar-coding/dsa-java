/*
 * Problem: Number of Connected Components & Count Complete Components
 * Solved: 18-08-2026 | TC: O(V + E) | SC: O(V + E)
 * Revisit: [date]
 */

import java.util.*;

public class ConnectedComponents {
  public static void main(String[] args) {
    System.out.println("--- Standard Connected Components ---");
    // Test 1: 5 vertices, 2 components: {0,1,2} and {3,4}
    int V1 = 5;
    int[][] edges1 = {{0, 1}, {1, 2}, {3, 4}};
    System.out.println("Test 1: " + countComponents(V1, edges1)); // Expected: 2

    // Test 2: 4 vertices, 1 component (fully connected)
    int V2 = 4;
    int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {0, 3}};
    System.out.println("Test 2: " + countComponents(V2, edges2)); // Expected: 1

    // Test 3: 4 vertices, 4 components (no edges)
    int V3 = 4;
    int[][] edges3 = {};
    System.out.println("Test 3: " + countComponents(V3, edges3)); // Expected: 4

    System.out.println("\n--- Complete Connected Components ---");
    // Test 4: 6 vertices. Components: {0,1,2} (complete), {3,4} (complete), {5} (complete)
    int V4 = 6;
    int[][] edges4 = {{0, 1}, {0, 2}, {1, 2}, {3, 4}};
    System.out.println("Test 4: " + completeComponents_bfs(V4, edges4)); // Expected: 3

    // Test 5: 6 vertices. Components: {0,1,2} (complete), {3,4,5} (not complete, missing 4-5)
    int V5 = 6;
    int[][] edges5 = {{0, 1}, {0, 2}, {1, 2}, {3, 4}, {3, 5}};
    System.out.println("Test 5: " + completeComponents_bfs(V5, edges5)); // Expected: 1
  } 
  
  public static int countComponents(int V, int[][] edges){
    
    List<List<Integer>> adj = new ArrayList<>();
    for(int i = 0; i < V; i++){
      adj.add(new ArrayList<>());
    }
    for(int[] edge: edges){
      adj.get(edge[0]).add(edge[1]);
      adj.get(edge[1]).add(edge[0]);
    }

    boolean[] visited = new boolean[V];

    int components = 0;
    for(int i = 0; i < V; i++){
      if(!visited[i]){
        components++;
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visited[i] = true;

        while(!q.isEmpty()){
          int node = q.poll();

          for(int neighbor: adj.get(node)){
            if(!visited[neighbor]){
              visited[neighbor] = true;
              q.offer(neighbor);
            }
          }
        }
      }
    }
    return components;
  }

  public static int completeComponents_bfs(int V, int[][] edges){
    
    List<List<Integer>> adj = new ArrayList<>();
    for(int i = 0; i < V; i++){
      adj.add(new ArrayList<>());
    }
    for(int[] edge: edges){
      adj.get(edge[0]).add(edge[1]);
      adj.get(edge[1]).add(edge[0]);
    }

    boolean[] visited = new boolean[V];

    int components = 0;
    for(int i = 0; i < V; i++){
      if(!visited[i]){
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visited[i] = true;
        int vertices = 0;
        int edgesCount = 0;

        while(!q.isEmpty()){
          int node = q.poll();
          vertices++;
          edgesCount += adj.get(node).size();

          for(int neighbor: adj.get(node)){
            if(!visited[neighbor]){
              visited[neighbor] = true;
              q.offer(neighbor);
            }
          }
        }
        if(edgesCount == vertices*(vertices - 1)){
          components++;
        }
      }
    }
    return components;
  }
  
  // TODO: I will add completeComponents through dfs later.
  public static int completeComponents_dfs(int V, int[][] edges) {
      // Placeholder for future DFS implementation
      return 0;
  }
}