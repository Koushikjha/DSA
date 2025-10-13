class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int min=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<nums[min]){
                min=i;
            }
            if(nums[i]>nums[max]){
                max=i;
            }
        }
        int left=Math.min(min,max);
        int right=Math.max(min,max);
        int end=n-left;
        int front=right+1;
        int both=(n-right)+(left+1);
        return Math.min(both,Math.min(front,end));
    }
}