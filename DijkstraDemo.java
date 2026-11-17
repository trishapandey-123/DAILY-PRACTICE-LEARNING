import java.util.*;

public class DijkstraDemo {

    // Helper class representing a weighted edge to a neighbor
    static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    // Helper class for the PriorityQueue to sort vertices by shortest known distance
    static class NodeDistance implements Comparable<NodeDistance> {
        int vertex;
        int distance;

        NodeDistance(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(NodeDistance other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    private Map<Integer, List<Edge>> adjList = new HashMap<>();

    // Add a weighted edge between source and destination
    public void addEdge(int source, int destination, int weight, boolean isDirected) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(destination, new ArrayList<>());

        adjList.get(source).add(new Edge(destination, weight));
        if (!isDirected) {
            adjList.get(destination).add(new Edge(source, weight));
        }
    }

    // Dijkstra's Algorithm: Returns a map of shortest distances from startVertex
    public Map<Integer, Integer> shortestPaths(int startVertex) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<NodeDistance> pq = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();

        // Initialize all distances to infinity
        for (int vertex : adjList.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(startVertex, 0);
        pq.add(new NodeDistance(startVertex, 0));

        while (!pq.isEmpty()) {
            NodeDistance current = pq.poll();
            int u = current.vertex;

            // Skip if we have already finalized the shortest path to this vertex
            if (visited.contains(u)) continue;
            visited.add(u);

            for (Edge edge : adjList.getOrDefault(u, Collections.emptyList())) {
                int v = edge.target;
                int newDist = distances.get(u) + edge.weight;

                // Edge Relaxation: update distance if a shorter path is found
                if (!visited.contains(v) && newDist < distances.get(v)) {
                    distances.put(v, newDist);
                    pq.add(new NodeDistance(v, newDist));
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        DijkstraDemo graph = new DijkstraDemo();

        /* Constructing a weighted undirected graph:
               (0) ---4--- (1)
                |         / | \
                8        2  5  10
                |       /   |   \
               (7) ---1--- (2) --3-- (3)
        */
        graph.addEdge(0, 1, 4, false);
        graph.addEdge(0, 7, 8, false);
        graph.addEdge(1, 2, 2, false);
        graph.addEdge(1, 7, 11, false);
        graph.addEdge(1, 3, 10, false);
        graph.addEdge(2, 7, 1, false);
        graph.addEdge(2, 3, 3, false);

        int startNode = 0;
        Map<Integer, Integer> shortestDistances = graph.shortestPaths(startNode);

        System.out.println("Shortest distances from Vertex " + startNode + ":");
        for (Map.Entry<Integer, Integer> entry : shortestDistances.entrySet()) {
            System.out.println("  To Vertex " + entry.getKey() + " -> Cost: " + entry.getValue());
        }
    }
}
