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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int ans= left+right;
        int l = diameterOfBinaryTree(root.left);
        int r = diameterOfBinaryTree(root.right);
        return Math.max(Math.max(l,r),ans);
    }

    public int helper(TreeNode root){
        if(root==null)
            return 0;
        int left = 1+helper(root.left);
        int right = 1+helper(root.right);
        return Math.max(right,left);
    }
}