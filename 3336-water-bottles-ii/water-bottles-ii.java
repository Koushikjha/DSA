class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        return find(0,numBottles,0,numExchange);
    }
    public int find(int sum,int b,int e,int ex){
        if(b==0 && e<ex){
            return sum;
        }
        int drink=0;
        int notdrink=0;
        if(b>0){
            drink=find(sum+b,0,b+e,ex);
        }else{
            notdrink=find(sum,b+1,e-ex,ex+1);
        }
        return Math.max(drink,notdrink);
    }
}