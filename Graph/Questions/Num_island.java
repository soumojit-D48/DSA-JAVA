import java.util.LinkedList;
import java.util.Queue;

public class Num_island { // leetcode 200
    // BFS -------------------------------------->

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} }; // down, up, right, left

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, visited, i, j, directions);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, boolean[][] visited, int startRow, int startCol, int[][] directions) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startRow, startCol});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length &&
                    grid[nr][nc] == '1' && !visited[nr][nc]) {

                    queue.offer(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }

    // DFS ----------------------------------->

    // public int numIslands(char[][] grid) {
    //     if(grid == null || grid.length == 0) return 0;

    //     int rows = grid.length;
    //     int col = grid[0].length;
    //     boolean[][] visited = new boolean[rows][col];
    //     int count = 0;

    //     for(int i=0; i<rows; i++){
    //         for(int j=0; j<col; j++){
    //             if(grid[i][j] == '1' && !visited[i][j]){
    //                 dfs(grid, visited, rows, col);
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }

    // private void dfs(char[][] grid, boolean[][] visited, int r, int c){
    //     int rows = grid.length;
    //     int col = grid[0].length;

    //     visited[r][c] = true;

    //     if(r < 0 && r > rows && c < 0 && c > col && grid[r][c] == '0' && visited[r][c]){
    //         return;
    //     }

    //     dfs(grid, visited, r + 1, c);
    //     dfs(grid, visited, r - 1, c);
    //     dfs(grid, visited, r, c + 1);
    //     dfs(grid, visited, r, c - 1);
    // }
}
