class Solution {
    public int climbStairs(int n) {
        int[] memo=new int[n+1];
        Arrays.fill(memo,-1);
        return find(n,memo);
    }
    public int find(int n,int[] memo){
        if(n<=1){
            return 1;
        }
        if(memo[n]!=-1){
            return memo[n];
        }
        int c=0;
        if(memo[n-2]!=-1){
            c+=memo[n-2];
        }else{
            memo[n-2]=find(n-2,memo);
            c+=memo[n-2];
        }
        if(memo[n-1]!=-1){
            c+=memo[n-1];
        }else{
            memo[n-1]=find(n-1,memo);
            c+=memo[n-1];
        }
        memo[n]=c;
        return memo[n];
    }
}