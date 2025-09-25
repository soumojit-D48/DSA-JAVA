package MST_DSet;

import java.util.ArrayList;
import java.util.List;

public class kruskalsAlgo {
    static class Edge {
        int u, v, wt;
        Edge(int u, int v, int wt){
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    static class DisjointSet{
        int[] parent, rank;

        DisjointSet(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i <= n; i++){
                parent[i] = i;
                // rank[i] = 0;
            }
        }
        int findUPar(int node){
            if(parent[node] != node){
                parent[node] = findUPar(node);
            }
            return parent[node];
        }

        void union(int u, int v){
            int pu = findUPar(u);
            int pv = findUPar(v);

            if(pu == pv) return;

            if(rank[pu] < rank[pv]){
                parent[pu] = pv; // Makes pv the new parent of pu's set
            } else if (rank[pu] > rank[pv]){
                parent[pv] = pu; 
            } else {
                parent[pv] = pu;
                rank[pu]++;
            }
        }
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<Edge> edges = new ArrayList<>();

        boolean[][] visited = new boolean[V][V];
        for(int u = 0; u < V; u++){
            for(int[] pair : adj.get(u)){
                int v = pair[0], wt = pair[1];
                if(!visited[u][v] && !visited[v][u]){
                    edges.add(new Edge(u, v, wt));
                    visited[u][v] = visited[v][u] = true;
                }
            }
        }

        edges.sort((a, b) -> a.wt - b.wt);

        DisjointSet ds = new DisjointSet(V);
        int mstWt = 0;
        int edgeUsed = 0;

        for(Edge edge : edges){
            if(ds.findUPar(edge.u) != ds.findUPar(edge.v)){
                ds.union(edge.u, edge.v);
                mstWt += edge.wt;
                edgeUsed++;
                if(edgeUsed == V - 1) break;
            }
        }
        return mstWt;
    }
}
