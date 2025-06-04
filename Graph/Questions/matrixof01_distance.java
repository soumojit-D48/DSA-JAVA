import java.util.LinkedList;
import java.util.Queue;

public class matrixof01_distance { // leetcode 542
     public int[][] updateMatrix(int[][] mat) {
       int rows = mat.length;
       int cols = mat[0].length;

       int[][] mat2 = new int[rows][cols];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(mat[i][j] == 0){ // return the distance of the nearest 0 for each cell.
                    mat2[i][j] = 0;
                    q.offer(new int[] {i, j}); // add to queue
                }
                else{
                    mat2[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();   
            int r = cur[0];
            int c = cur[1];

            for(int[] d : dir){
                int newr = r + d[0];
                int newc = c + d[1];

                if(newr >= 0 && newr < rows && newc >= 0 && newc < cols){
                    if(mat2[newr][newc] > mat2[r][c] + 1){ // new cell is greater than cur cell
                        mat2[newr][newc] = mat2[r][c] + 1; // dist form the old cell is +1 to the new cell
                        q.offer(new int[] {newr,newc});
                    }
                }
            }
        }
        return mat2;
    }
}
