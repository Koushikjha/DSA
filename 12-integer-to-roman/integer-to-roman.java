class Solution {
    public String intToRoman(int num) {
        Map<Integer,String> map=new HashMap<>();
        map.put(1000,"M");
        map.put(500,"D");
        map.put(100,"C");
        map.put(50,"L");
        map.put(10,"X");
        map.put(5,"V");
        map.put(1,"I");
        map.put(4,"IV");
        map.put(9,"IX");
        map.put(40,"XL");
        map.put(90,"XC");
        map.put(400,"CD");
        map.put(900,"CM");
        TreeSet<Integer> set=new TreeSet<>
                (Arrays.asList(1,4,5,9,10,40,50,90,100,400,500,900,1000));

        StringBuilder sb=new StringBuilder();
        while(num>0){
            int val=set.floor(num);
            num-=val;
            sb.append(map.get(val));
        }
        return sb.toString();
    }
}