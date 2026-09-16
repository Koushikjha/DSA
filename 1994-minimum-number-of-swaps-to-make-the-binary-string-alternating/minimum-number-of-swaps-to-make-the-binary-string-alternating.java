class Solution {
    public int minSwaps(String p) {
        int zero=0;
        int one=0;
        if(p.length()==1){
            return 0;
        }
        for(char c : p.toCharArray()){
            if(c=='0'){
                zero++;
            }else{
                one++;
            }
        }
        if(Math.abs(zero-one)>1){
            return -1;
        }
        int ans=Integer.MAX_VALUE;
        if(zero>=one){
            ans=Math.min(ans,count(p,0));
        }
        if(one>=zero){
            ans=Math.min(ans,count(p,1));
        }
        return ans;
    }
    public int count(String p,int start){
        int c=0;
        for(int i=0;i<p.length();i++){
            int exp=(i%2==0)?start:1-start;
            if(p.charAt(i)-'0'!=exp){
                c++;
            }
        }
        return c/2;
    }
}