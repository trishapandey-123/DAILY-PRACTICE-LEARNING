import java.util.*;

public class GraphDemo {

    // Adjacency List representation: maps each vertex to its list of neighbors
    private Map<Integer, List<Integer>> adjList;
    private boolean isDirected;

    public GraphDemo(boolean isDirected) {
        this.adjList = new HashMap<>();
        this.isDirected = isDirected;
    }

    // Add a vertex to the graph
    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Add an edge between source and destination
    public void addEdge(int source, int destination) {
        addVertex(source);
        addVertex(destination);

        adjList.get(source).add(destination);

        // If undirected, add the reverse edge as well
        if (!isDirected) {
            adjList.get(destination).add(source);
        }
    }

    // 1. Breadth-First Search (BFS) - Level-by-level traversal using a Queue
    public void bfs(int startVertex) {
        if (!adjList.containsKey(startVertex)) return;

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);

        System.out.print("BFS Traversal starting from " + startVertex + ": ");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // 2. Depth-First Search (DFS) - Explores as deep as possible before backtracking
    public void dfs(int startVertex) {
        if (!adjList.containsKey(startVertex)) return;

        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS Traversal starting from " + startVertex + ": ");
        dfsRecursive(startVertex, visited);
        System.out.println();
    }

    private void dfsRecursive(int current, Set<Integer> visited) {
        visited.add(current);
        System.out.print(current + " ");

        for (int neighbor : adjList.get(current)) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    // Print the entire adjacency list
    public void printGraph() {
        System.out.println("Graph Adjacency List:");
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.println("  Vertex " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Create an undirected graph
        GraphDemo graph = new GraphDemo(false);

        /* Constructing the following Graph:
               0 --- 1
               |     | \
               |     |  2
               |     | /
               4 --- 3
        */
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();
        System.out.println();

        graph.bfs(0); // 0 1 4 2 3
        graph.dfs(0); // 0 1 2 3 4
    }
}
