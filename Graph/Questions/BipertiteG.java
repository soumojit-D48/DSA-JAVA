import java.util.*;

public class BipertiteG { // 785. Is Graph Bipartite?
    // public boolean isBipartite(int[][] graph) {
    //     int v = graph.length;

    //     List<List<Integer>> adj = new ArrayList<>();

    //     for(int i = 0; i < v; i++){
    //         adj.add(new ArrayList<>());
    //         for(int nei : graph[i]){ // for(int j = 0; j < graph[i].length; j++)
    //             adj.get(i).add(nei);
    //         }
    //     }

    //     int[] color = new int[v];
    //     Arrays.fill(color, -1);

    //     for(int i = 0; i < v; i++){
    //         if(color[i] == -1){
    //            if(!bfs(i, color, adj)) return false;
    //         }
    //     }
    //     return true;
    // }

    // private boolean bfs(int start, int[] color, List<List<Integer>> adj){
    //     Queue<Integer> q = new LinkedList<>();
    //     q.offer(start);

    //     color[start] = 0;

    //     while (!q.isEmpty()){
    //         int node = q.poll();

    //         for(int nei : adj.get(node)){
    //             if(color[nei] == -1){
    //                 color[nei] = 1 - color[node];
    //                 q.offer(nei);
    //             } else if(color[nei] == color[node]){
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }

    // public boolean isBipartite(int[][] graph) {
    //     int v = graph.length;

    //     int[] color  = new int[v];
    //     Arrays.fill(color, -1);

    //     for(int i = 0; i < v; i++){
    //         if(color[i] == -1){
    //             Queue<Integer> q = new LinkedList<>();
    //             q.offer(i);
    //             color[i] = 0;

    //             while (!q.isEmpty()){
    //                 int node = q.poll();

    //                 for(int nei : graph[node]){
    //                     if(color[nei] == -1){
    //                         color[nei] = 1 - color[node];
    //                         q.offer(nei);
    //                     } else if(color[nei] == color[node]){
    //                         return false;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return true;
    // }

    public boolean isBipartite(int[][] graph) {
        int v = graph.length;

        int[] color = new int[v];
        Arrays.fill(color,-1);

        for(int i = 0; i < v; i++){
            if(color[i] == -1){
                if(!dfs(i, 0, color, graph)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int start, int col, int[] color, int[][] graph){
        color[start] = col;

        for(int nei : graph[start]){
            if(color[nei] == -1){
                if(!dfs(nei, 1-col, color, graph)){
                    return false;
                }
            } 
            else if(color[nei] == col){
                return false;
            }
        }
        return true;
    }
}
