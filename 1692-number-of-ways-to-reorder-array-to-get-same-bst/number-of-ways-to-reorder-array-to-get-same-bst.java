class Solution {
    static long[][] ncr;
    static int MOD=1_000_000_007;
    public int numOfWays(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        find(list.size());
        return (int)((get(list)-1+MOD)%MOD);
    }
    public void find(int n){
        ncr=new long[n+1][n+1];
        for(int i=0;i<=n;i++){
            ncr[i][0]=ncr[i][i]=1;
            for(int j=1;j<i;j++){
                ncr[i][j]=(ncr[i-1][j-1]+ncr[i-1][j])%MOD;
            }
        }
    }
    public long get(List<Integer> nums){
        if(nums.size()<=2){
            return 1;
        }
        List<Integer> left=new ArrayList<>();
        List<Integer> right=new ArrayList<>();
        int root=nums.get(0);
        for(int i=1;i<nums.size();i++){
            if(root>nums.get(i)){
                left.add(nums.get(i));
            }else{
                right.add(nums.get(i));
            }
        }
        long leftCount = get(left);
        long rightCount = get(right);

        int l = left.size(), r = right.size();

        long ways = ncr[l + r][l];
        return (((ways * leftCount) % MOD) * rightCount) % MOD;
    }
}