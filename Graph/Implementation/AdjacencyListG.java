import java.util.ArrayList;
import java.util.List;

public class AdjacencyListG { // Space Complexity = O(V + E)
    List<List<Integer>> adjList;
    int vartices;

    public AdjacencyListG(int v){
        this.vartices = v;
        adjList = new ArrayList<>(); // List index 0,1,2..v
        for(int i=0; i<v; i++){
            adjList.add(new ArrayList<>()); // 0th index's under list // list of lists
        }
    }
    public void addEdge(int u, int v){
        adjList.get(u).add(v);
        adjList.get(v).add(u); // for undirected graph
    }
    public void printGraph(){
        for(int i=0; i < vartices; i++){
            System.out.println(i + "->" + adjList.get(i));
            System.out.println();
        }
    }
    public static void main(String[] args) {
            AdjacencyListG g = new AdjacencyListG(4);
            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 2);
            g.addEdge(2, 3);

           
            g.printGraph();
        }



    //// 

    //   static class Edge {
    //     int src;
    //     int dest;

    //     public Edge(int s, int d){
    //         this.src = s;
    //         this.dest = d;
    //     }
    // }
    // public static void createGraph(ArrayList<Edge> graph[]){
    //     for(int i=0; i<graph.length; i++){
    //         graph[i] = new ArrayList<Edge>();
    //     }

    // // Each index holds a list of edges that originate from that vertex.

    //     graph[0].add(new Edge(0, 2));

    //     graph[1].add(new Edge(1, 2));
    //     graph[1].add(new Edge(1, 3));

    //     graph[2].add(new Edge(2, 0)); // graph[2] holds all edges from vertex 2.
    //     graph[2].add(new Edge(2, 1));
    //     graph[2].add(new Edge(2, 3));

    //     graph[3].add(new Edge(3, 1));
    //     graph[3].add(new Edge(3, 2));
    // }

    // public static void printGraph(ArrayList<Edge> graph[]){
    //     for(int i=0; i<graph.length; i++){
    //         for(Edge e : graph[i]){
    //             System.out.println("From " + e.src + " to " + e.dest);
    //         } // This loops through each vertex’s edge list and prints all the connections.
    //     }
    // }
    // public static void main(String[] args) {
    //     int V = 4;
    //     ArrayList<Edge> graph[] = new ArrayList[V]; // This is an array of ArrayLists like Array of int, str etc..

    //     createGraph(graph);
    //     printGraph(graph);
    // }

}