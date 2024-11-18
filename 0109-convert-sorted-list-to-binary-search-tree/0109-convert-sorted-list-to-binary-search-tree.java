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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        ListNode last = null;
        ListNode curr = head;
        while(curr.next!=null)
            curr=curr.next;
        last= curr;
        TreeNode root  = helper(head, last);
        return root;
    }
    
    public TreeNode helper(ListNode head, ListNode last)
    {
        
        if(head==null)
            return null;
        // System.out.println(head.val+" "+last.val);
        if(head==last)
            return new TreeNode(head.val);
        ListNode curr= head;
        ListNode prev=null;
        ListNode next = head;
        while(next!=null && next.next!=null)
        {
            if(prev==null)
                prev=head;
            else
                prev= prev.next;
            curr=curr.next;
            next =next.next.next;
        }
        TreeNode root = new TreeNode(curr.val);
        ListNode tailLeft = prev;
        prev.next=null;
        ListNode headRight = curr.next;
        curr.next=null;
        TreeNode rootLeft = helper(head,tailLeft);
        TreeNode rootRight = helper(headRight, last);
        root.left= rootLeft;
        root.right = rootRight;
        return root;
    }
}