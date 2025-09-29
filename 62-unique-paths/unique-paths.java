class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],-1);
        }
        return find(m,n,0,0,dp);
    }
    public int find(int maxRow,int maxCol,int row,int col,int[][] dp){
        if(row==maxRow-1 && col==maxCol-1){
            return 1;
        }
        if(row>=maxRow || col>=maxCol){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int count=0;
        count+=find(maxRow,maxCol,row+1,col,dp);
        count+=find(maxRow,maxCol,row,col+1,dp);

        return dp[row][col]=count;
    }
}