class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int idx = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] != a[0] ? b[0] - a[0] : b[1] - a[1]
        );

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) pq.poll();
            if (i >= k - 1) ans[idx++] = pq.peek()[0];
        }

        return ans;
    }
}