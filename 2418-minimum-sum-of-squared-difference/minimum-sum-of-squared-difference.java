class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        long k = (long) k1 + k2;
        int max = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        long left = 0, right = max;

        while (left < right) {
            long mid = left + (right - left) / 2;
            long ops = 0;

            for (int d : diff) {
                if (d > mid) ops += d - mid;
            }

            if (ops <= k) right = mid;
            else left = mid + 1;
        }

        long ans = 0;
        for (int d : diff) {
            long val = Math.min(d, left);
            ans += val * val;
            k -= Math.max(0L, d - left);
        }

        for (int i = 0; i < n && k > 0; i++) {
            if (diff[i] >= left && left > 0) {
                ans -= left * left;
                ans += (left - 1) * (left - 1);
                k--;
            }
        }

        return ans;
    }
}