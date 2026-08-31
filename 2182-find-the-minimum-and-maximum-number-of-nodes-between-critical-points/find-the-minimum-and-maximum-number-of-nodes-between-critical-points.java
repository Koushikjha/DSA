/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int min=Integer.MAX_VALUE;
        int max=0;
        ListNode prev=head;
        ListNode curr=head.next;
        int minLocal=-1;
        int maxLocal=-1;
        int i=1;
        while(curr.next!=null){
            if(curr.val>prev.val && curr.val>curr.next.val){
                System.out.println(i);
                if(maxLocal==-1){
                    minLocal=i;
                    maxLocal=i;
                }else{
                    min=Math.min(min,i-maxLocal);
                    max=Math.max(max,i-minLocal);
                    maxLocal=i;
                }
            }
            if(curr.val<prev.val && curr.val<curr.next.val){
                System.out.println(i);
                if(maxLocal==-1){
                    minLocal=i;
                    maxLocal=i;
                }else{
                    min=Math.min(min,i-maxLocal);
                    max=Math.max(max,i-minLocal);
                    maxLocal=i;
                }
            }
            prev=curr;
            curr=curr.next;
            i++;
        }
        return new int[]{min==Integer.MAX_VALUE?-1:min,max==0?-1:max};
    }
}