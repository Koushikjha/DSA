class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> a = new ArrayList<>();
        List<int[]> b = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) a.add(new int[]{i, j});
                if (img2[i][j] == 1) b.add(new int[]{i, j});
            }
        }

        Map<String, Integer> map = new HashMap<>();
        int ans = 0;

        for (int[] p : a) {
            for (int[] q : b) {
                int dr = q[0] - p[0];
                int dc = q[1] - p[1];

                String key = dr + "," + dc;
                int count = map.getOrDefault(key, 0) + 1;
                map.put(key, count);

                ans = Math.max(ans, count);
            }
        }

        return ans;
    
    }
}