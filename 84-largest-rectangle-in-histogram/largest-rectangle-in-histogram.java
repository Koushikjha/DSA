class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        int ans=0;
        int n=arr.length;
        for(int i=0;i<=n;i++){
            int h=(i==n)?0:arr[i];
            while(!stack.isEmpty() && h<arr[stack.peek()]){
                int height=arr[stack.pop()];
                int right=i;
                int left=(stack.isEmpty())?-1:stack.peek();
                int width=right-left-1;
                ans=Math.max(ans,height*width);
            }
            stack.push(i);
        }
        return ans;
    }
}