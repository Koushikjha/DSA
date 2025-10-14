class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        List<Integer> ans=new ArrayList<>();
        int top=0;
        int bottom=arr.length-1;
        int left=0;
        int right=arr[0].length-1;
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                ans.add(arr[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                ans.add(arr[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    ans.add(arr[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    ans.add(arr[i][left]);
                }
                left++;
            }
        }
        return ans;  
    }
}