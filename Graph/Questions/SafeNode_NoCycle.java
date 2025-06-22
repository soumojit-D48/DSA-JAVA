import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SafeNode_NoCycle {
    /* Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
        Output: [2,4,5,6] */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        boolean[] state = new boolean[n]; // true -> safe

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, graph, visited, pathVisited, state);
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(state[i]){
                res.add(i);
            }
        }
        return res;
    }

    private boolean dfs(int node, int[][] graph, boolean[] visited, boolean[] pathVisited, boolean[] state){

        visited[node] = true;
        pathVisited[node] = true;

        for(int nei : graph[node]){
            if(!visited[nei]){
                if(!dfs(nei, graph, visited, pathVisited, state)){
                    return false;
                }
            } else if(pathVisited[nei]){ // vis and path vis means that cycle
                return false;
            }
        }
        pathVisited[node] = false;
        state[node] = true;
        return true;
    }

    // Topological sort (BFS)---> 

    public List<Integer> eventualSafeNodesTOPO(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        int[] indeg = new int[n];

        for(int u = 0; u < n; u++){
            for(int v : graph[u]){
                adj.get(v).add(u);
                indeg[u]++;
            }
        }
        // for(int edge[] : graph){
        //     int u = edge[0];
        //     int v = edge[1];

        //     adj.get(v).add(u);
        //     indeg[u]++;
        // }

        boolean[] isSafe= new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            isSafe[node] = true;

            for(int nei : adj.get(node)){
                indeg[nei]--;
                if(indeg[nei] == 0){
                    q.add(nei);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(isSafe[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}
