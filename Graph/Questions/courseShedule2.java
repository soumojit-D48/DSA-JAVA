import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class courseShedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        int[] indeg = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int pre = edge[0];
            int todo = edge[1];

            adj.get(pre).add(todo);
            indeg[todo]++;
        }

         Queue<Integer> q = new LinkedList<>();
         List<Integer> topo = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for(int nei : adj.get(node)){
                indeg[nei]--;
                if(indeg[nei] == 0){
                    q.add(nei);
                }
            }
        }
        
        int[] ans = new int[numCourses];
        if(topo.size() == numCourses){ // no cycle
            for(int i = 0; i < numCourses; i++){
                ans[i] = topo.get(i);
            }
            return ans;
        }
        return new int[0];
    }
}
