class Solution {
    int m,n;
    int[][] gr={{-1,0},{0,-1},{1,0},{0,1}};
    public int getMaximumGold(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0){
                    boolean[][] vis=new boolean[m][n];
                    ans=Math.max(ans,find(grid,i,j,vis));
                }
            }
        }
        return ans;
    }
    public int find(int[][] grid,int row,int col,boolean[][] vis){
        if(row<0 || row>=m || col<0 || col>=n || vis[row][col] || grid[row][col]==0){
            return 0;
        }
        vis[row][col] = true; 
        int maxGold = 0;

        for (int[] d : gr) {
            int r = row + d[0];
            int c = col + d[1];
            maxGold = Math.max(maxGold, find(grid, r, c, vis));
        }

        vis[row][col] = false; 
        return grid[row][col] + maxGold;
    }
}