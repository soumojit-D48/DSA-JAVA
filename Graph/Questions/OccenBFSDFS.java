import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class OccenBFSDFS {
    // private int[][] heights;
    // private int m,n;
    // private final int[][] directions = {{1,0}, {0,1}, {-1, 0}, {0,-1}};

    // public List<List<Integer>> pacificAtlantic(int[][] heights) {
    //     List<List<Integer>> list = new ArrayList<>();
    //     if(heights == null || heights.length == 0) return list;

    //     this.heights = heights;
    //     m = heights.length;
    //     n = heights[0].length;

    //     boolean[][] pacVisited = new boolean[m][n];
    //     boolean[][] atlVisited = new boolean[m][n];

    //     Queue<int[]> pacQ = new LinkedList<>();
    //     Queue<int[]> atlQ = new LinkedList<>();

    //     for(int i = 0; i < m; i++) {
    //         pacQ.offer(new int[]{i, 0});
    //         pacVisited[i][0] = true;
    //         atlQ.offer(new int[]{i, n-1});
    //         atlVisited[i][n-1] = true;
    //     }

    //     for(int j = 0; j < n; j++) {
    //         pacQ.offer(new int[]{0, j});
    //         pacVisited[0][j] = true;
    //         atlQ.offer(new int[]{m-1, j});
    //         atlVisited[m-1][j] = true;
    //     }

    //     bfs(pacQ, pacVisited);
    //     bfs(atlQ, atlVisited);

    //     for(int i = 0; i < m; i++) {
    //         for(int j = 0; j < n; j++){
    //             if(pacVisited[i][j] && atlVisited[i][j]){
    //                 list.add(Arrays.asList(i, j));
    //             }
    //         }
    //     }
    //     return list;
    // }

    // private void bfs(Queue<int[]> queue, boolean[][] visited){
    //     while (!queue.isEmpty()) {
    //         int cell[] = queue.poll();
    //         int i = cell[0], j = cell[1];

    //         for(int[] dir: directions){
    //             int x = i + dir[0];
    //             int y = j + dir[1];

    //             if(x < 0 || y < 0 || x >= m || y >= n) continue;
    //             if(visited[x][y]) continue;
    //             if(heights[x][y] < heights[i][j]) continue;

    //             visited[x][y] = true;
    //             queue.offer(new int[]{x, y});
    //         }
    //     }
    // }


    private int[][] heights;
    private int m,n;
    private final int[][] directions = {{1,0}, {0,1}, {-1, 0}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();
        if(heights == null || heights.length == 0) return list;

        this.heights = heights;
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacVisited = new boolean[m][n];
        boolean[][] atlVisited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            dfs(i, 0, pacVisited);
            dfs(i, n - 1, atlVisited);
        }

        for(int j = 0; j < n; j++) {
            dfs(0, j, pacVisited);
            dfs(m - 1, j, atlVisited);
        }


        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                if(pacVisited[i][j] && atlVisited[i][j]){
                    list.add(Arrays.asList(i, j));
                }
            }
        }
        return list;
    }

    private void dfs(int i,int j, boolean[][] visited){
        visited[i][j] = true;
        for(int dir[] : directions) {
            int x = i + dir[0];
            int y = j + dir[1];

            if(x < 0 || y < 0 || x >= m || y >= n) continue;
            if(visited[x][y]) continue;
            if(heights[x][y] < heights[i][j]) continue;

            dfs(x, y, visited);
        }
    }
}

