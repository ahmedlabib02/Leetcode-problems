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
    int max;
    public int maxPathSum(TreeNode root) {
        max= Integer.MIN_VALUE;
        helper(root,0);
        return max;
    }
    public void helper(TreeNode root,int sum){
        if(root==null)
            return ;
        sum = maxPath(root.right,0,0)+maxPath(root.left,0,0)+root.val;
        max = Math.max(max,sum);
        helper(root.right,0);
        helper(root.left,0);
    }
    public int maxPath(TreeNode root,int sum,int m){
        if(root==null)
            return m;
        sum+= root.val;
        m = Math.max(m,sum);
        int left = maxPath(root.left, sum, m);
        int right = maxPath(root.right, sum, m);
        return Math.max(left,right);
    }
}
