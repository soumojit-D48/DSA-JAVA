import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;

public class courseShedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];

            adj.get(u).add(v);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < numCourses; i++){
            if(!vis[i]){
                if(dfs(i, vis, pathVis, adj, st)){
                    return false; // false cause cycle ditected
                }
            }
        }
        return true;
    }

    private boolean dfs(int node, boolean[] visited, boolean[] pathVisited, List<List<Integer>> adj, Stack<Integer> topoStack) {
        visited[node] = true;
        pathVisited[node] = true;

        for(int nei : adj.get(node)){
            if(!visited[nei]){
                if(dfs(nei, visited, pathVisited, adj, topoStack)){
                    return true; // cycle
                }
            } else if(pathVisited[nei]){
                return true; // cycle
            }
        }
        pathVisited[node] = false;
        topoStack.push(node);
        return false;
    }

    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        // number of nodes means numCourses

         /* int numCourses = 0;
            for (int[] pair : prerequisites) {
                numCourses = Math.max(numCourses, Math.max(pair[0], pair[1]));
            } */
         
        List<List<Integer>> adj = new ArrayList<>();
        int[] indeg = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int pre = edge[1];
            int todo = edge[0];

            adj.get(pre).add(todo);
            indeg[todo]++;
        }

         Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            for(int nei : adj.get(node)){
                indeg[nei]--;
                if(indeg[nei] == 0){
                    q.add(nei);
                }
            }
        }
        return count == numCourses;
    }

    public boolean isPossible(int N, int P, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indeg = new int[N];

        for(int i = 0; i < N; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            int pre = edge[1];
            int todo = edge[0];

            adj.get(pre).add(todo);
            indeg[todo]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < N; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            for(int nei : adj.get(node)){
                indeg[nei]--;
                if(indeg[nei] == 0){
                    q.add(nei);
                }
            }
        }
        return count == N;
    }
}
