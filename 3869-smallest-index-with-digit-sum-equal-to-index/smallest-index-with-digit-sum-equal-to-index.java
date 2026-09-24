class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int s=0;
            while(num>0){
                int d=num%10;
                s+=d;
                num/=10;
            }
            if(s==i){
                return i;
            }
        }
        return -1;
    }
}