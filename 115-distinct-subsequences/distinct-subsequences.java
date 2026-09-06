class Solution {
    int[] charT;
    int[] charS;
    int ans=0;
    int x;
    Set<String> check;
    String t;
    Integer[][] memo;
    public int numDistinct(String s, String p) {
        check=new HashSet<>();
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
        return find(s,"",n,"",0);
        
    }
    public int find(String s,String p,int n,String mask,int i){
        if(n==0){
            if(!check.contains(mask)){
                
                check.add(mask);
                return 1;
            }
            return 0;
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
        if(c==t.charAt(x-n) && charS[c-'a']<charT[c-'a'] ){
            charS[c-'a']++;
            a=find(s,p+c,n-1,mask+" "+i,i+1);
            charS[c-'a']--;
        }
        b=find(s,p,n,mask,i+1);
        return memo[n][i]=a+b;
    }
}