class Solution {
    public String smallestPalindrome(String s) {
        int[] ch=new int[26];
        for(char c : s.toCharArray()){
            ch[c-'a']++;
        }
        String last="";
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<26;i++){
            if(ch[i]%2!=0){
                last=String.valueOf((char)(i+'a'));
            }
            char c=((char)(i+'a'));
            sb.append(String.valueOf(c).repeat(ch[i]/2));
        }
        return sb.toString()+last+sb.reverse().toString();
    }
}