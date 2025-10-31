class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1]; //DP
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],1+dp[i-(j*j)]);
            }
        }
        return dp[n];
    }
    //Recursion
    int find(int n, int[] memo){
        if(n==0){
            return 0;
        }
        if(memo[n]!=-1){
            return memo[n];
        }        
        int ans=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            ans=Math.min(ans,1+find(n - (i*i), memo));
        }
        memo[n]=ans;
        return ans;
    }
}