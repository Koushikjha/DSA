class Solution {
    char[][] grid;
    int m;
    int n;
    Boolean[][][] memo;
    public boolean hasValidPath(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        memo=new Boolean[m][n][m+n+1];
        this.grid=grid;
        return find(0,0,0);
    }
    public boolean find(int i,int j,int balance){
        if (balance < 0) {
            return false;
        }

        if (i >= m || j >= n) {
            return false;
        }

        if (grid[i][j] == '(') {
            balance++;
        } else {
            balance--;
        }

        if (balance < 0) {
            return false;
        }

        if (i == m - 1 && j == n - 1) {
            return balance == 0;
        }

        if (memo[i][j][balance] != null) {
            return memo[i][j][balance];
        }

        return memo[i][j][balance] =
            find(i + 1, j, balance) ||
            find(i, j + 1, balance);
    }
}