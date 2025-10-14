class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int left=0;
        int ans=-1;
        for(int i=0;i<nums.length;i++){
            int right=sum-left-nums[i];
            if(right==left){
                ans=i;
                break;
            }
            
            left+=nums[i];
        }
        return ans;
    }
}