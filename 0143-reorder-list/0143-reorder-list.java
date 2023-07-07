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
    public void reorderList(ListNode head) {
        ListNode dummy = head;
        int count =0;
        while(dummy!=null){
            dummy= dummy.next;
            count++;
        }
        if(count<=2)
            return;
        dummy=head;
        count=count/2 + count%2;
        while(count>1){
            dummy = dummy.next;
            count--;
        }
        ListNode head2 = dummy.next;
        dummy.next = null;
        ListNode prev = head2;
        ListNode curr = head2.next;
        prev.next =null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next=prev;
            prev = curr;
            curr = next;
        }
        head2 = prev;
        dummy = head;
        curr= head2;
        
        while(dummy!=null )
        {
            ListNode temp = dummy.next;

            ListNode temp2 = null;
            if(curr!=null)
                temp2 = curr.next;
            dummy.next = curr;
            if(curr!=null)
                curr.next = temp;
            dummy=temp;
            curr= temp2;
        }
        
        }
    
}