package ShortestPath;

import java.util.LinkedList;
import java.util.Queue;

public class ShoPathBinaryMaze {
    public int shortestPathBinaryMatrix(int[][] grid) { // 1091
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        if(n == 1) return 1;

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];

        q.add(new int[] {0,0,1});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], d = cur[2];

            if(r == n-1 && c == n-1) return d;

            for(int i = 0; i < 8; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0 && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    q.add(new int[] {nr, nc, d + 1});
                }
            }
        }
        return -1;
    }

    class Pair{
        int row, col, dist;
        Pair(int r, int c, int d) {
            this.row = r;
            this.col = c;
            this.dist = d;
        }
    }

    public int shortestDistance(int N, int M, int A[][], int X, int Y) {
        if(A[0][0] == 0) return -1;
        if(X == 0 && Y == 0) return 0;

        boolean[][] vis = new boolean[N][M];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0,0));
        vis[0][0] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int r = cur.row, c = cur.col, d = cur.dist;

            if(X == r && Y == c) return d;
            
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nr < N && nc >= 0 && nc < M && A[nr][nc] == 1 && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    q.add(new Pair(nr, nc, d+1));
                }
            }
        }
        return -1;
    }
}
