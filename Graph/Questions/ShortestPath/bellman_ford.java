package ShortestPath;
import java.util.Arrays;

public class bellman_ford {
     public int[] bellmanFord(int V, int[][] edges, int src) {
        int Infinite = (int)1e8;
        int[] dist = new int[V];
        Arrays.fill(dist, Infinite);
        dist[src] = 0;

        for(int i = 0; i < V - 1; i++){
            for(int[] edge : edges){ // V - 1 time
                int u = edge[0], v = edge[1], wt = edge[2];

                if(dist[u] != Infinite && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for(int[] edge : edges){ // Vth time
            int u = edge[0], v = edge[1], wt = edge[2];
            if(dist[u] != Infinite && dist[u] + wt < dist[v]){
                return new int[]{-1};
            }
        }
        return dist;
    }
}
