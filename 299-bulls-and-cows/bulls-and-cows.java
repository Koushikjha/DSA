class Solution {
    public String getHint(String secret, String guess) {
        int bulls=0,cows=0;
        int[] s=new int[10];
        int[] c=new int[10];
        for(int i=0;i<guess.length();i++){
            int x=secret.charAt(i);
            int y=guess.charAt(i);
            if(x==y){
                bulls++;
            }else{
                s[x-'0']++;
                c[y-'0']++;
            }
        }
        for(int i=0;i<10;i++){
            cows+=Math.min(s[i],c[i]);
        }
        return bulls+"A"+cows+"B";
    }
}