class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> list=new ArrayList<>();
        if(source==destination){
            return true;
        }
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] pre : edges){
            list.get(pre[0]).add(pre[1]);
            list.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> queue=new LinkedList<>();
        boolean[] vis=new boolean[n];
        queue.add(source);
        while(!queue.isEmpty()){
            int u=queue.poll();
            if(vis[u]){
                continue;
            }
            vis[u]=true;
            for(int neb : list.get(u)){
                if(neb==destination){
                    return true;
                }
                if(!vis[neb]){
                    queue.add(neb);
                }
            }
        }
        return false;
    }
}