import java.util.LinkedList;
import java.util.Queue;

public class no_of_Enclaves { // leetcode 1020
    public int numEnclavesBFS(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        // Vertical Borders (Left and Right Columns)

        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1){
                q.offer(new int[] {i, 0});
            }
            if(grid[i][n-1] == 1){
                q.offer(new int[] {i, n-1});
            }
        }

        // Horizontal Borders (Top and Bottom Rows)

        for(int j = 0; j < n; j++){
            if(grid[0][j] == 1){
                q.offer(new int[] {0, j});
            }
            if(grid[m-1][j] == 1){
                q.offer(new int[] {m-1, j});
            }
        }

        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

        while (!q.isEmpty()){
            int cur[] = q.poll();
            int x = cur[0];
            int y = cur[1];

            grid[x][y] = 0;

            for(int[] d : dir){
                int nx = x + d[0];
                int ny = y + d[1];

                if(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1){
                    q.offer(new int[] {nx,ny});
                    grid[nx][ny] = 0;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }

    public int numEnclavesBDFS(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // vatrical -> left col and right col, (const col and row changes)

        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1){
                dfs(i, 0, grid);
            }
            if(grid[i][n-1] == 1){
                dfs(i, n-1, grid);
            }
        }

        // horizontal -> left row and right row, (const row and col changes)

         for(int j = 0; j < n; j++){
            if(grid[0][j] == 1){
                dfs(0, j, grid);
            }
            if(grid[m-1][j] == 1){
                dfs(m-1, j, grid);
            }
        }

        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int row, int col, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0){
            return;
        }

        grid[row][col] = 0;

        dfs(row+1, col, grid);
        dfs(row-1, col, grid);
        dfs(row, col+1, grid);
        dfs(row, col-1, grid);
    }
}
