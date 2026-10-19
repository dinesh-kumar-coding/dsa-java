# Step 15 — Graphs: problems on breadth-first and depth-first search

Full notes for every problem in this folder. Status and revisit dates are tracked in [PROGRESS.md](../../../PROGRESS.md).

Below, V is the number of vertices and E is the number of edges. In the grid problems, M is the number of rows, N is the number of columns, and a cell's neighbours are the cells directly above, below, left and right of it unless the problem says otherwise. Most grid methods list those four moves in two small arrays of row changes and column changes, so a single loop can visit every neighbour.

## Number of provinces
**File:** [NumberOfProvinces.java](NumberOfProvinces.java), methods `noOfProvinces` and `dfs`

**Question.** Cities are given as an adjacency matrix, where a 1 in row i and column j means cities i and j are directly connected. A province is a group of cities connected directly or through other cities. Count the provinces (LeetCode 547).

**Optimal — depth-first search on the adjacency matrix.** The method loops over every city. Each city that has not been visited yet must belong to a province that has not been counted yet, so the count goes up by one and a depth-first search marks every city reachable from it. To find a city's neighbours, the search reads that city's whole row of the matrix and follows every 1 that leads to an unvisited city.

- **Time:** O(V²) — every city's row of V cells is read exactly once.
- **Extra space:** O(V) for the visited array and the call stack.

**Remember:** this is the connected-components count in disguise. Because the graph arrives as a matrix, listing one city's neighbours costs a whole row, which is why the time is O(V²) instead of O(V + E).

## Number of islands
**File:** [NumberOfIslands.java](NumberOfIslands.java), methods `noOfIslands_8Directions` and `noOfIslands_4Directions`

**Question.** Count the islands in a grid of '1' (land) and '0' (water). In the GeeksforGeeks version, land cells touching in any of the 8 directions, diagonals included, belong to the same island. In the LeetCode version (LeetCode 200), only the 4 directions up, down, left and right count.

**Optimal — breadth-first search from every unvisited land cell, in 8 directions.** The method scans the grid row by row. Each land cell not visited yet starts a new island, so the count goes up by one and a breadth-first search marks the whole island, keeping (row, column) pairs in its queue. Two nested loops, each running from −1 to 1, produce every combination of row change and column change, which covers all 8 neighbours; the combination 0, 0 is the cell itself, which is already visited and therefore skipped.

- **Time:** O(M × N) — every cell is queued at most once and looks at 8 neighbours.
- **Extra space:** O(M × N) for the visited grid and, in the worst case, the queue.

**Optimal — the same search in 4 directions.** Identical, except the neighbours come from the two arrays of row and column changes, which list up, right, down and left.

- **Time:** O(M × N).
- **Extra space:** O(M × N).

**Remember:** check that a neighbour is inside the grid *before* reading its value; the conditions are joined with `&&`, so putting the bounds checks first means an out-of-range cell is never touched. Mark a cell as visited when it is added to the queue, not when it is taken out.

## Rotting oranges
**File:** [RottenOranges.java](RottenOranges.java), method `orangesRotting`

**Question.** In a grid, 0 is an empty cell, 1 is a fresh orange and 2 is a rotten orange. Every minute, each rotten orange rots the fresh oranges directly above, below, left and right of it. Return the number of minutes until no fresh orange is left, or −1 if some orange can never rot (LeetCode 994).

**Optimal — multi-source breadth-first search, one level per minute.** One pass over the grid puts every rotten orange into the queue and counts the fresh ones. Each round of the main loop then handles exactly the oranges that were in the queue when the round began, which is one minute of rotting. Every fresh neighbour is turned into a 2 straight away, the fresh count goes down by one, and the orange joins the queue for the next minute. The loop stops when the queue is empty or no fresh oranges are left. The answer is the number of rounds if the fresh count reached zero, and −1 otherwise.

- **Time:** O(M × N).
- **Extra space:** O(M × N) for the queue; changing the grid itself doubles as the visited marker.

**Remember:** all the rotten oranges spread at the same time, so they must all start in the queue together at minute 0; spreading from one rotten orange at a time would let it claim oranges that another rotten orange reaches sooner. Stop as soon as nothing fresh remains, or the loop counts one extra minute after the last orange has rotted. Changing the grid in place destroys the input, so copy it first if the original is still needed.

## Flood fill
**File:** [FloodFill.java](FloodFill.java), method `floodFill`

**Question.** Starting from one pixel of an image, recolour that pixel and every pixel connected to it, up, down, left or right, that has the same original colour (LeetCode 733).

**Optimal — breadth-first search from the starting pixel.** The method remembers the starting pixel's original colour, paints the starting pixel with the new colour and puts it in a queue. Each pixel taken out of the queue looks at its four neighbours, and any neighbour still holding the original colour is painted and queued. Painting a pixel at the moment it is queued also marks it as visited, so no separate visited grid is needed. The whole search sits inside a check that the new colour is different from the original one.

- **Time:** O(M × N) in the worst case, when every pixel shares the starting colour.
- **Extra space:** O(M × N) for the queue.

**Remember:** if the new colour equals the original colour, painting a pixel changes nothing, so painted pixels still look unvisited and the search keeps queueing the same pixels forever. Check for that case first and return the image unchanged.

## Detect a cycle in an undirected graph using breadth-first search
**File:** [DetectCycleInUndirectedGraph_BFS.java](DetectCycleInUndirectedGraph_BFS.java), methods `isCycle` and `checkForCycle`

**Question.** Return whether an undirected graph contains a cycle.

**Optimal — breadth-first search that remembers where each vertex came from.** The method starts a breadth-first search from every vertex not visited yet, so every component is checked. The queue holds pairs of a vertex and its parent, the vertex it was reached from. An unvisited neighbour is marked and queued with the current vertex as its parent. A neighbour that is already visited and is not the parent has been reached by a second, different route, so the graph has a cycle.

- **Time:** O(V + E).
- **Extra space:** O(V) for the visited array and the queue.

**Remember:** in an undirected graph every edge appears in both vertices' lists, so the vertex you just came from always looks visited. Ignoring exactly the parent stops a single edge from being mistaken for a cycle. This parent trick only works for undirected graphs.

## Detect a cycle in an undirected graph using depth-first search
**File:** [DetectCycleInUndirectedGraph_DFS.java](DetectCycleInUndirectedGraph_DFS.java), methods `isCycle` and `checkForCycle`

**Question.** Return whether an undirected graph contains a cycle.

**Optimal — depth-first search that passes the parent down.** The same idea as the breadth-first version, with recursion: each call receives the vertex it came from. An unvisited neighbour is explored with a recursive call, and if that call finds a cycle, the answer is returned straight back up. A visited neighbour that is not the parent closes a cycle. The outer loop again starts a search from every unvisited vertex, and each search starts with a parent of −1, which can never match a real vertex.

- **Time:** O(V + E).
- **Extra space:** O(V) for the visited array and the call stack.

**Remember:** return the recursive call's answer as soon as it is true. Calling it and ignoring the result throws away the cycle it found.

## Distance of the nearest cell having 1
**File:** [NearestCell.java](NearestCell.java), method `nearest`

**Question.** For every cell in a grid of 0s and 1s, find the distance to the nearest cell holding 1, where one step moves up, down, left or right. LeetCode 542, "01 Matrix", asks the same question about the nearest 0.

**Optimal — multi-source breadth-first search from every 1.** Every cell holding 1 goes into the queue first, with a distance of 0, and is marked visited. Each cell taken out of the queue writes its distance into the answer grid, then queues every unvisited neighbour with a distance one greater. Breadth-first search hands out cells in order of distance, so the first time a cell is reached, it is reached from its nearest 1.

- **Time:** O(M × N).
- **Extra space:** O(M × N) for the visited grid, the answer grid and the queue.

**Remember:** starting from all the 1s together replaces one search per cell with a single search. Running a separate search outwards from every 0 is the brute force, and it costs O((M × N)²).

## Surrounded regions
**File:** [SurroundedRegions.java](SurroundedRegions.java), methods `fill` and `dfs`

**Question.** In a board of 'X' and 'O', replace every 'O' that is completely surrounded by 'X' with 'X'. An 'O' survives if it is on the border, or connected up, down, left or right to an 'O' that survives (LeetCode 130).

**Optimal — depth-first search from the border, then flip the rest.** Instead of asking whether each region can escape, the method marks everything that can. It walks the first row, the last row, the first column and the last column, and from every border 'O' it runs a depth-first search that marks all the 'O's connected to it. Any 'O' left unmarked after that cannot reach the border, so a final pass over the board turns it into 'X'.

- **Time:** O(M × N).
- **Extra space:** O(M × N) for the visited grid and the call stack.

**Remember:** thinking in reverse, "which cells are safe" instead of "which cells are trapped", turns a hard question about every region into one search from the border. The border walks overlap at the four corners, and the visited check stops a corner from being searched twice.

## Number of enclaves
**File:** [NumberOfEnclaves.java](NumberOfEnclaves.java), methods `numEnclaves` and `dfs`

**Question.** In a grid of 0 (sea) and 1 (land), count the land cells from which you cannot walk off the edge of the grid, moving only up, down, left or right through land (LeetCode 1020).

**Optimal — depth-first search from the border, then count the rest.** The same reverse thinking as surrounded regions: a depth-first search from every land cell on the border marks all the land that can reach the edge. Every land cell left unmarked is trapped, and a final pass counts them.

- **Time:** O(M × N).
- **Extra space:** O(M × N) for the visited grid and the call stack.

**Remember:** the answer counts cells, not islands, so the final pass adds one for every unmarked land cell rather than one for each group of them.

## Word ladder I
**File:** [WordLadder_I.java](WordLadder_I.java), method `wordLadder_I`

**Question.** Given a start word, a target word and a word list, change one letter at a time so that every word along the way is in the list. Return the number of words in the shortest such sequence, counting both ends, or 0 if the target cannot be reached (LeetCode 127).

**Optimal — breadth-first search over words.** Every word is a vertex, and two words are joined when they differ in exactly one letter, but the method never builds that graph. The word list goes into a hash set, and the start word is removed from it. The queue holds pairs of a word and the length of the sequence so far, starting with the start word at length 1. When the word taken out of the queue is the target, its length is the answer. Otherwise every position of the word is tried with every letter from 'a' to 'z', and each new word found in the set is removed from the set and queued with a length one greater.

- **Time:** O(N × L² × 26), where N is the number of words in the list and L is the length of each word — every word is processed once and tries 26 letters at each of its L positions, and building and looking up each new word costs O(L).
- **Extra space:** O(N × L) for the set and the queue.

**Remember:** remove a word from the set at the moment it is queued, not when it is processed. That removal is the visited marker: breadth-first search reaches every word first along a shortest route, so no later route can do better. Removing the start word up front stops the search from queueing it a second time.

## Detect a cycle in a directed graph using depth-first search
**File:** [DetectCycleInDirectedGraph_DFS.java](DetectCycleInDirectedGraph_DFS.java), methods `detectCycle` and `dfs`

**Question.** Return whether a directed graph contains a cycle. Here the edges arrive as (course, prerequisite) pairs, as in the course-schedule problems, so every edge points from the prerequisite to the course.

**Optimal — depth-first search with a visited array and a path-visited array.** The method builds the adjacency list with every edge pointing from prerequisite to course, then starts a depth-first search from each unvisited vertex. It keeps two arrays. The visited array marks every vertex ever explored. The path-visited array marks only the vertices on the current chain of recursive calls. Reaching a neighbour that is on the current path means the edges have led back to an earlier vertex of that same path, which is a cycle. When a call finishes, its vertex is taken off the path again.

- **Time:** O(V + E).
- **Extra space:** O(V + E) for the adjacency list, the two arrays and the call stack.

**Remember:** in a directed graph, reaching an already visited vertex does not prove a cycle, because two separate paths can lead into the same vertex without any loop; only a vertex still on the current path closes one. Forgetting to unmark the path when a call finishes reports cycles that do not exist.

## Detect a cycle in a directed graph using breadth-first search
**File:** [DetectCycleInDirectedGraph_BFS.java](DetectCycleInDirectedGraph_BFS.java), method `detectCycle`

**Question.** Return whether a directed graph contains a cycle, using breadth-first search.

**Optimal — Kahn's algorithm, counting the vertices it can place.** The indegree of a vertex is the number of edges pointing into it. The method counts every indegree, queues every vertex whose indegree is 0, and then repeatedly takes a vertex out, counts it, and lowers the indegree of each of its neighbours, queueing any that reach 0. A vertex on a cycle always has an edge coming in from another vertex of the same cycle, so its indegree never reaches 0 and it is never placed. If fewer than V vertices are placed, the graph has a cycle.

- **Time:** O(V + E).
- **Extra space:** O(V) for the indegrees and the queue.

**Remember:** this is topological sort with the order thrown away and only the count kept. Every vertex with an indegree of 0 must be queued at the start, from every component; starting from a single vertex misses the rest of the graph.

## Bipartite graph
**File:** [BipartiteGraph.java](BipartiteGraph.java), methods `isBipartite`, `dfs` and `isBipartite_bfs`

**Question.** Return whether the vertices of an undirected graph can be coloured with two colours so that no edge joins two vertices of the same colour (LeetCode 785).

**Optimal — two-colouring with depth-first search.** Every vertex starts uncoloured, stored as −1. From each uncoloured vertex, the search gives it colour 0 and gives every uncoloured neighbour the opposite colour, 1 minus the current one, recursively. A neighbour that already has the same colour as the current vertex makes two-colouring impossible, and that false is returned all the way up.

- **Time:** O(V + E).
- **Extra space:** O(V) for the colours and the call stack.

**Optimal — two-colouring with breadth-first search.** The same rule with a queue: each vertex taken out gives every uncoloured neighbour the opposite colour and queues it, and a neighbour that already holds the same colour makes the method return false.

- **Time:** O(V + E).
- **Extra space:** O(V) for the colours and the queue.

**Remember:** a graph is bipartite exactly when it has no cycle of odd length, so trees and graphs whose cycles are all even always pass. Loop over every vertex, because the odd cycle may sit in a component that a search from vertex 0 never reaches.
