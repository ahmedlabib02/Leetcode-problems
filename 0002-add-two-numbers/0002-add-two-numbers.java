import java.math.BigInteger;
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb = new StringBuilder();
        ListNode curr = l1;
        while(curr!=null){
            sb.append(curr.val);
            curr = curr.next;
        }
        StringBuilder sb2 = new StringBuilder();
        ListNode curr2 = l2;
        while(curr2!=null){
            sb2.append(curr2.val);
            curr2 =  curr2.next;
        }
        BigInteger big1 =new BigInteger(sb.reverse().toString());
        BigInteger big2 =new BigInteger(sb2.reverse().toString());
        BigInteger num = big1.add(big2);
        StringBuilder res = new StringBuilder();
        res.append(num);
        res.reverse();
        ListNode ans = new ListNode();
        ListNode dummy = ans;
        for(int i=0;i<res.length();i++){
            dummy.val= res.charAt(i)-'0';
            if(i!=res.length()-1){
                ListNode temp = new ListNode();
                dummy.next = temp;
                dummy= dummy.next;
            }
        }
        return ans;
    }
}