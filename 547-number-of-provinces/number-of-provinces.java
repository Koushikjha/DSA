class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < v; j++) {
                if (isConnected[i][j] == 1 && i!=j) {
                    adj.get(i).add(j);
                }
            }
        }
        
        boolean[] visited=new boolean[adj.size()];
        int ans=0;
        for(int i=0;i< adj.size();i++){
            if(!visited[i]){
                ans++;
                bfs(i,visited,adj);
            }
        }
        return ans;
    }
    static void bfs(int node,boolean[] visited,List<List<Integer>> list){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(node);
        visited[node]=true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            for (int neighbor : list.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}