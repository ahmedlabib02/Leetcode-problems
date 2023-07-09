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
    public ListNode swapNodes(ListNode head, int k) {
        
        ListNode front = head;
        for(int i=0;i<k-1;i++)
            front = front.next;
        ListNode end = head;
        ListNode temp = front;
        while(temp.next!=null)
        {
            temp=temp.next;
            end= end.next;
        }
        int value = front.val;
        front.val = end.val;
        end.val = value;
        return head;
    }
}