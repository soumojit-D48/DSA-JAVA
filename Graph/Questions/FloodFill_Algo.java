// import java.util.LinkedList;
// import java.util.Queue;

public class FloodFill_Algo {

    // // DFS ------------------------------------>
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int oldColor = image[sr][sc];

        if(oldColor != newColor){
            dfs(image, sr, sc, newColor, oldColor);
        }

        return image;
    }

    private void dfs(int[][] image, int r, int c, int newColor, int oldColor){

        if(r < 0 || r >= image.length || c < 0 || c >= image.length || image[r][c] != oldColor){ // we call dfs when current color and old color same, then we can change it via dfs 
            return;
        }

        // image[r][c] == oldColor // call dfs 
        image[r][c] = newColor;

        dfs(image, r+1, c, newColor, oldColor);
        dfs(image, r-1, c, newColor, oldColor);
        dfs(image, r, c+1, newColor, oldColor);
        dfs(image, r, c-1, newColor, oldColor);
    }



    //// BFS ---------------------------------------->

    // public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    //     int oldColor = image[sr][sc];
    //     if(oldColor == newColor) return image;

    //     int rows = image.length;
    //     int cols = image[0].length;

    //     int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        
    //     Queue<int[]> q = new LinkedList<>();
    //     q.offer(new int[] {sr, sc});

    //     while (!q.isEmpty()){
    //         int[] cur = q.poll();
    //         int r = cur[0];
    //         int c = cur[1];

    //         image[r][c] = newColor;

    //         for(int[] d : dir){
    //             int newr = r + d[0]; 
    //             int newc = c + d[1];

    //             if(newr >= 0 && newr < rows && newc >= 0 && newc < cols && image[newr][newc] == oldColor){
    //                 q.offer(new int[] {newr, newc});
    //             }
    //         }
    //     }
    //     return image;
    // }
}
