import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Oranges {
    public int orangesRotting(int[][] grid) {
        int countFreash = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[] {i,j});
                }
                else if(grid[i][j] == 1){
                    countFreash++;
                }
            }
        }

        if(countFreash == 0) return 0;

        int min = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {
            int size = q.size();
            boolean check = false;

            for(int i = 0; i < size; i++){
                int[] cur = q.poll();

                int r = cur[0];
                int c = cur[1];

                for(int[] d : dir){
                    int newr = r + d[0];
                    int newc = c + d[1];

                    if(newr >= 0 && newr < rows && newc >= 0 && newc < cols && grid[newr][newc] == 1){
                        grid[newr][newc] = 2;
                        countFreash--;
                        check = true;
                    }
                }
            }
            if(check){
                min++;
            }
        }
        return countFreash == 0 ? min : -1;
    }
}
