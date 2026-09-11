class Solution {
    Integer[][] dp;
    public int twoEggDrop(int n) {
        dp=new Integer[n+1][3];
        return find(n,2);
    }
    public int find(int f,int e){
        if(f==1 || f==0){
            return f;
        }
        if(e==1){
            return f;
        }
        if(dp[f][e]!=null){
            return dp[f][e];
        }
    
        int ans=Integer.MAX_VALUE;
        for(int x=1;x<=f;x++){
            int brk=find(x-1,e-1);
            int surv=find(f-x,e);
            int worst=1+Math.max(brk,surv);
            ans=Math.min(ans,worst);
        }
        return dp[f][e]=ans;
    }
}