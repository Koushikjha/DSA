class Solution {
    public int countCollisions(String s) {
        int left=0;
        while(left<s.length() && s.charAt(left)=='L'){
            left++;
        }
        int right=s.length()-1;
        while(right>=0 && s.charAt(right)=='R'){
            right--;
        }
        int count=0;
        for(int i=left;i<=right;i++){
            if(s.charAt(i)!='S'){
                count++;
            }
        }
        return count;
    }
}