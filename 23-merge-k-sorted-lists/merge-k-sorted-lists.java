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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(ListNode head : lists){
            if(head!=null){
                pq.offer(head);
            }
        }
        while(pq.size()>1){
            ListNode a=pq.poll();
            ListNode b=pq.poll();
            ListNode head=merge(a,b);
            pq.offer(head); 
        }
        return pq.poll();
    }
    public ListNode merge(ListNode a,ListNode b){
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while(a!=null && b!=null){
            if(a.val<b.val){
                curr.next=a;
                a=a.next;
            }else{
                curr.next=b;
                b=b.next;
            }
            curr=curr.next;
        }
        while(a!=null){
            curr.next=a;
            curr=curr.next;
            a=a.next;
        }
        while(b!=null){
            curr.next=b;
            curr=curr.next;
            b=b.next;
        }
        return dummy.next;
    }
}