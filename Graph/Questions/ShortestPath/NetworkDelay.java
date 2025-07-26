package ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelay {
    public int networkDelayTime(int[][] times, int n, int k) {
        // adj list
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++){ // 1 -> n, 0th index will be empty
            adj.add(new ArrayList<>());
        }

        for(int[] time : times){
            int u = time[0], v = time[1], w = time[2];
            adj.get(u).add(new int[] {v, w});
        }

        // min heap, to store [time, node]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );
        pq.add(new int[] {0, k});

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        boolean[] visited  = new boolean[n + 1];


        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0], node = cur[1];

            if(visited[node]) continue; // skip that itr if already vis
            visited[node] = true;

            for(int[] nei : adj.get(node)){
                int newNode = nei[0];
                int newTime = nei[1];

                if(!visited[newNode] && time + newTime < dist[newNode]){
                    dist[newNode] = time + newTime;
                    pq.offer(new int[] {time + newTime, newNode});
                }
            }
        }

        int maxTime = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;

    // int[] newDist = Arrays.copyOfRange(dist, 1, dist.length);
    // int maxTime = 0;
    // for (int d : newDist) {
    //     if (d == Integer.MAX_VALUE) return -1;
    //     maxTime = Math.max(maxTime, d);
    // }
    // return maxTime;

    }
}
