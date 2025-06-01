import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Pair {
    int vert;
    int wt;

    public Pair(int v, int w){
        this.vert = v;
        this.wt = w;
    }
    public String toString() {
        return "(" + vert + ", w=" + wt + ")";
    }
}

public class HashMap_W_D_UD {
    Map<Integer, List<Pair>> adjList;

    public HashMap_W_D_UD(){
        adjList = new HashMap<>();
    }

    public void addEdge(int u, int v, int w, boolean isDirected){
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.get(u).add(new Pair(v, w));

        if(!isDirected){
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(v).add(new Pair(u, w));
        }
    }

    public void printGraph(){
        for(int node : adjList.keySet()){
            System.out.println(node + " -> " + adjList.get(node));
        }
    }

      public static void main(String[] args) {
        HashMap_W_D_UD g = new HashMap_W_D_UD();
        g.addEdge(0, 1, 5, false);
        g.addEdge(0, 2, 3, false);
        g.addEdge(1, 2, 2, false);
        g.addEdge(2, 3, 4, false);

        g.printGraph();
    }

}
