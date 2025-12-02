class Solution {
    public String simplifyPath(String path) {
        String[] parts=path.split("/");
        Stack<String> stack=new Stack<>();
        for(String part : parts){
            if(part.isEmpty() || part.equals(".")){
                continue;
            }
            if(part.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }else{
                stack.push(part);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,"/"+stack.pop());
        }
        return sb.length()>0 ? sb.toString() : "/";
    }
}