class Solution {
    public int[] countBits(int n) {
        if(n==0){
            return new int[]{0};
        }
        if(n==1){
            return new int[]{0,1};
        }
        if(n==2){
            return new int[]{0,1,1};
        }
        int[] res=new int[n+1];
        res[0]=0;
        res[1]=1;
        res[2]=1;
        
        int cur=2;
        int next=4;
        for(int i=3;i<=n;i++){
            if(i==next){
                cur=i;
                next=i*2;
                res[i]=1;
            }else{
                res[i]=res[cur]+res[i-cur];
            }
        }
        return res;
    }
}