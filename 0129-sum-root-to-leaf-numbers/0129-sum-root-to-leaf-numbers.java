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
    
    int ans;
    public int sumNumbers(TreeNode root) {
        
        helper(root,"");
        return ans;
    }
    public void helper(TreeNode root, String s){
        
        if(root==null){
            
            return;
        }
        if(root.left==null&root.right==null)
            ans+=Integer.parseInt(s+root.val);
        
            
            
        helper(root.left,s+root.val);
        helper(root.right,s+root.val);
    }
}