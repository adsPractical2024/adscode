import java.util.Arrays;

class Dijkstra {
    private int vertices; 
    private int[][] adjacencyMatrix; 

    public Dijkstra(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            Arrays.fill(adjacencyMatrix[i], Integer.MAX_VALUE);
            adjacencyMatrix[i][i] = 0; 
        }
    }

    
    public void addEdge(int src, int dest, int weight) {
        adjacencyMatrix[src][dest] = weight;
        adjacencyMatrix[dest][src] = weight; 
    }

    public void dijkstra(int source) {
        int[] distances = new int[vertices]; 
        boolean[] visited = new boolean[vertices]; 

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0; 

        for (int i = 0; i < vertices - 1; i++) {
            int u = getMinDistanceVertex(distances, visited);
            visited[u] = true;
            
            for (int v = 0; v < vertices; v++) {
                
                if (!visited[v] && adjacencyMatrix[u][v] != Integer.MAX_VALUE 
                    && distances[u] != Integer.MAX_VALUE 
                    && distances[u] + adjacencyMatrix[u][v] < distances[v]) {
                    distances[v] = distances[u] + adjacencyMatrix[u][v];
                }
            }
        }

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

    private void printSolution(int[] distances, int source) {
        System.out.println("Shortest paths from node " + source + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("To node " + i + " is " + distances[i]);
        }
    }

    public static void main(String[] args) {
        Dijkstra graph = new Dijkstra(6);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 5, 1);

        int source = 0; 
        graph.dijkstra(source);
    }
}
