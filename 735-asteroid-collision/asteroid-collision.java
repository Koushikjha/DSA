class Solution {
    public int[] asteroidCollision(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        for(int num : nums){
            boolean equal=false;
            while(!stack.isEmpty() && num<0 && stack.peek()>0){
                if(Math.abs(num)==Math.abs(stack.peek())){
                    stack.pop();
                    equal=true;
                    break;
                }else{
                    int val=stack.pop();
                    if(Math.abs(val)>Math.abs(num)){
                        num=val;
                    }
                }
            }
            if(!equal){
                stack.push(num);
            }
        }
        List<Integer> list=new ArrayList<>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        Collections.reverse(list);
        int[] ans=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}