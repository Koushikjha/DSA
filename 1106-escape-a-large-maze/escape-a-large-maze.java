class Solution {
    int size=1_000_000;
    int limit=200*199/2;
    int[][] dir={{-1,0},{0,-1},{1,0},{0,1}};
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Long> block=new HashSet<>();
        for(int[] p : blocked){
            block.add(encode(p[0],p[1]));
        }
        return find(block,source,target) && find(block,target,source);
    }
    public boolean find(Set<Long> blocked,int[] start,int[] end){
        Queue<int[]> queue=new LinkedList<>();
        queue.add(start);
        Set<Long> visited=new HashSet<>();
        visited.add(encode(start[0],start[1]));
        while(!queue.isEmpty() && visited.size()<=limit){
            int[] curr=queue.poll();
            if(curr[0]==end[0] && curr[1]==end[1]){
                return true;
            }

            for(int[] p : dir){
                int row=p[0]+curr[0];
                int col=p[1]+curr[1];

                if(row>=0 && row<size && col>=0 && col<size){
                    long val=encode(row,col);
                    if(!visited.contains(val) && !blocked.contains(val)){
                        visited.add(val);
                        queue.add(new int[]{row,col});
                    }
                }
            }
        }
        return visited.size()>limit;
    }
    public long encode(int x,int y){
        return ((long)x<<20)+y;
    }
}