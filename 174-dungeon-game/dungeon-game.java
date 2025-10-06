class Solution {
    public int calculateMinimumHP(int[][] mat) {
        int n=mat[0].length;
        int m=mat.length;
        int[][] dp=new int[m][n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1){
                    dp[i][j]=Math.max(1,1-mat[i][j]);

                }else if(i==m-1){
                    dp[i][j]=Math.max(1,dp[i][j+1]-mat[i][j]);
                }else if(j==n-1){
                    dp[i][j]=Math.max(1,dp[i+1][j]-mat[i][j]);
                }else{
                    dp[i][j]=Math.max(1,Math.min(dp[i+1][j],dp[i][j+1])-mat[i][j]);
                }
            }
        }
        return dp[0][0];
    }
}