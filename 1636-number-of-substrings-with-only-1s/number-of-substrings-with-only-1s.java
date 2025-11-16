class Solution {
    public int numSub(String s) {
        int streak=0;
        int count=0;
        int mod=1_000_000_007;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                streak++;
                count=(count+streak)%mod;
            }else{
                streak=0;
            }
        }
        return count;
    }
}