class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans=new long[k];
        long[] dp=new long[k];
        for(int num : nums){
            long[] next=new long[k];
            next[num%k]++;
            for(int i=0;i<k;i++){
                int newRem=(i*(num%k))%k;
                next[newRem]+=dp[i];
            }
            dp=next;
            for(int i=0;i<k;i++){
                ans[i]+=dp[i];
            }
        }
        return ans;
    }
}