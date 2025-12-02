class Solution {
    static final long MOD=1_000_000_007;
    public int countTrapezoids(int[][] points) {
        Map<Integer, Long> count = new HashMap<>();

        for (int[] p : points) {
            count.put(p[1], count.getOrDefault(p[1], 0L) + 1);
        }

        long totalSegments = 0;
        long sumSquares = 0;

        for (long freq : count.values()) {
            if (freq >= 2) {
                long seg = freq * (freq - 1) / 2; 
                seg %= MOD;

                totalSegments = (totalSegments + seg) % MOD;
                sumSquares = (sumSquares + (seg * seg) % MOD) % MOD;
            }
        }

        long S = totalSegments;
        long ans = (S * S % MOD - sumSquares + MOD) % MOD;

        ans = ans * inv2 % MOD; 
        return (int)ans;
    }
    static final long inv2 = (MOD + 1) / 2;
}