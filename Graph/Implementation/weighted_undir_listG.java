import java.util.ArrayList;
import java.util.List;

class Edge{
    int dest;
    int wt;

    public Edge(int d, int w){
        this.dest = d;
        this.wt = w;
    }
    @Override
    public String toString(){
        return "(" + dest + ", weight = " + wt + ")";
    }
}


public class weighted_undir_listG {
    List<List<Edge>> adjlist;
    int vart;

    public weighted_undir_listG(int v){
        this.vart = v;
        adjlist = new ArrayList<>();

        for(int i=0; i<v; i++){
            adjlist.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int w){
        adjlist.get(u).add(new Edge(v, w));
        adjlist.get(v).add(new Edge(u, w));
    }

    public void printGraph(){
        for(int i=0; i<vart; i++){
            System.out.print(i + "->");
            for(Edge edge : adjlist.get(i)){
                System.out.print(edge);
            }
            System.out.println();
        }
    }

     public static void main(String[] args) {
        weighted_undir_listG g = new weighted_undir_listG(4);
        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 5);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 3, 3);

        g.printGraph();
    }
}
