# Step 15 — Graphs: learning the basics

Full notes for every problem in this folder. Status and revisit dates are tracked in [PROGRESS.md](../../../PROGRESS.md).

A graph is a set of nodes, often called vertices, joined by edges. Below, V is the number of vertices and E is the number of edges. In an undirected graph every edge can be travelled both ways, so it is stored in both directions.

## Graph representation with an adjacency matrix
**File:** [AdjacencyMatrix.java](AdjacencyMatrix.java) and [AdjacencyMatrixWeighted.java](AdjacencyMatrixWeighted.java), method `main` in each

**Question.** Read a graph's vertices and edges and store it so that any pair of vertices can be checked for an edge.

**Approach — a V × V grid.** Both programs read the number of vertices and edges and create a square grid with one row and one column per vertex, numbered from 1, so the grid has one spare row and column at index 0. For every undirected edge between u and v, the cell in row u and column v and the cell in row v and column u are both filled in: with 1 in the unweighted version, and with the edge's weight in the weighted one.

- **Time:** O(V²) to create the grid, plus O(1) per edge; checking whether one edge exists takes O(1).
- **Extra space:** O(V²), however few edges there are.

**Remember:** a matrix suits dense graphs, where most pairs of vertices are connected. For a sparse graph it wastes almost all of its space, and listing a vertex's neighbours still means scanning a whole row of V cells.

## Graph representation with an adjacency list
**File:** [AdjacencyList.java](AdjacencyList.java) and [AdjacencyListWeighted.java](AdjacencyListWeighted.java), method `main` in each

**Question.** Store a graph so that the neighbours of every vertex can be listed quickly, without wasting space on missing edges.

**Approach — one list of neighbours per vertex.** Both programs create an array with one list per vertex. For every undirected edge between u and v, v is added to u's list and u is added to v's list. In the weighted version, each entry is a pair holding the neighbour and the weight of the edge.

- **Time:** O(V + E) to build.
- **Extra space:** O(V + E) — every undirected edge is stored twice, once in each direction.

**Remember:** an adjacency list is the default choice for most graph problems, because traversals only ever need "the neighbours of this vertex", and the list hands them over directly. Checking whether one particular edge exists, on the other hand, means searching a list.

## Breadth-first search of a graph
**File:** [Traversals.java](Traversals.java), method `bfsOfGraph`

**Question.** Visit every vertex reachable from vertex 0 level by level: the start first, then all its neighbours, then their neighbours, and so on.

**Approach — a queue, one level at a time.** The start vertex is marked visited and put into a queue. Repeatedly, the vertex at the front of the queue is taken out and recorded, and every neighbour that has not been visited yet is marked visited and added to the back of the queue. Because the queue hands vertices out in the order they were added, all vertices one edge away come out before any vertex two edges away.

- **Time:** O(V + E) — every vertex is queued once and every edge is looked at a constant number of times.
- **Extra space:** O(V) for the queue and the visited array.

**Remember:** mark a vertex as visited when it is *added* to the queue, not when it is taken out. Marking it later lets the same vertex be added several times by different neighbours. This method starts only from vertex 0, so a graph in several disconnected pieces needs an outer loop over every vertex.

## Depth-first search of a graph
**File:** [Traversals.java](Traversals.java), methods `dfsOfGraph` and `dfs`

**Question.** Visit every vertex reachable from vertex 0 by going as deep as possible along each path before backing up.

**Approach — recursion.** The recursive helper marks the current vertex visited, records it, and then calls itself on each neighbour that has not been visited yet. A call only returns once everything reachable through that neighbour has been explored, which is what makes the search go deep first.

- **Time:** O(V + E).
- **Extra space:** O(V) for the visited array and the call stack, which can be as deep as the number of vertices.

**Remember:** the order of the neighbour lists decides the visiting order, so two correct depth-first searches can print different sequences. On a very long chain of vertices, the recursion can go deep enough to overflow the call stack; an explicit stack avoids that.

## Number of connected components
**File:** [ConnectedComponents.java](ConnectedComponents.java), methods `countComponents_bfs`, `countComponents_dfs` and `countComponents_dfs_helper`

**Question.** Count the separate pieces of an undirected graph, where every vertex in a piece can reach every other vertex in it.

**Optimal — breadth-first search from every unvisited vertex.** After building an adjacency list from the edges, the method loops over every vertex. Each vertex not yet visited must belong to a piece that has not been counted yet, so the count goes up by one and a breadth-first search from that vertex marks its entire piece as visited.

- **Time:** O(V + E).
- **Extra space:** O(V + E) for the adjacency list, the visited array and the queue.

**Optimal — the same loop with depth-first search.** The same outer loop and count, with a recursive depth-first search marking each piece instead.

- **Time:** O(V + E).
- **Extra space:** O(V + E), including the call stack.

**Remember:** the outer loop over every vertex is what turns a single traversal into a component count. Each new search started from an unvisited vertex is exactly one new component.

## Count the number of complete components
**File:** [ConnectedComponents.java](ConnectedComponents.java), method `completeComponents_bfs`

**Question.** Count the components in which every pair of vertices is joined directly by an edge (LeetCode 2685).

**Optimal — breadth-first search that also adds up the degrees.** For each component, the breadth-first search counts the vertices and adds up the length of every neighbour list it visits, which is the total degree. Every undirected edge is counted twice in that total, and a complete component with K vertices has K × (K − 1) / 2 edges, so the component is complete exactly when the total degree equals K × (K − 1).

- **Time:** O(V + E).
- **Extra space:** O(V + E).

**Not in the file yet:** the depth-first version. A placeholder method exists, but it is not implemented.

**Remember:** comparing the total degree with K × (K − 1) avoids dividing by two entirely. The check assumes there are no repeated edges and no edges from a vertex to itself, which the problem guarantees.
