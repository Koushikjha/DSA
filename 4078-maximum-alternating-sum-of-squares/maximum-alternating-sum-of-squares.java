class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int j=0;j<nums.length;j++){
            nums[j]=Math.abs(nums[j]);
        }
        Arrays.sort(nums);
        int n=nums.length;
        int i=0;
        long sum=0;
        while(i<n/2){
            sum-=(long)Math.pow(nums[i],2);
            i++;
        }
        while(i<n){
            sum+=(long)Math.pow(nums[i],2);
            i++;
        }
        return sum;
    }
}