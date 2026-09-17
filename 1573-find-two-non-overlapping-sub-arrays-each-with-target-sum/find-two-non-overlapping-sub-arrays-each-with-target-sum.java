class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = (int) 1e9;

        int[] best = new int[n];
        Arrays.fill(best, INF);

        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);

        long prefix = 0;
        int minLen = INF;
        int ans = INF;

        for (int i = 0; i < n; i++) {
            prefix += arr[i];

            if (map.containsKey(prefix - target)) {
                int j = map.get(prefix - target);
                int len = i - j;

                if (j >= 0 && best[j] != INF) {
                    ans = Math.min(ans, len + best[j]);
                }

                minLen = Math.min(minLen, len);
            }

            best[i] = minLen;

            map.put(prefix, i);
        }

        return ans == INF ? -1 : ans;
    }
}