class Solution {
    int MOD=1_000_000_007;
    public int numberOfSets(int n, int k) {
        long[] prev = new long[n];
        long[] curr = new long[n];

        Arrays.fill(prev, 1);

        for (int j = 1; j <= k; j++) {
            long prefix = 0;

            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    prefix = (prefix + prev[i - 1]) % MOD;
                }

                curr[i] = (i == 0 ? 0 : curr[i - 1] + prefix) % MOD;
            }

            long[] temp = prev;
            prev = curr;
            curr = temp;
            Arrays.fill(curr, 0);
        }

        return (int) prev[n - 1];
    }
}