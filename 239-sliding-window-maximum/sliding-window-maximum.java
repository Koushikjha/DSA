class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        int i=0;
        int j=0;
        int[] ans=new int[n-k+1];
        for(int num : nums){
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<num){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1){
                ans[j]=nums[dq.peekFirst()];
                j++;
            }
            
            i++;
        }
        return ans;
    }
}