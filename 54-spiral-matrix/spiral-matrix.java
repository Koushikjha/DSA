class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        List<Integer> list=new ArrayList<>();
        int total=arr.length*arr[0].length;
        int idx=0;
        int top=0,down=arr.length-1,left=0,right=arr[0].length-1;
        while(idx<total){
            for(int i=left;i<=right;i++){
                list.add(arr[top][i]);
                idx++;
            }
            top++;
            for(int i=top;i<=down;i++){
                list.add(arr[i][right]);
                idx++;
            }
            right--;
            if(top<=down){
                for(int i=right;i>=left;i--){
                list.add(arr[down][i]);
                idx++;
                }
                down--;
            }
            if(left<=right){
                for(int i=down;i>=top;i--){
                list.add(arr[i][left]);
                idx++;
                }
                left++;
            }
        }
        return list;
    }
}