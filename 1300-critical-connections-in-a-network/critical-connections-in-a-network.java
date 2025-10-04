class Solution {
    int timer=1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> adj) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(List<Integer> p : adj){
            int u=p.get(0);
            int v=p.get(1);
            list.get(u).add(v);
            list.get(v).add(u);
        }
        int[] tin=new int[n];
        int[] low=new int[n];
        int[] vis=new int[n];
        List<List<Integer>> bridge=new ArrayList<>();
        dfs(0,-1,tin,low,vis,list,bridge);
        return bridge;
    }
    public void dfs(int node,int parent,int[] tin,int[] low,int[] vis,List<List<Integer>> list,List<List<Integer>> bridge){
        vis[node]=1;
        tin[node]=low[node]=timer;
        timer++;
        for(int neb : list.get(node)){
            if(neb==parent){
                continue;
            }
            if(vis[neb]==0){
                dfs(neb,node,tin,low,vis,list,bridge);
                low[node]=Math.min(low[node],low[neb]);
                if(low[neb]>tin[node]){
                    bridge.add(Arrays.asList(neb,node));
                }
            }else{
                low[node]=Math.min(low[node],low[neb]);
            }
        }
    }
}