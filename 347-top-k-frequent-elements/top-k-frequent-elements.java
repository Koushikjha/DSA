class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> freqMap.get(b) - freqMap.get(a)
        );

        for (int key : freqMap.keySet()) {
            pq.offer(key);
        }
        int idx=0;
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[idx++]=pq.poll();
        }
        return ans;
    }
}