import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraph { // Tc -> O(V + E) // Sc -> O(V)
    private int vart;
    private List<List<Integer>> adj;

    public BFSGraph(int v){
        this.vart = v;
        adj = new ArrayList<>();
        for(int i=0; i<=v; i++){ // 1 base indexing
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);  // remove this for directed
    }

    public void bfs(int startNode){
        boolean[] visited = new boolean[vart+1]; // size = V + 1
        Queue<Integer> q = new LinkedList<>();

        visited[startNode] = true;
        q.offer(startNode);

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for(int neig : adj.get(node)){
                if(!visited[neig]){
                    visited[neig] = true;
                    q.offer(neig);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSGraph graph = new BFSGraph(10);

        graph.addEdge(1, 2);
        graph.addEdge(1, 6);

        graph.addEdge(2, 3);
        graph.addEdge(2, 4);

        graph.addEdge(4, 5);
        graph.addEdge(5, 8);

        graph.addEdge(6, 7);
        graph.addEdge(6, 9);

        graph.addEdge(7, 8);
 
        System.out.println("BFS starting from node 1:");
        graph.bfs(1);
    }
}
