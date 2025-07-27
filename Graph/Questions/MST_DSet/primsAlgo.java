package MST_DSet;

import java.util.List;
import java.util.PriorityQueue;

public class primsAlgo {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[1] - b[1]
        );

        pq.offer(new int[] {0,0});
        int sum = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int wt = cur[1];

            if(visited[node]) continue;

            visited[node] = true;
            sum += wt;

            for(int[] nei : adj.get(node)){
                int next = nei[0];
                int nextWt = nei[1];

                if(!visited[next]){
                    pq.offer(new int[] {next, nextWt});
                }
            }
        }
        return sum;
    }
}
