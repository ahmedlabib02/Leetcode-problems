/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private TreeNode flattenTree(TreeNode node) {
        
        // Handle the null scenario
        if (node == null) {
            return null;
        }
            
        if (node.left == null && node.right == null) {
            return node;
        }
        
        TreeNode leftTail = this.flattenTree(node.left);
        
        TreeNode rightTail = this.flattenTree(node.right);
        
        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        
        
        return rightTail == null ? leftTail : rightTail;
    }
    
    public void flatten(TreeNode root) {
        
        this.flattenTree(root);
    }
}