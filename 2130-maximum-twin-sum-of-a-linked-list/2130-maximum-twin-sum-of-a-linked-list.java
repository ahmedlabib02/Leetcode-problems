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
    public int pairSum(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode prev = fast;
        ListNode curr= fast.next;
        prev.next = null;
        while(curr!=null)
        {
            ListNode next= curr.next;
            curr.next = prev;
            prev = curr;
            curr= next;
        }
        fast = prev;
        int res = 0;
        slow= head;
        while(slow!=null&& fast!=null)
        {
            res = Math.max(res,slow.val+fast.val);
            slow = slow.next;
            fast =fast.next;
        }
         
        
        return res;
    }
}