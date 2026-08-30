class Solution {
    public int minimumDeletions(int[] nums) {
        int minIdx=0;
        int maxIdx=0;
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]<nums[minIdx]){
                minIdx=i;
            }
            if(nums[i]>nums[maxIdx]){
                maxIdx=i;
            }
        }
        if(minIdx==maxIdx){
            return Math.min(minIdx+1,n-minIdx);
        }else if(maxIdx>minIdx){
            return Math.min(Math.min(minIdx+1+n-maxIdx,maxIdx+1),n-minIdx);
        }else{
            return Math.min(Math.min(maxIdx+1+n-minIdx,minIdx+1),n-maxIdx);
        }
    }
}