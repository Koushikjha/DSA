class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int j=0;

        int ans=Integer.MIN_VALUE;
        for(int house : houses){
            while(j<heaters.length-1 && Math.abs(heaters[j+1]-house)<=Math.abs(heaters[j]-house)){
                j++;
            }
            ans=Math.max(ans,Math.abs(heaters[j]-house));
        }
        return ans;
    }
}