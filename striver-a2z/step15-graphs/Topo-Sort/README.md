# Step 15 — Graphs: topological sort

Full notes for every problem in this folder. Status and revisit dates are tracked in [PROGRESS.md](../../../PROGRESS.md).

Below, V is the number of vertices and E is the number of edges.

## Topological sort
**File:** [TopoSort.java](TopoSort.java), methods `topoSort`, `dfs` and `topoSort_kahnsAlgorithm`

**Question.** Order the vertices of a directed acyclic graph so that for every edge from u to v, u comes before v.

**Optimal — depth-first search, pushing each vertex once it is finished.** The method runs a depth-first search from every unvisited vertex. A vertex is pushed onto a stack only after the search has finished exploring everything reachable from it, so every vertex lands on the stack after all the vertices that must come after it. Popping the stack therefore gives a valid order.

- **Time:** O(V + E).
- **Extra space:** O(V) for the visited array, the stack and the call stack.

**Optimal — Kahn's algorithm, a breadth-first search on indegrees.** The indegree of a vertex is the number of edges pointing into it. The method counts every indegree, puts every vertex with an indegree of zero into a queue, and repeatedly takes a vertex out, adds it to the order, and lowers the indegree of each of its neighbours by one; a neighbour whose indegree reaches zero has no remaining prerequisites, so it joins the queue.

- **Time:** O(V + E).
- **Extra space:** O(V) for the indegrees, the queue and the result.

**Remember:** a graph usually has many valid topological orders, so the two methods can print different answers that are both correct; check an answer by confirming that every edge points forwards. A topological order only exists when the graph has no cycle, and Kahn's algorithm can detect one: if fewer than V vertices are placed, the rest are stuck in a cycle. That is exactly how [detecting a cycle in a directed graph using breadth-first search](../Problems-On-BFS-DFS/README.md#detect-a-cycle-in-a-directed-graph-using-breadth-first-search) works.
