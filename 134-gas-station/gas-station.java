class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tgas=0;
        int tcost=0;
        for(int i=0;i<gas.length;i++){
            tgas+=gas[i];
            tcost+=cost[i];
        }
        if(tgas<tcost){
            return -1;
        }
        int curr=0;
        int ans=0;
        for(int i=0;i<gas.length;i++){
            curr+=gas[i]-cost[i];
            if(curr<0){
                ans=i+1;
                curr=0;
            }
        }
        return ans;
    }
}