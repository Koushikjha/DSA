class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0]+a[1],b[0]+b[1]));

        for(int i=0;i<Math.min(k,nums1.length);i++){
            pq.offer(new int[]{nums1[i],nums2[0],0});
        }

        while(k-->0 && !pq.isEmpty()){
            int[] curr=pq.poll();
            int num1=curr[0];
            int num2=curr[1];
            int j=curr[2];
            ans.add(Arrays.asList(num1,num2));
            if(j+1<nums2.length){
                pq.offer(new int[]{num1,nums2[j+1],j+1});
            }
        }
        return ans;
    }
}