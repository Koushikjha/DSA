class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],-1);
        }
        if(grid[m-1][n-1]==1){
            return 0;
        }
        return find(grid,m,n,0,0,dp);
    }
    public int find(int[][] grid,int maxRow,int maxCol,int row,int col,int[][] dp){
        if(row==maxRow-1 && col==maxCol-1){
            return 1;
        }
        if(row>=maxRow || col>=maxCol || grid[row][col]==1){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int count=0;
        count+=find(grid,maxRow,maxCol,row+1,col,dp);
        count+=find(grid,maxRow,maxCol,row,col+1,dp);

        return dp[row][col]=count;
    }
}