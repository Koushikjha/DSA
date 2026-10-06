class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && c==')' && stack.peek()=='('){
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.size();
    }
}