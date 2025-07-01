package ShortestPath;

import java.util.Arrays;
import java.util.PriorityQueue;

public class miniminEffort {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] diff = new int[m][n];
        for(int[] row : diff){
            Arrays.fill(row, Integer.MAX_VALUE);        
        }
        diff[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );

        pq.offer(new int[] {0,0,0});

        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int curEffort = cur[0];
            int x = cur[1];
            int y = cur[2];

            if(x == m-1 && y == n-1) return curEffort;

            for(int[] d : dirs){
                int nx = x + d[0];
                int ny = y + d[1];

                if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                    int nextEffort = Math.max(curEffort, Math.abs(heights[nx][ny] - heights[x][y]));

                    if(nextEffort < diff[nx][ny]){
                        diff[nx][ny] = nextEffort;
                        pq.offer(new int[] {nextEffort, nx, ny});
                    }
                }
            }
        }
        return 0;
    }
}
