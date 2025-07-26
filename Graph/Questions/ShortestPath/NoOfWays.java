package ShortestPath;

import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;

public class NoOfWays {
    static final int MOD = (int)1e9 + 7;
    public int countPaths(int n, int[][] roads) { // 1976
        // final int MOD = 1_000_000_007;
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] road : roads){
            int u = road[0], v = road[1], w = road[2];

            adj.get(u).add(new int[] {v, w});
            adj.get(v).add(new int[] {u, w});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a,b) -> Long.compare(a[0], b[0])
        );
        pq.offer(new long[] {0, 0}); // {dist, node}

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long time = cur[0];
            int node = (int)cur[1];

            if(time > dist[node]) continue;

            for(int[] nei : adj.get(node)){
                int next = nei[0];
                int weight = nei[1];
                long newTime = time + weight;

                if(newTime < dist[next]){
                    dist[next] = newTime;
                    ways[next] = ways[node];
                    pq.offer(new long[] {newTime, next});
                } 
                else if(newTime == dist[next]){
                    ways[next] = (ways[next] + ways[node]) % MOD;
                }
            }
        }
        return ways[n-1];
    }
}
