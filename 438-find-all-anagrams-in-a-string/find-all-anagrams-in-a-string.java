class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] scount=new int[26];
        int[] pcount=new int[26];
        List<Integer> res=new ArrayList<>();
        for(char c : p.toCharArray()){
            pcount[c-'a']++;
        }
        int window=p.length();
        for(int i=0;i<s.length();i++){
            scount[s.charAt(i)-'a']++;
            if(i>=window){
                scount[s.charAt(i-window)-'a']--;
            }
            if(Arrays.equals(pcount,scount)){
                res.add(i-window+1);
            }

        }
        return res;
    }   
}