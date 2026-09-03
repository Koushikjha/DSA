class Solution {
    public boolean uniformArray(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int odd=0;
        int even=0;
        for(int num : nums){
            if(num%2!=0){
                odd++;
                continue;
            }
            if(odd>0){
                odd++;
            }
            even++;
        }
        return even==n || odd==n;

    }
}