class Solution {
    public int twoEggDrop(int n) {
        int[][] dp=new int[n+1][3];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return find(n,2,dp);
    }
    public int find(int f,int e,int[][] dp){
        if(f==0 || f==1 || e==1){
            return f;
        }
        if(dp[f][e]!=-1){
            return dp[f][e];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<=f;i++){
            int s=1+Math.max(find(i-1,e-1,dp),find(f-i,e,dp));
            ans=Math.min(s,ans);
        }
        return dp[f][e]=ans;

    }
}