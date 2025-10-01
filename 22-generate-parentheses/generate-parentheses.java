class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        find(list,"",n,0,0);
        return list;
    }
    void find(List<String> list,String p,int n,int open,int close){
        if(open==n && close==n){
            list.add(p);
            return ;
        }
        if(open<n){
            find(list,p+"(",n,open+1,close);
        }
        if(close<open){
            find(list,p+")",n,open,close+1);
        }
    }
}