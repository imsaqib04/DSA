import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public static class Edge implements Comparable<Edge>{
    int wt;
    int source;
    int dest;


    Edge(int wt, int soure, int dest) {
        this.wt =wt;
        this.source = soure;
        this.dest = dest;
    }

    @Override
    public int compareTo(Edge other) {
        return this.wt - other.wt;
    }
}

public void main(String[] args) {

    List <Edge> [] graph = new ArrayList [5];

    for (int i = 0; i < graph.length; i++) {
        graph[i] = new ArrayList<>();
    }


    graph[0].add(new Edge(10, 0, 1));
    graph[0].add(new Edge(5, 0, 2));
    graph[1].add(new Edge(4, 1, 2));
    graph[1].add(new Edge(7, 1, 3));
    graph[2].add(new Edge(8, 2, 3));
    graph[2].add(new Edge(1, 2, 4));
    graph[3].add(new Edge(3, 3, 4));
    graph[4].add(new Edge(15, 4, 0));
    primsAlgo ( graph );
}

public void primsAlgo(List<Edge>[] graph){

    boolean[] visit = new boolean[graph.length];
    PriorityQueue <Edge> priorityQueue = new PriorityQueue<> ();
        int start =0;
        priorityQueue.add ( new Edge (0,start,start ) );

        int answer = 0;

        while(!priorityQueue.isEmpty ()) {

            Edge current = priorityQueue.poll ();

            int vertex = current.dest;

            if (visit[vertex]) {
                continue;
            }

            answer = answer + current.wt;
            visit[vertex] = true;

            for (int i = 0; i < graph[vertex].size (); i++) {

                Edge edge = (Edge) graph[vertex].get ( i );

                if (!visit[edge.dest]) {
                    priorityQueue.add ( edge );
                }
            }

        }

    System.out.println ("weight : " + answer);

}