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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null|| head.next==null|| k==0)
            return head;
        ListNode dummy= head;
        for(int i=k;i>0;i--)
        {   
            if(dummy.next==null)
                dummy=head;
            else
            dummy=dummy.next;
        }
        ListNode newHead = head;
        while(dummy.next!=null)
        {
            newHead = newHead.next;
            dummy = dummy.next;
        }
        ListNode temp = newHead;
        if(newHead.next == null)
            newHead = head;
        else
        newHead =newHead.next;
        temp.next=null;
        dummy = newHead;
        while(dummy.next!=null)
            dummy=dummy.next;
        if(head.next!=dummy&& head!=newHead){
            dummy.next = head;
        }
          
        // System.out.println(dummy.val);
        return newHead;
    }
}