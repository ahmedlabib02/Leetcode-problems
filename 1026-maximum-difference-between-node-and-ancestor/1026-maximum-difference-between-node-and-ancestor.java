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
    public int maxAncestorDiff(TreeNode root) {
        return helper(root,0);
    }
    public int helper(TreeNode root, int max){
        if(root==null)
            return max;
        int x =getDiff(root.left,root.val,0);
        int y = getDiff(root.right,root.val,0);
        if(x>max)
            max=x ;
        if(y>max)
            max=y;
        return Math.max(helper(root.left,max),helper(root.right,max));
    }
    public int getDiff(TreeNode root,int num,int max){
        if(root==null)
            return max;
        if(Math.abs(root.val-num)>max)
            max =Math.abs(root.val-num);
        return Math.max(getDiff(root.left,num,max),getDiff(root.right,num,max));
            
    }
}