package ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgo {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[] {v, w});
            adj.get(v).add(new int[] {u, w});
        }

        int[] distArr = new int[V];
        Arrays.fill(distArr , Integer.MAX_VALUE);
        distArr[src] = 0;

        PriorityQueue<int[]> minheap = new PriorityQueue<>(
            (a , b) -> a[1] - b[1] // [node, dist]
        );
        minheap.offer(new int[] {src,0});

        while (!minheap.isEmpty()) {
            int[] cur = minheap.poll();

            int node = cur[0];
            int curdist = cur[1];

            for(int[] nei : adj.get(node)){
                int nextnode = nei[0];
                int weight = nei[1];

                if(curdist + weight < distArr[nextnode]){
                    distArr[nextnode] = curdist + weight;
                    minheap.offer(new int[] {nextnode, curdist + weight});
                }
            }
        }
        return distArr;
    }
}
