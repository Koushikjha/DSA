class Solution {
    static class Interval {
        int l, r, w, idx;

        Interval(int l, int r, int w, int idx) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.idx = idx;
        }
    }

    static class State {
        long score;
        List<Integer> indices;

        State(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    Interval[] arr;
    int n;
    int[] next;
    State[][] dp;

    public int[] maximumWeight(List<List<Integer>> intervals) {
        n = intervals.size();
        arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.l != b.l)
                return Integer.compare(a.l, b.l);
            return Integer.compare(a.r, b.r);
        });

        next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = findNext(arr[i].r);
        }

        dp = new State[n + 1][5];

        State ans = solve(0, 4);

        int[] result = new int[ans.indices.size()];

        for (int i = 0; i < result.length; i++)
            result[i] = ans.indices.get(i);

        Arrays.sort(result);

        return result;
    }

    private int findNext(int right) {
        int lo = 0;
        int hi = n;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid].l > right)
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }

    private State solve(int i, int remaining) {
        if (i == n || remaining == 0)
            return new State(0, new ArrayList<>());

        if (dp[i][remaining] != null)
            return dp[i][remaining];

        State skip = solve(i + 1, remaining);

        State nextState = solve(next[i], remaining - 1);

        List<Integer> list = new ArrayList<>(nextState.indices);
        list.add(arr[i].idx);

        State take = new State(
            arr[i].w + nextState.score,
            list
        );

        return dp[i][remaining] = better(take, skip);
    }

    private State better(State a, State b) {
        if (a.score != b.score)
            return a.score > b.score ? a : b;

        List<Integer> x = new ArrayList<>(a.indices);
        List<Integer> y = new ArrayList<>(b.indices);

        Collections.sort(x);
        Collections.sort(y);

        for (int i = 0; i < Math.min(x.size(), y.size()); i++) {
            if (!x.get(i).equals(y.get(i)))
                return x.get(i) < y.get(i) ? a : b;
        }

        return x.size() <= y.size() ? a : b;
    }
}