class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int sum=0;
        for(int i=0;i<n;i++){
            int len1=find(s,i,i);
            int len2=find(s,i,i+1);
            sum+=len1+len2;
        }
        return sum;
    }
    public int find(String p,int s,int e){
        int c=0;
        while(s>=0 && e<p.length() && p.charAt(s)==p.charAt(e)){
            c++;
            s--;
            e++;
        }
        return c;
    }
}