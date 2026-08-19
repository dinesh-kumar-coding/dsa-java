/*
 * Problem: Number of Provinces — Optimal: DFS on Adjacency Matrix
 * Solved: 19-08-2026 | TC: O(V^2) | SC: O(V)
 * Revisit: [date]
 */

public class NumberOfProvinces {
  public static void main(String[] args){
    // Test 1: 3 cities, 2 provinces: {0,1} and {2}
    int[][] matrix1 = {
      {1, 1, 0},
      {1, 1, 0},
      {0, 0, 1}
    };
    System.out.println("Test 1: " + noOfProvinces(matrix1)); // Expected: 2

    // Test 2: 3 cities, 3 provinces: {0}, {1}, {2}
    int[][] matrix2 = {
      {1, 0, 0},
      {0, 1, 0},
      {0, 0, 1}
    };
    System.out.println("Test 2: " + noOfProvinces(matrix2)); // Expected: 3

    // Test 3: 4 cities, 1 province (fully connected chain)
    int[][] matrix3 = {
      {1, 1, 0, 0},
      {1, 1, 1, 0},
      {0, 1, 1, 1},
      {0, 0, 1, 1}
    };
    System.out.println("Test 3: " + noOfProvinces(matrix3)); // Expected: 1
  }

  public static int noOfProvinces(int[][] edges){
    int n = edges.length;
    boolean[] vis = new boolean[n];
    int components = 0;
    for(int i = 0; i < n; i++){
      if(!vis[i]){
        components++;
        dfs(i, vis, edges);
      }
    }
    return components;
  }

  public static void dfs(int node, boolean[] vis, int[][] edges){
    vis[node] = true;
    for(int i = 0; i < edges[node].length; i++){
      if(edges[node][i] == 1 && !vis[i]){
        dfs(i, vis, edges);
      }
    }
  }
}