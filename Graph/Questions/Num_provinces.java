import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.Queue;

public class Num_provinces {
    // DFS ------------------------------->

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        
        boolean[] visited = new boolean[V];
        int count = 0;
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfs(i,adj,visited,V);
                count++; // how many times dfs called
            }
        }
        return count;
    }
    
    static void dfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited,int V){
        visited[start] = true;
        
        // for(int neig : adj.get(start)){ // for adj list
        //     if(!visited[neig]){
        //         dfs(neig, adj,visited);
        //     }
        // }
        
        for(int j = 0; j < V; j++){
            if(adj.get(start).get(j) == 1 && !visited[j]){
                dfs(j,adj,visited,V);
            }
        }
    }

    // BFS ---------------------->

    // static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        
    //     boolean[] visited = new boolean[V];
    //     int count = 0;
        
    //     for(int i=0; i<V; i++){
    //         if(!visited[i]){
    //             bfs(i,adj,visited,V);
    //             count++; // how many times dfs called
    //         }
    //     }
    //     return count;
    // }
    
    // static void bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited,int V){
    //     Queue<Integer> q = new LinkedList<>();
    //     q.offer(start);
    //     visited[start] = true;
        
    //     while (!q.isEmpty()) {
    //         int u = q.poll();
            
    //         for(int v = 0 ; v < V; v++){
    //             if(adj.get(u).get(v) == 1 && !visited[v]){
    //                 q.offer(v);
    //                 visited[v] = true;
    //             }
    //         }
    //     }
    // }
}
