class Solution {
    public String countAndSay(int n) {
        String p="1";
        for(int i=1;i<n;i++){
            StringBuilder sb=new StringBuilder();
            int s=0;
            int e=p.length();
            char prev='/';
            while(s<e){
                int c=0;
                prev=p.charAt(s);
                while(s<e && p.charAt(s)==prev){
                    c++;
                    s++;
                }
                
                sb.append(String.valueOf(c)+prev);
            }
            
            p=sb.toString();
            System.out.println(p);
        }
        return p;
    }
}