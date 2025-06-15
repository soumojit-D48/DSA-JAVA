import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;

public class TopologicalSort {
     public static ArrayList<Integer> topoSortDFS(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs(i, vis, st, adj);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < V; i++){
            int cur = st.pop();
            ans.add(cur);
        }
        return ans;
    }

    private static void dfs(int node, boolean[] vis, Stack<Integer> st, List<List<Integer>> adj){
        vis[node] = true;

        for(int nei : adj.get(node)){
            if(!vis[nei]){
                dfs(nei, vis, st, adj);
            }
        }
        st.push(node); // after complete dfs of a perticuler node
    }


    public static ArrayList<Integer> topoSortBFS(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[V];

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            inDegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
             ans.add(node);

            for(int nei : adj.get(node)){
                inDegree[nei]--; // dec the indegree
                if(inDegree[nei] == 0){ 
                    q.offer(nei);
                } // if zero add it to q to find it neigbour in next round
            }
        }
        return ans;
    }
}
