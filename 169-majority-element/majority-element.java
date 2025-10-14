class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int max=0;
        for(int i=0;i<nums.length;i++){
            map.putIfAbsent(nums[i],0);
            map.put(nums[i],map.get(nums[i])+1);
            max=Math.max(max,map.get(nums[i]));
        }
        int ans=0;
        for(int num : map.keySet()){
            if(map.get(num)==max){
                ans=num;
                return ans;
            }
        }
        return ans;
    }
}