class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo=new int[cost.length];
        Arrays.fill(memo,-1);
        return Math.min(find(cost,0,memo),find(cost,1,memo));
    }
    public int find(int[] cost,int idx,int[] memo){
        if(idx>=cost.length){
            return 0;
        }
        if(memo[idx]!=-1){
            return memo[idx];
        }
        int one=find(cost,idx+1,memo);
        int two=find(cost,idx+2,memo);
        memo[idx]=cost[idx]+Math.min(one,two);
        return memo[idx];
    }
}