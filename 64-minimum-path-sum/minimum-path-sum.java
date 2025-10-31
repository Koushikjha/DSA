class Solution {
    public int minPathSum(int[][] grid) {
        int[][] memo=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            Arrays.fill(memo[i],-1);
        }
        return find(grid,0,0,memo);
    }
    public int find(int[][] grid,int row,int col,int[][] memo){
        if(row==grid.length-1 && col==grid[0].length-1){
            return grid[row][col];
        }
        if(memo[row][col]!=-1){
            return grid[row][col]+memo[row][col];
        }
        int down=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
        if(row<grid.length-1){
            down=find(grid,row+1,col,memo);
        }
        if(col<grid[0].length-1){
            right=find(grid,row,col+1,memo);
        }
        memo[row][col]=Math.min(down,right);
        return grid[row][col]+memo[row][col];
    }
}