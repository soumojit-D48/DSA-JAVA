import java.util.ArrayList;
import java.util.List;

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
}
