package ShortestPath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class shortestPathWUDG {
    public List<Integer> shortestPath(int n, int m, int edges[][]) { // n = V , m = E
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[] {v, w});
            adj.get(v).add(new int[] {u, w});
        }
        int[] distArr = new int[n+1];
        int[] parent = new int[n+1];

        Arrays.fill(distArr, Integer.MAX_VALUE);
        distArr[1] = 0;

        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );   
        pq.add(new int[] {0, 1}); // distArr , node

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[1];
            int dist = cur[0];

            for(int[] nei : adj.get(u)){
                int v = nei[0], w = nei[1];
                if(distArr[u] + w < distArr[v]){
                    distArr[v] = distArr[u] + w;
                    parent[v] = u;
                    pq.add(new int[] {distArr[v], v});
                }
            }
        }

        if(distArr[n] == Integer.MAX_VALUE){
            return Arrays.asList(-1);
        }
        LinkedList<Integer> path = new LinkedList<>();
        int node = n;

        while (parent[node] != node) {
            path.addFirst(node);
            node = parent[node];
        }
        path.addFirst(1);

        List<Integer> ans = new ArrayList<>();
        ans.add(distArr[n]); // Total weight: 1 + 3 + 1 = 5
        ans.addAll(path);  // Shortest path: 1 → 4 → 3 → 5 

        return ans; // [5, 1, 4, 3, 5]
    }
}
