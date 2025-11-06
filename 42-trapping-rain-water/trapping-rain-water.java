class Solution {
    public int trap(int[] nums) {
        int start=0,end=nums.length-1;
        int water=0;
        int lpos=0;
        int rpos=0;
        while(start<=end){
            if(nums[start]<nums[end]){
                if(nums[start]>lpos){
                    lpos=nums[start];
                }else{
                    water+=lpos-nums[start];
                }
                start++;
            }else{
                if(nums[end]>rpos){
                    rpos=nums[end];
                }else{
                    water+=rpos-nums[end];
                }
                end--;
            }
        }
        return water;
    }
}