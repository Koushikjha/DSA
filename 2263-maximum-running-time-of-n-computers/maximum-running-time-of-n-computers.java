class Solution {
    public long maxRunTime(int n, int[] nums) {
        long t=0;
        for(int num : nums){
            t+=num;
        }    
        long low=0;
        long high=t/n;
        while(low<high){
            long mid=high-(high-low)/2;
            if(can(mid,nums,n)){
                low=mid;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
    public boolean can(long time,int[] nums,int n){
        long sum=0;
        long required=time*n;
        for(int num : nums){
            sum+=Math.min(time,(long)num);
            if(sum>=required){
                return true;
            }
        }
        return sum>=required;
    }
}