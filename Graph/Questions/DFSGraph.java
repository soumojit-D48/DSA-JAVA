import java.util.ArrayList;
import java.util.List;

public class DFSGraph { // Tc -> O(V + E), Sc -> O(V) auxiliary
    private int vart;
    private List<List<Integer>> adj;

    public DFSGraph(int v){
        this.vart = v;
        adj = new ArrayList<>();
        for(int i=0; i<=v; i++){ //  1 based indexing
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u); // Remove this for directed graph
    }

    public void dfs(int startNode){
        boolean[] visited = new boolean[vart+1];   // size = V + 1
        dfsHelper(startNode, visited);
    }

    public void dfsHelper(int node, boolean[] visited){
        visited[node] = true;
        System.out.print(node + " ");

        for(int neig : adj.get(node)){
            if(!visited[neig]){
                dfsHelper(neig, visited); // recursive call for neigbour node
            }
        }
    }

     public static void main(String[] args) {
        DFSGraph graph = new DFSGraph(8);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        graph.addEdge(3, 7);
        graph.addEdge(3, 4);

        graph.addEdge(4, 8);
        graph.addEdge(7, 8);

        System.out.println("DFS starting from node 1:");
        graph.dfs(1);
    }
}
