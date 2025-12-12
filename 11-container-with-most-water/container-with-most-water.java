class Solution {
    public int maxArea(int[] height) {
       int n=height.length;
        int v=0,w=0;
        int s=0,e=n-1;
        while(s<e){
            w=Math.max(Math.min(height[s],height[e])*(e-s),w);
            if(height[s]>height[e]){
                e--;
            }else{
                s++;
            }
        }
        return w;
    }
}