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
        if(lists.length==0)
            return null;
        boolean first = true;
        ListNode head = null;
        ListNode curr= head;
        while(true)
        {   

            int counter =0;
            int min = 100000;
            int maxIndex=0;
            for(int i=0;i<lists.length;i++){
                if(lists[i]==null){
                    counter++;
                    continue;
                }
                if(lists[i].val<min){
                    min= lists[i].val;
                    maxIndex =i;
                }
                    
            }
         if(counter==lists.length)
             return head;
         if(first)
         {
             head = new ListNode(lists[maxIndex].val);
             curr = head;
             first=false;
         }
         else
         {
             ListNode node = new ListNode(lists[maxIndex].val);
             curr.next = node;
             curr = curr.next;
         }
         lists[maxIndex] = lists[maxIndex].next;
        }
    }
}