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
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        boolean left= isMax(root.left,root.val);
        boolean right = isMin(root.right,root.val);
        if(left&&right)
            return isValidBST(root.left)&&isValidBST(root.right);
        return false;
    }
    public boolean isMax(TreeNode root,int max){
        if(root==null)
            return true;
        if(root.val>=max)
            return false;
        return isMax(root.left,max)&&isMax(root.right,max);
    }
    public boolean isMin(TreeNode root,int min){
        if(root==null)
            return true;
        if(root.val<=min)
            return false;
        return isMin(root.left,min)&&isMin(root.right,min);
    }
}