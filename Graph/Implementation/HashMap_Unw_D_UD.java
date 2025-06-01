import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class HashMap_Unw_D_UD {
    Map<Integer, List<Integer>> adjList;

    public HashMap_Unw_D_UD(){
        adjList = new HashMap<>();
    }

    public void addEdge(int u, int v, boolean isDirected){
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.get(u).add(v);

        if(!isDirected){
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(v).add(u);
        }
    }

    public void printGraph(){
        for(int node : adjList.keySet()){
            System.out.println(node + " -> " + adjList.get(node));
        }
    }

      public static void main(String[] args) {
        HashMap_Unw_D_UD g = new HashMap_Unw_D_UD();
        g.addEdge(0, 1, false);
        g.addEdge(0, 2, false);
        g.addEdge(1, 2, false);
        g.addEdge(2, 3, false);

        g.printGraph();
    }

}
