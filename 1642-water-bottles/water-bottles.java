class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum=0;
        int emptyrem=0;
        if(numExchange<=0){
            return 0;
        }
        while(numBottles>0){
            sum+=numBottles;
            int rem=numBottles+emptyrem;
            emptyrem=rem%numExchange;
            numBottles=rem/numExchange;
            
                    
        }
        return sum;
    }
}