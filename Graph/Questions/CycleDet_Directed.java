import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class CycleDet_Directed {
    public boolean isCyclicDFS(int V, int[][] edges) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] vis = new boolean[V];
        boolean[] pathvis = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(dfs(i, vis, pathvis, adj)){
                    return true;
                }
            }
        }
        /*  if (!dfs(i, vis, pathvis, adj)) {
                return false;
            }
            return true;
            That means the moment you don’t find a cycle in one DFS, you exit early and return false, even if a cycle may exist in another component. */

        return false;
    }

    private boolean dfs(int node, boolean[] vis, boolean[] pathvis, List<List<Integer>> adj){
        vis[node] = true;
        pathvis[node] = true;

        for(int nei : adj.get(node)){
            if(!vis[nei]){
                if(dfs(nei, vis, pathvis, adj)){
                    return true;
                }
            } 
            else if(pathvis[nei]){ // in that path
                return true;
            }
        }
        pathvis[node] = false; // backtrack
        return false;
    }

    // BFS -> TOPO SORT -> Kahn's algo

    public boolean isCyclicBFS(int V, int[][] edges) {
        // adj list -->

        List<List<Integer>> adj = new ArrayList<>();
        int[] indeg = new int[V]; // in degree array

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);

            indeg[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i++){
            if(indeg[i] == 0){
                q.offer(i);
            }
        }

        int count = 0; // vvi
        while (!q.isEmpty()) {
            int node = q.poll();
            count++; // vvi

            for(int nei : adj.get(node)){
                indeg[nei]--;
                if(indeg[nei] == 0){
                    q.offer(nei);
                }
            }
        }
        // If count != V, cycle exists
        return count != V;
    }
}