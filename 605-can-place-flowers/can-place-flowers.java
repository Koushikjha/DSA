class Solution {
    public boolean canPlaceFlowers(int[] flower, int n) {
        for(int i=0;i<flower.length;i++){
            if(flower[i]==0 && isSafe(flower,i)){
                flower[i]=1;
                n--;
            }
        }
        return (n<=0);
    }
    public boolean isSafe(int[] arr,int i){
        if((i-1>=0 && arr[i-1]==1) || (i+1<arr.length && arr[i+1]==1)){
            return false;
        }
        return true;
    }
}