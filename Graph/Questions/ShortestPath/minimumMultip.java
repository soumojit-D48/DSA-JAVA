package ShortestPath;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class minimumMultip {
    int minimumMultiplications(int[] arr, int start, int end) {
        int MOD = 100000;

        if(start == end) return 0;

        int[] dist = new int[MOD];
        Arrays.fill(dist, -1);
        dist[start] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for(int it : arr){
                int next = (it * cur) % MOD;

                /* In BFS, the first time you visit a node is always the shortest path to it.
                If you visit it again, you're taking a longer path, which is unnecessary and incorrect for shortest-path logic. */

                if(dist[next] == -1){
                    dist[next] = dist[cur] + 1;
                    if(next == end){
                        return dist[next];
                    } 
                    q.offer(next);
                }
            }
        }
        return -1;
    }
}
