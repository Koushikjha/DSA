class Solution {
    public long shadowPairs(int[] nums) {
        ArrayList<Integer> st = new ArrayList<>();
        long ans = 0;

        for (int x : nums) {
            int lo = 0, hi = st.size();

            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (st.get(mid) < x)
                    lo = mid + 1;
                else
                    hi = mid;
            }

            ans += lo;

            while (!st.isEmpty() && st.get(st.size() - 1) > x) {
                st.remove(st.size() - 1);
            }

            st.add(x);
        }

        return ans;
    }
}