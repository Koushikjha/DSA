class Solution {
    int[][] dir={{-1,0},{0,-1},{1,0},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] mat) {
        List<List<Integer>> list=new ArrayList<>();
        int m=mat.length;
        int n=mat[0].length;
        boolean[][] pac=new boolean[m][n];
        boolean[][] atl=new boolean[m][n];
        for(int i=0;i<n;i++){
            dfs(mat,pac,0,i,Integer.MIN_VALUE);
        }
        for(int i=0;i<m;i++){
            dfs(mat,pac,i,0,Integer.MIN_VALUE);
        }
        for(int i=0;i<n;i++){
            dfs(mat,atl,m-1,i,Integer.MIN_VALUE);
        }
        for(int i=0;i<m;i++){
            dfs(mat,atl,i,n-1,Integer.MIN_VALUE);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pac[i][j] && atl[i][j]){
                    list.add(Arrays.asList(i,j));
                }
            }
        }
        return list;
    }
    public void dfs(int[][] mat,boolean[][] vis,int row,int col,int prev){
        if(row<0 || col<0 || row>=mat.length || col>=mat[0].length || mat[row][col]<prev || vis[row][col]){
            return;
        }
        vis[row][col]=true;
        for(int[] p : dir){
            dfs(mat,vis,row+p[0],col+p[1],mat[row][col]);
        }
    }
}