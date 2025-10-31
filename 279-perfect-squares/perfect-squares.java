class Solution {
    public int numSquares(int n) {
        int[] memo=new int[n+1];
        Arrays.fill(memo,-1);
        int ans=find(n,memo);
        return ans;
    }
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