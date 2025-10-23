class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int n : nums2){
            while(!stack.isEmpty() && n>stack.peek()){
                map.put(stack.pop(),n);
            }
            stack.push(n);
        }
        while(!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }
        int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i]=map.get(nums1[i]);
        }
        return ans;
    }
}