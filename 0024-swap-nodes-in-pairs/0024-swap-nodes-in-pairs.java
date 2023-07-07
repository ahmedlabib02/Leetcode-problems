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
    public ListNode swapPairs(ListNode head) {
       if(head==null|| head.next==null)
           return head;
       ListNode prev = null;
       ListNode curr = head;
       ListNode next = head.next;
       head = head.next;
       while(next!=null)
       {   
           if(prev!=null)
           {
               prev.next = next;
           }
           prev=curr;
           curr.next=next.next;
           next.next=curr;
           curr = curr.next;
           if(curr==null)
               break;
           next= curr.next; 
       }
        return head;
        
    }
}