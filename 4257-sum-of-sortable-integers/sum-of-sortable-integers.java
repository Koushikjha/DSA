class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            boolean valid = true;

            for (int start = 0; start < n && valid; start += k) {
                int end = start + k;
                int drops = 0;
                int dropIndex = -1;

                for (int i = start; i < end; i++) {
                    int next = (i + 1 == end) ? start : i + 1;

                    if (nums[i] > nums[next]) {
                        drops++;
                        dropIndex = i;
                    }
                }

                if (drops > 1) {
                    valid = false;
                    break;
                }

                if (drops == 1) {
                    int shift = dropIndex + 1;
                    for (int j = 0; j < k; j++) {
                        if (nums[start + (shift - start + j) % k] !=
                            sorted[start + j]) {
                            valid = false;
                            break;
                        }
                    }
                } else {
                    for (int j = start; j < end; j++) {
                        if (nums[j] != sorted[j]) {
                            valid = false;
                            break;
                        }
                    }
                }
            }

            if (valid) ans += k;
        }

        return ans;

    }
}