class Solution {
    public int sumCounts(List<Integer> nums) {
        int s=0;
        for(int i=0;i<nums.size();i++){
            Set<Integer> set=new HashSet<>();
            for(int j=i;j<nums.size();j++){
                set.add(nums.get(j));
                s+=set.size()*set.size();
            }
        }
        return s;
    }
}