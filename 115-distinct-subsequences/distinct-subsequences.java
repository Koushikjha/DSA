class Solution {
    String t;
    Integer[][] memo;
    public int numDistinct(String s, String p) {
        t=p.toLowerCase();
        s=s.toLowerCase();
        memo=new Integer[t.length()+1][s.length()];
        return find(s,"",0,t.length());
        
    }
    public int find(String s,String p,int i,int n){
        if(n==0){
            return 1;
        }
        if(i==s.length()){
            return 0;
        }
        if(memo[n][i]!=null){
            return memo[n][i];
        }
        char c=s.charAt(i);
        int a=0;
        int b=0;
        if(c==t.charAt(t.length()-n) ){
            a=find(s,p+c,i+1,n-1);
        }
        b=find(s,p,i+1,n);
        return memo[n][i]=a+b;
    }
}