package ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class shortestP_UndirG {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int n = adj.size();
        int[] dist = new int[n];
        
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> q  = new LinkedList<>();
        dist[src] = 0;
        q.offer(src);

        while (!q.isEmpty()) {
            int node = q.poll();

            for(int nei : adj.get(node)){
                if(dist[nei] == Integer.MAX_VALUE){
                    dist[nei] = dist[node] + 1;
                    q.offer(nei);
                }
            }
        }
        return dist;
    }
}
