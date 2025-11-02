class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(0,graph,new ArrayList<>(),res);
        return res;
    }
    public static void dfs(int i,int[][] graph,List<Integer> p,List<List<Integer>> res){
        if(i==graph.length-1){
            p.add(graph.length-1);
            res.add(new ArrayList<>(p));
            p.remove(p.size()-1);
            return;
        }
        for(int boundary : graph[i]){
            p.add(i);
            dfs(boundary,graph,p,res);
            p.remove(p.size()-1);
        }
    }
}