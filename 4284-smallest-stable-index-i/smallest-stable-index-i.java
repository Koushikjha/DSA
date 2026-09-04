class Solution {
    public int firstStableIndex(int[] nums, int k) {
        
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            int j=nums.length-1;
            int min=Integer.MAX_VALUE;
            while(j>=i){
                min=Math.min(min,nums[j]);
                j--;
            }
            if(max-min<=k){
                return i;
            }
        }
        return -1;
    }
}