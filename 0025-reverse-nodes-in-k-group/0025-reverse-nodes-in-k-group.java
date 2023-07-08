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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next == null || k==1)
            return head;
        boolean first =true;
        ListNode x = null;
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr!=null){
            
            ListNode border = prev;
            for(int i=0;i<k-1;i++)
            {   
                if(border.next==null ){
                    // System.out.print("zeby");
                  x.next = prev;  
                  return head;  
                }  
                border = border.next;
            }
            // System.out.println(border.val);
            if(x!=null)
                x.next = border;
            border=border.next;
            x = prev;
            while(curr!=border){
                ListNode next = curr.next;
                curr.next= prev;
                prev= curr;
                curr = next;
            }
            if(first){
                head= prev;
                first =false;
            }
            prev = curr;
            if(curr!=null)
                curr = curr.next;
            if(curr==null)
                x.next =border;
            
            // System.out.println(x.val);
        }
        // System.out.println(head.val+" "+head.next.val+" "+head.next.next.val+" "+head.next.next.next.val+" "+head.next.next.next.next.val);
        return head;
    }
}