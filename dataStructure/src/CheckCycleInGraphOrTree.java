import java.util.*;

public class CheckCycleInGraphOrTree {

    // Helper method to detect a cycle in the graph
    static boolean isCyclic(int v, List<List<Integer>> adj, boolean[] visited, int parent) {
        // Mark the current vertex as visited
        visited[v] = true;

        // Explore all adjacent vertices of the current vertex
        for (int i : adj.get(v)) {
            // If the adjacent vertex is not visited, recursively check for a cycle
            if (!visited[i]) {
                if (isCyclic(i, adj, visited, v))
                    return true;
            }
            // If the adjacent vertex is visited and it's not the parent, a cycle is detected
            else if (i != parent)
                return true;
        }
        // No cycle detected from this vertex
        return false;
    }

    // Method to check if the entire graph contains a cycle
    static boolean isCyclicCheck(int V, List<List<Integer>> adj) {
        // Create a boolean array to keep track of visited vertices
        boolean[] visited = new boolean[V];

        // Check each vertex in the graph
        for (int i = 0; i < V; i++) {
            // If the vertex is not visited, start a cycle check from it
            if (!visited[i]) {
                if (isCyclic(i, adj, visited, -1))
                    return true; // Cycle found
            }
        }
        // No cycle found in any component of the graph
        return false;
    }

    public static void main(String[] args) {
        // Number of vertices in the graph
        int V = 3;

        // Initialize the adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the adjacency list
        adj.get(1).add(0); // Edge from vertex 1 to 0
        adj.get(0).add(1); // Edge from vertex 0 to 1 (undirected)
        adj.get(0).add(2); // Edge from vertex 0 to 2
        adj.get(2).add(0); // Edge from vertex 2 to 0 (undirected)
        adj.get(1).add(2); // Edge from vertex 1 to 2
        adj.get(2).add(1); // Edge from vertex 2 to 1 (undirected)

        // Check if the graph contains a cycle and print the result
        System.out.println(isCyclicCheck(V, adj) ? "Contains cycle" : "No Cycle");
    }
}
