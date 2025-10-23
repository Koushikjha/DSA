class Solution {
    public int maxArea(int[] height) {
       int n=height.length;
        int v=0,w=0;
        int s=0,e=n-1;
        while(s<e){
            if(height[s]>height[e]){
                v=height[e]*(e-s);
            }else{
                v=height[s]*(e-s);
            }
            w=Math.max(v,w);
            if(height[s]>height[e]){
                e--;
            }else{
                s++;
            }
        }
        return w;
    }
}