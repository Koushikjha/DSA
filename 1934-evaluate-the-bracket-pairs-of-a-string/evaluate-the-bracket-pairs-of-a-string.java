class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map=new HashMap<>();
        for(List<String> p : knowledge){
            map.put(p.get(0),p.get(1));
        }
        Stack<Character> st=new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c==')'){
                StringBuilder sb=new StringBuilder();
                while(st.peek()!='('){
                    sb.append(st.pop());
                }
                st.pop();
                String key=sb.reverse().toString();
                if(map.containsKey(key)){
                    for(char x : map.get(key).toCharArray()){
                        st.push(x);
                    }
                }else{
                    st.push('?');
                }
                continue;
            }
            st.push(c);
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}