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
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        
        int left = helper(root.left);
        int right = helper(root.right);
        int abs = left-right;
        if(Math.abs(abs)>1)
            return false;
        boolean leftSub = isBalanced(root.left);
        boolean rightSub = isBalanced(root.right);
           
        return leftSub && rightSub;
    }
    public int helper(TreeNode root){
        if(root==null)
            return 0;
        int left = 1+helper(root.left);
        int right = 1+helper(root.right);
        return Math.max(left,right);
        
        
    }
}