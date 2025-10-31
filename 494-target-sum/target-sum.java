class Solution {
    public int findTargetSumWays(int[] nums, int d) {
        int total=0;
        for(int num : nums) {
            total+=num;
        }
        if(Math.abs(d)>total || (total+d)%2!=0){
            return 0;
        }
        int sum=(d+total)/2;
        return perfectSum(nums,sum);
    }
    public static int perfectSum(int[] arr, int sum) {
        int n=arr.length;
        int[][] dp=new int[n+1][sum+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=sum;j++) {
                if(arr[i-1]<=j)
                {   
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-arr[i-1]];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}