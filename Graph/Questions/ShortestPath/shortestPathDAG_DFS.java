package ShortestPath;
import java.util.*;

public class shortestPathDAG_DFS {
    public int[] shortestPath(int V, int E, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[] {v,w});
        }

        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs(i, st, vis, adj);
            }
        }

        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while (!st.isEmpty()) {
            int node = st.pop();
            if(dist[node] != Integer.MAX_VALUE){
                for(int[] nei : adj.get(node)){
                    int adjNode = nei[0];
                    int weight = nei[1];
                    if(dist[node] + weight < dist[adjNode]){
                        dist[adjNode] = dist[node] + weight;
                    }
                }
            }
        }

        for(int i = 0; i < V; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        return dist;
    }
    private void dfs(int node, Stack<Integer> st, boolean[] vis, List<List<int[]>> adj){
        vis[node] = true;

        for(int nei[] : adj.get(node)){
            if(!vis[nei[0]]){
                dfs(nei[0], st, vis, adj);
            }
        }
        st.push(node);
    }
}
