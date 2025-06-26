package ShortestPath;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class DijkstraSet {
    static class Pair{
        int node;
        int dist;

        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }

    public static int[] dijkstra(int V, List<List<Pair>> adj, int src){
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        TreeSet<Pair> set = new TreeSet<>((a, b) ->{
            if(a.dist == b.dist) return a.node - b.node;
            return a.dist - b.dist;
        });

        set.add(new Pair(src, 0));

        while (!set.isEmpty()) {
            Pair top = set.pollFirst();
            int u = top.node;

            for(Pair nei : adj.get(u)){
                int v = nei.node;
                int w = nei.dist;

                if(dist[u] + w < dist[v]){
                    Pair old = new Pair(v, dist[v]);
                    set.remove(old);

                    dist[v] = dist[u] + w;
                    set.add(new Pair(v, dist[v]));
                }
            }
        }
        return dist;
    }
}
