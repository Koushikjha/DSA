class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        find(nums,0,new ArrayList<>(),list);
        return list;
    }
    void find(int[] arr,int index,List<Integer> current,List<List<Integer>> list){
        list.add(new ArrayList<>(current));
        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1]){
                continue;
            }
            current.add(arr[i]);
            find(arr,i+1,current,list);
            current.remove(current.size()-1);
        }
    }
}