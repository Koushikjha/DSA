class Solution {
    public boolean isValid(String s) {
        while(s.contains("()") || s.contains("[]") || s.contains("{}")){
            s=s.replace("()","");
            s=s.replace("[]","");
            s=s.replace("{}","");
        }
        if(s.length()==0){
            return true;
        }
        return false;
    }
}