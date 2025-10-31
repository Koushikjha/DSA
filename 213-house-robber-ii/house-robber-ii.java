class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int case1=helper(nums,0,n-2,dp1);

        int[] dp2=new int[n];
        Arrays.fill(dp2,-1);
        int case2=helper(nums,1, n - 1, dp2);

        return Math.max(case1,case2);
    }

    private int helper(int[] nums, int start,int end, int[] dp) {
        if (start > end) return 0;             
        if (start == end){
            return nums[start];
        }       
        if (dp[end] != -1) return dp[end];     
        
        int rob = nums[end] + helper(nums,start, end - 2, dp);
        int skip = helper(nums,start, end - 1, dp);
        
        return dp[end] = Math.max(rob, skip);
    }
}