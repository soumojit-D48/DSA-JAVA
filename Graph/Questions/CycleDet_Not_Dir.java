import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class CycleDet_Not_Dir { 
    // BFS --------------------------------->

    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < edges.length; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(bfs(i,vis, adj)){
                    return true;
                }
            }
        }
 

        return false;
    }

    private boolean bfs(int start, boolean[] vis, List<List<Integer>> adj){
        Queue<int[]> q = new LinkedList<>();
        vis[start] = true;
        q.offer(new int[] {start,-1});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int parent = cur[1];

            for(int neig : adj.get(node)){ // cause multiple neigbours
                if(!vis[neig]){
                    vis[neig] = true;
                    q.offer(new int[] {neig,node});
                } else if(neig != parent){ // it already visited but its not parent of the node means cycle
                    return true;
                }
            }
        }
        return false;
    }

    /*
        If a neighbor hasn’t been visited → enqueue it.

        If a neighbor is already visited:

            If it is the parent → do nothing.

            If it is not the parent → cycle exists.
    */

    // DFS -------------------------------------------->

    // public boolean isCycle(int V, int[][] edges) {
    //     List<List<Integer>> adj = new ArrayList<>();

    //     for(int i = 0; i < edges.length; i++){
    //         adj.add(new ArrayList<>());
    //     }

    //     for(int[] edge : edges){
    //         int u = edge[0];
    //         int v = edge[1];
    //         adj.get(u).add(v);
    //         adj.get(v).add(u);
    //     }

    //     boolean[] vis = new boolean[V];

    //     for(int i = 0; i < V; i++){
    //         if(!vis[i]){
    //             if(dfs(i, -1, vis, adj)){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    // private boolean dfs(int start, int parent, boolean[] vis, List<List<Integer>> adj){
    //     vis[start] = true;

    //     for(int neig : adj.get(start)){
    //         if(!vis[neig]){
    //             dfs(neig, start, vis, adj);
    //             return true;
    //             // If the DFS call from that neighbor detects a cycle (i.e., it returns true), 
    //             // you should also return true — because a cycle was found somewhere down the path.
    //         }
    //         if(neig != parent){
    //             return true; // Already visited and not coming back to parent
    //         } // it is a new node but already visited means it comes back again
    //     }
    //     return false;
    // }
}
