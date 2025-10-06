class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    ans+=find(grid,i,j);
                }
            }
        }
        return ans;
    }
    public int find(int[][] grid,int i,int j){
        int[] row={-1,0,1,0};
        int[] col={0,-1,0,1};
        int side=0;
        for(int k=0;k<4;k++){
            int r=i+row[k];
            int c=j+col[k];
            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]==1){
                side++;
            }
        }
        return 4-side;
    }
}