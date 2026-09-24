class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] check=new boolean[m][n];
        Queue<int[]> queue=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int[][] dirs={{0,-1},{-1,0},{0,1},{1,0}};
        int ans=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] gr=queue.poll();
                check[gr[0]][gr[1]]=true;
                for(int[] d : dirs){
                    int row=d[0]+gr[0];
                    int col=d[1]+gr[1];
                    if(row>=0 && col>=0 && row<m && col<n && !check[row][col] && grid[row][col]==1){
                        grid[row][col]=2;
                        queue.offer(new int[]{row,col});
                        fresh--;
                    }
                }
            }
            if(!queue.isEmpty()){
                ans++;
            }
            
        }
        return fresh==0?ans:-1;
    }
}