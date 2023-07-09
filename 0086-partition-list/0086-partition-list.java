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
    public ListNode partition(ListNode head, int x) {
        ListNode first = head;
        ListNode second = head;
        Queue<Integer> q = new LinkedList<>();
        while(second!=null)
        {  
            // System.out.println(first.val+" "+second.val);
            if(first.val>=x&&(second.val>=x))
            {   
                
                q.add(second.val);
                second= second.next;
            }
            else if(first.val>=x&&second.val<x)
            {

                first.val = second.val;
                second.val = 200;
                second = second.next;
                first = first.next;
            }
            else if(first.val<x)
            {   
                if(first==second)
                    second=second.next;
                first = first.next;
            }
            ListNode dummy = head;
            
        }
        System.out.print(q);
        while(first!=null)
        {
            first.val = q.poll();
            first= first.next;
        }
        return head;
    }
}