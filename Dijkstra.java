package Graph;

import java.util.Arrays;

class Dijkstra {
    private int vertices; // Number of vertices
    private int[][] adjacencyMatrix; // Adjacency matrix to represent the graph

    // Constructor
    public Dijkstra(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
        // Initialize all edges to "infinity" (no connection), except self-loops
        for (int i = 0; i < vertices; i++) {
            Arrays.fill(adjacencyMatrix[i], Integer.MAX_VALUE);
            adjacencyMatrix[i][i] = 0; // Distance to itself is 0
        }
    }

    // Add edges to the graph
    public void addEdge(int src, int dest, int weight) {
        adjacencyMatrix[src][dest] = weight;
        adjacencyMatrix[dest][src] = weight; // For undirected graphs
    }

    // Dijkstra's algorithm to find the shortest path
    public void dijkstra(int source) {
        int[] distances = new int[vertices]; // Stores the shortest distances from source
        boolean[] visited = new boolean[vertices]; // Tracks visited vertices

        // Initialize distances to "infinity" and visited to false
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0; // Distance to the source itself is 0

        // Loop to find the shortest path for all vertices
        for (int i = 0; i < vertices - 1; i++) {
            // Find the unvisited vertex with the smallest distance
            int u = getMinDistanceVertex(distances, visited);
            visited[u] = true; // Mark this vertex as visited

            // Update distances of adjacent vertices of the picked vertex
            for (int v = 0; v < vertices; v++) {
                // Update distances[v] if:
                // 1. v is not visited
                // 2. There is an edge from u to v
                // 3. Total weight of path from source to v through u is smaller
                if (!visited[v] && adjacencyMatrix[u][v] != Integer.MAX_VALUE 
                    && distances[u] != Integer.MAX_VALUE 
                    && distances[u] + adjacencyMatrix[u][v] < distances[v]) {
                    distances[v] = distances[u] + adjacencyMatrix[u][v];
                }
            }
        }

        // Print the shortest distances
        printSolution(distances, source);
    }

    // Helper method to find the vertex with the minimum distance value
    private int getMinDistanceVertex(int[] distances, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < vertices; v++) {
            if (!visited[v] && distances[v] < minDistance) {
                minDistance = distances[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Helper method to print the solution
    private void printSolution(int[] distances, int source) {
        System.out.println("Shortest paths from node " + source + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("To node " + i + " is " + distances[i]);
        }
    }

    // Main method
    public static void main(String[] args) {
        Dijkstra graph = new Dijkstra(6); // Create a graph with 6 nodes
        // Add edges and weights
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 5, 1);

        int source = 0; // Define the source node
        graph.dijkstra(source); // Run Dijkstra's algorithm
    }
}
