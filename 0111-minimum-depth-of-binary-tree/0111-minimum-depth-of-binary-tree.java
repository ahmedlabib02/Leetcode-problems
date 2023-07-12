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
    public int minDepth(TreeNode root) {
        return helper(root,0);
    }
    public int helper(TreeNode root,int min){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return min+1;
        
        
        if(root.left!=null&&root.right!=null){
            int l = helper(root.left,min+1);
            int r = helper(root.right,min+1);
            return Math.min(l,r);
        }
         else if(root.left!=null)
             return helper(root.left,min+1);
        else
            return helper(root.right,min+1);
         
        
    }
  
}