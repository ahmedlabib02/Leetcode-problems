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
    ArrayList<String> list;
    public int sumNumbers(TreeNode root) {
        list = new ArrayList<>();
        helper(root,"");
        int ans=0;
        for(String s: list)
        {   System.out.println(s);
            ans+= Integer.parseInt(s);
        }
        return ans;
    }
    public void helper(TreeNode root, String s){
        
        if(root==null){
            
            return;
        }
        if(root.left==null&root.right==null)
            list.add(s+root.val);
        
            
            
        helper(root.left,s+root.val);
        helper(root.right,s+root.val);
    }
}