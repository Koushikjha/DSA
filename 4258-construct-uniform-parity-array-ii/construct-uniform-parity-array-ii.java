class Solution {
    public boolean uniformArray(int[] nums) {
        int n=nums.length;
        int even=0;
        int min=nums[0];
        for(int num : nums){
            if(num%2==0){
                even++;
            }
            min=Math.min(min,num);
        }
        return even==n || min%2==1;

    }
}