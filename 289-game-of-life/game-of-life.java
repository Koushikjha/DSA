class Solution {
    int[][] grid={{0,-1},{-1,0},{1,1},{-1,-1},{0,1},{1,0},{-1,1},{1,-1}};
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] updated=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int lives=0;
                for(int[] g : grid){
                    int r=i+g[0];
                    int c=j+g[1];
                    if(r>=0 && r<m && c>=0 && c<n && board[r][c]==1){
                        lives++;
                    }
                }
                if((board[i][j]==0 && lives==3) 
                || (board[i][j]==1 && (lives<2 || lives>3))){
                    updated[i][j]=true;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(updated[i][j]){
                    board[i][j]=1-board[i][j];
                }
            }
        }
    }
}