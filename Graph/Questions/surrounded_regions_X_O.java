public class surrounded_regions_X_O {
    public void solve(char[][] board) {
        int n = board.length;
        if(n == 0) return;
        int m = board[0].length;

        // Top and Bottom Rows 

        for(int j = 0; j < m; j++){
            if(board[0][j] == 'O'){ // 0,1 ; 0,2
                dfs(0,j,board);
            }
            if(board[n-1][j] == 'O'){ //  4,0 ; 4,1 ; 4,2
                dfs(n-1,j,board);
            }
        }

        // Left and Right Columns 

        for(int i = 0; i < n; i++){
            if(board[i][0] == 'O'){ // 1,0 ; 2,0
                dfs(i,0,board);
            }
            if(board[i][m-1] == 'O'){ // 1,4 ; 2,4
                dfs(i,m-1,board);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';     
                } 
                else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void dfs(int row, int col, char[][] board){
        int n = board.length;
        int m = board[0].length;

        if(row < 0 || row >= n || col < 0 || col >= m || board[row][col] != 'O'){
            return;
        }  

        board[row][col] = '#'; // safe means not convert to 'X'

        dfs(row+1, col, board);
        dfs(row-1, col, board);
        dfs(row, col+1, board);
        dfs(row, col-1, board);
    }
}
