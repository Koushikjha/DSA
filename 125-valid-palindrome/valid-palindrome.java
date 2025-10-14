class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)>=97 && s.charAt(i)<=122) || (s.charAt(i)>=48 && s.charAt(i)<=57) ){
                sb.append(s.charAt(i));
            }
        }
        String a=sb.toString();
        String b=sb.reverse().toString();
        return a.equals(b);
    }
}