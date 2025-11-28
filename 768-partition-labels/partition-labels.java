class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list=new ArrayList<>();
        Map<Character,Integer> map=new HashMap<>();
        for(char ch : s.toCharArray()){
            for(int i=s.length()-1;i>=0;i--){
                if(s.charAt(i)==ch){
                    map.put(ch,i);
                    break;
                }
            }
        }
        int i=0;
        while(i<s.length()) {
            char ch = s.charAt(i);
            int lastPos = map.get(ch);
            int j=i;
            while(j<lastPos){
                lastPos=Math.max(lastPos,map.get(s.charAt(j)));
                j++;
            }
            list.add(j - i+1);
            i = j +1;
        }
        return list;
    }
}