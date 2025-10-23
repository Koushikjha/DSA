class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans=new int[nums1.length];
        int k=0;
        for(int num : nums1){
            Stack<Integer> stack=new Stack<>();
            for(int i=nums2.length-1;i>=0 && nums2[i]!=num;i--){
                if(num<nums2[i]){
                    stack.push(nums2[i]);
                }
            }
            if(stack.isEmpty()){
                ans[k++]=-1;
            }else{
                ans[k++]=stack.pop();
            }
        }
        return ans;
    }
}