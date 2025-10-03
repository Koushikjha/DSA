class Solution {
    static class Cell {
        int x, y, h;
        Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        if (m == 0) return 0;
        int n = heightMap[0].length;
        if (n == 0) return 0;

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.h));
        for (int i = 0; i < m; i++) {
            pq.add(new Cell(i, 0, heightMap[i][0]));
            pq.add(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            pq.add(new Cell(0, j, heightMap[0][j]));
            pq.add(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int res = 0;
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            for (int[] dir : dirs) {
                int nx = cell.x + dir[0];
                int ny = cell.y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    int trapped = Math.max(0, cell.h - heightMap[nx][ny]);
                    res += trapped;
                    pq.add(new Cell(nx, ny, Math.max(heightMap[nx][ny], cell.h)));
                }
            }
        }

        return res;
    }
}