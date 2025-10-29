class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i]=find(i);
        }
        return ans;
    }
    public int find(int n){
        int c=0;
        while(n>0){
            if(n%2==1){
                c++;
            }
            n/=2;
        }
        return c;
    }
}