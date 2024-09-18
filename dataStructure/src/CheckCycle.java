import java.util.ArrayList;
import java.util.List;

//src == source vertex;
// dest == destination vertex;

public class CheckCycle {

    static class Graph {         // structure of the graph using adjacency list
        private int vertices;    // stores the number of vertices in the graph
        private List<List<Integer>> adjList; //2D list // each element is a list representing the adjacency list for a particular vertex

        // Constructor to initialize graph
        public Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>();  //Initializes the adjList as an empty list of lists
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>()); //For each vertex, an empty adjacency list (ArrayList<Integer>) is added to the adjList. This initializes the adjacency list for each vertex.
            }
        }

        // Method to add an edge between two vertices (undirected)
        public void addEdge(int src, int dest) {
            adjList.get(src).add(dest);  //This method adds an edge between two vertices src and dest in the graph.
            adjList.get(dest).add(src); // Since the graph is undirected, this line adds src to the adjacency list of dest, indicating a bidirectional edge
        }

        // Helper method to perform DFS and detect cycle
        private boolean dfs(int node, boolean[] visited, int parent) {
            //Parameters:
            //int node: The current vertex being visited.
            //boolean[] visited: A boolean array that keeps track of whether a vertex has been visited.
            //int parent: The parent vertex from which the current vertex was reached.

            // Mark the current node as visited
            visited[node] = true;

            // Loop through all adjacent vertices
            for (Integer neighbor : adjList.get(node)) {

                // If the neighbor is not visited, recursively visit it
                if (!visited[neighbor]) {
                    if (dfs(neighbor, visited, node)) {
                        return true;      //If a cycle is detected in the DFS traversal, the method returns true.
                    }
                }

                // If the neighbor is visited and is not the parent of the current node, there's a cycle
                else if (neighbor != parent) {
                    return true;
                }
            }
            return false;   //If no cycle is detected after visiting all the neighbors of the current node, the method returns false.
        }

        // Main method to check if the graph contains a cycle
        public boolean containsCycle() {
            // Array to keep track of visited vertices
            boolean[] visited = new boolean[vertices];  //initially false (no vertex have been visited)

            // Check each unvisited node (needed for disconnected components)
            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {  //If a vertex hasn't been visited, it starts a DFS from that vertex.

                    // If a cycle is found in the DFS, return true
                    if (dfs(i, visited, -1)) {
                        return true;
                    }
                }
            }
            return false;   //no cycle
        }
    }

    public static void main(String[] args) {
        // Example usage:
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0); // Adding a cycle here

        if (graph.containsCycle()) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph does not contain a cycle.");
        }
    }
}
