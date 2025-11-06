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
    public ListNode mergeKLists(ListNode[] list) {
        if(list.length==0){
            return null;
        }
        for(int i=0;i<list.length-1;i++){
            ListNode node=merge(list[i],list[i+1]);
            list[i+1]=node;
        }
        return list[list.length-1];
    }
    public ListNode merge(ListNode a,ListNode b){
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        ListNode x=a;
        ListNode y=b;
        while(x!=null && y!=null){
            if(x.val<y.val){
                curr.next=x;
                x=x.next;
            }else{
                curr.next=y;
                y=y.next;
            }
            curr=curr.next;
        }
        while(x!=null){
            curr.next=x;
            x=x.next;
            curr=curr.next;
        }
        while(y!=null){
            curr.next=y;
            y=y.next;
            curr=curr.next;
        }
        return dummy.next;
    }
}