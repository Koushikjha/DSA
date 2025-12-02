class Solution {
    public int findMinArrowShots(int[][] arr) {
        Arrays.sort(arr,(a,b) -> Integer.compare(a[1],b[1]));
        int i=0;
        int ans=0;
        while(i<arr.length){
            int j=i+1;
            while(j<arr.length && arr[i][1]>=arr[j][0]){
                j++;
            }
            i=j;
            ans++;
        }
        return ans;
    }
}