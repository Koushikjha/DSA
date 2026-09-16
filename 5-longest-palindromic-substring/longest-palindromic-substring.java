class Solution {
    public String longestPalindrome(String s) {
        int se=0;
        int e=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            int len1=find(s,i,i+1);
            int len2=find(s,i,i);
            int len=Math.max(len1,len2);
            if(len>e-se){
                se=i-(len-1)/2;
                e=i+len/2;
            }
        }
        return s.substring(se,e+1);
    }
    public int find(String s,int i,int j){
        int len;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }
}