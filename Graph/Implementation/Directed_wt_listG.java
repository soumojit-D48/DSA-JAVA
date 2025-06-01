import java.util.ArrayList;
import java.util.List;

public class Directed_wt_listG {
    List<List<Edge>> adjList;
    int vart;

    public Directed_wt_listG(int v){
        this.vart = v;
        adjList = new ArrayList<>();

        for(int i=0; i<v; i++){
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int w){
        adjList.get(u).add(new Edge(v, w)); // only one direction
    }

    public void printGraph(){
        for(int i=0; i<vart; i++){
            System.out.print(i +"-> ");
            for(Edge edge : adjList.get(i)){
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Directed_wt_listG g = new Directed_wt_listG(4);
        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 5);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 3, 3);
        g.addEdge(3, 1, 7);

        g.printGraph();
    }
}
