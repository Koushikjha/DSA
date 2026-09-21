class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        long ans=0;
        int min=nums[0];
        for(int i=0;i<n;i++){
            ans+=nums[i]-min;
        }
        return (int)ans;
    }
}