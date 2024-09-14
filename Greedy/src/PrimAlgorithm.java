import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimAlgorithm {

    // Edge class that implements Comparable to enable sorting by weight
    public static class Edge implements Comparable<Edge> {
        int wt;
        int source;
        int dest;

        // Constructor for Edge
        Edge(int wt, int source, int dest) {
            this.wt = wt;
            this.source = source;
            this.dest = dest;
        }

        // Compare edges by weight for the PriorityQueue
        @Override
        public int compareTo(Edge other) {
            return this.wt - other.wt;
        }
    }

    // Prim's Algorithm to find the Minimum Spanning Tree (MST)
    public static void primsAlgo(List<Edge>[] graph) {
        boolean[] visit = new boolean[graph.length];  // Track visited nodes
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        int start = 0;  // Start from vertex 0

        // Add the first edge (weight 0) to begin the process
        priorityQueue.add(new Edge(0, start, start));

        int answer = 0;  // Total weight of the MST

        // While there are edges to process
        while (!priorityQueue.isEmpty()) {
            Edge current = priorityQueue.poll();  // Get the smallest edge

            int vertex = current.dest;

            // If the vertex is already visited, skip it
            if (visit[vertex]) {
                continue;
            }

            // Add the weight of the current edge to the total
            answer += current.wt;
            visit[vertex] = true;  // Mark the vertex as visited

            // Add all edges of the current vertex to the priority queue
            for (Edge edge : graph[vertex]) {
                if (!visit[edge.dest]) {
                    priorityQueue.add(edge);
                }
            }
        }

        // Print the total weight of the MST
        System.out.println("Total weight of the Minimum Spanning Tree: " + answer);
    }

    public static void main(String[] args) {
        int vertices = 5;  // Number of vertices
        List<Edge>[] graph = new ArrayList[vertices];  // Graph as adjacency list

        // Initialize adjacency lists for each vertex
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges for an undirected graph
        graph[0].add(new Edge(10, 0, 1));
        graph[1].add(new Edge(10, 1, 0));  // Reverse edge

        graph[0].add(new Edge(5, 0, 2));
        graph[2].add(new Edge(5, 2, 0));  // Reverse edge

        graph[1].add(new Edge(4, 1, 2));
        graph[2].add(new Edge(4, 2, 1));  // Reverse edge

        graph[1].add(new Edge(7, 1, 3));
        graph[3].add(new Edge(7, 3, 1));  // Reverse edge

        graph[2].add(new Edge(8, 2, 3));
        graph[3].add(new Edge(8, 3, 2));  // Reverse edge

        graph[2].add(new Edge(1, 2, 4));
        graph[4].add(new Edge(1, 4, 2));  // Reverse edge

        graph[3].add(new Edge(3, 3, 4));
        graph[4].add(new Edge(3, 4, 3));  // Reverse edge

        graph[4].add(new Edge(15, 4, 0));
        graph[0].add(new Edge(15, 0, 4));  // Reverse edge

        // Run Prim's Algorithm
        primsAlgo(graph);
    }
}
