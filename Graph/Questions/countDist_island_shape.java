import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class countDist_island_shape {

    // DFS ------------------------------------------->

    // public int countDistinctIslands(int[][] grid) {
    //     int n = grid.length;
    //     int m = grid[0].length; 

    //     boolean[][] vis = new boolean[n][m];
    //     HashSet<String> no_of_Dist_island = new HashSet<>();
        
    //     for(int i = 0; i < n; i++){
    //         for(int j = 0; j < m; j++){
    //             if(grid[i][j] == 1 && !vis[i][j]){
    //                 ArrayList<String> shape = new ArrayList<>();
    //                 dfs(i,j,i,j,grid,vis,shape);
    //                 no_of_Dist_island.add(String.join("," , shape));
    //             }
    //         } // list -> after one dfs ["0_0", "0_1", "1_0"] then after String.join(",", shape) -> "0_0,0_1,1_0"
    //     }
    //     return no_of_Dist_island.size();
    // }

    // private void dfs(int row, int col, int strow, int stcol, int[][] grid, boolean[][] vis, ArrayList<String> shape){
    //     int n = grid.length;
    //     int m = grid[0].length; 

    //     if(row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == 0 || vis[row][col]){
    //         return;
    //     }

    //     vis[row][col] = true;
    //     shape.add((row - strow) + "_" + (col - stcol));

    //     dfs(row+1, col, strow, stcol, grid, vis, shape);
    //     dfs(row-1, col, strow, stcol, grid, vis, shape);
    //     dfs(row, col+1, strow, stcol, grid, vis, shape);
    //     dfs(row, col-1, strow, stcol, grid, vis, shape);
    // }

    // BFS ------------------------------------------->

    public int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length; 

        boolean[][] vis = new boolean[n][m];
        HashSet<String> no_of_Dist_island = new HashSet<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    List<String> shape = bfs(i,j,grid,vis);
                    no_of_Dist_island.add(String.join("," , shape));
                }
            } // list -> after one dfs ["0_0", "0_1", "1_0"] then after String.join(",", shape) -> "0_0,0_1,1_0"
        }
        return no_of_Dist_island.size();
    }

    private List<String> bfs(int row, int col, int[][] grid, boolean[][] vis){
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>(); 
        List<String> shape = new ArrayList<>();
        
        q.add(new int[] {row,col});
        vis[row][col] = true;

        int baseRow = row;
        int baseCol = col;

        int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            shape.add((r - baseRow) + "_" + (c-baseCol));

            for(int[] d : directions){
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && !vis[nr][nc]) {
                    q.offer(new int[] {nr,nc});
                    vis[nr][nc] = true;
                }
            } 
        }
        return shape;
    }
}
