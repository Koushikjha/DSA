class Solution {
    int[] charT;
    int[] charS;
    int ans=0;
    int x;
    String t;
    Integer[][] memo;
    public int numDistinct(String s, String p) {
        t=p.toLowerCase();
        s=s.toLowerCase();
        charT=new int[26];
        charS=new int[26];
        for(char c : t.toCharArray()){
            charT[c-'a']++;
        }
        int n=t.length();
        x=t.length();
        memo=new Integer[n+1][s.length()];
        return find(s,"",n,0);
        
    }
    public int find(String s,String p,int n,int i){
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
        if(c==t.charAt(x-n) ){
            a=find(s,p+c,n-1,i+1);
        }
        b=find(s,p,n,i+1);
        return memo[n][i]=a+b;
    }
}