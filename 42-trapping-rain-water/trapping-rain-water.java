class Solution {
    public int trap(int[] nums) {
        int water=0;
        int lmax=0,rmax=0,l=0,r=nums.length-1;
        while(l<=r){
            if(nums[l]<nums[r]){
                if(nums[l]>lmax){
                    lmax=nums[l];
                }else{
                    water+=lmax-nums[l];
                }
                l++;
            }else{
                if(nums[r]>rmax){
                    rmax=nums[r];
                }else{
                    water+=rmax-nums[r];
                }
                r--;
            }
        }
        return water;
    }
}