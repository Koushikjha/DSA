class Solution {
    int mod=1337;
    public int superPow(int a, int[] b) {
        if(b.length==0){
            return 1;
        }
        int last=b[b.length-1];
        int[] rest=Arrays.copyOf(b,b.length-1);

        int x=find(superPow(a,rest),10,mod);
        int y=find(a,last,mod);

        return (x*y)%mod;
    }
    public int find(int a,int k,int mod){
        a%=mod;
        int res=1;
        for(int i=0;i<k;i++){
            res=(res*a)%mod;
        }
        return res;
    }
}