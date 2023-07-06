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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = head;
        if(right==left)
            return head;  
        ListNode temp=head;
        for(int i=0;i<left-1;i++){
            if(i<left-2)
                temp= temp.next;
            dummy=dummy.next;
        }
            
        ListNode last = dummy;
        
        for(int i=left;i<=right;i++)
        {    
            last = last.next;
        }
        
        ListNode temp2 = dummy;
        ListNode curr = dummy.next;
        ListNode next = dummy.next.next;
        ListNode prev = dummy;
        prev.next=null;
        while(curr!=last)
        {
          curr.next=prev;
          prev= curr;  
          curr= next;
          if(next!=null)
            next = next.next;
        }
        temp.next=prev;
        temp2.next = last;
        if(left==1)
          head=prev;  
               
        return head;  
    }
}