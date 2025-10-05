class Solution {
    static class Cell{
        int x,y,h;
        Cell(int x,int y,int h){
            this.x=x;
            this.y=y;
            this.h=h;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        int m=heightMap.length;
        int n=heightMap[0].length;
        if(m==0 || n==0){
            return 0;
        }
        PriorityQueue<Cell> pq=new PriorityQueue<>(Comparator.comparingInt(c -> c.h)); 
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            pq.offer(new Cell(i,0,heightMap[i][0]));
            pq.offer(new Cell(i,n-1,heightMap[i][n-1]));
            vis[i][0]=true;
            vis[i][n-1]=true;
        }
        for(int i=0;i<n;i++){
            pq.offer(new Cell(0,i,heightMap[0][i]));
            pq.offer(new Cell(m-1,i,heightMap[m-1][i]));
            vis[0][i]=true;
            vis[m-1][i]=true;
        }
        int res=0;
        int[][] dir={{-1,0},{0,-1},{1,0},{0,1}};
        while(!pq.isEmpty()){
            Cell cell=pq.remove();
            for(int[] p : dir){
                int r=cell.x+p[0];
                int c=cell.y+p[1];
                if(r>=0 && c>=0 && r<m && c<n && !vis[r][c]){
                    vis[r][c]=true;
                    int trap=Math.max(0,cell.h-heightMap[r][c]);
                    res+=trap;
                    pq.offer(new Cell(r,c,Math.max(cell.h,heightMap[r][c])));
                }
            }
        }
        return res;
    }
}