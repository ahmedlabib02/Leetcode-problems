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
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> dp = new HashMap<>();
        int sum  =dp(root,dp);
        // System.out.println(dp);
        return sum;
    }
    public int dp(TreeNode node , HashMap<TreeNode, Integer> dp )
    {
        if(node==null)
            return 0;
        if(dp.containsKey(node))
            return dp.get(node);
        int value = node.val;
        TreeNode left = node.left;
        TreeNode right = node.right;
        int take =value;
        if(left!=null)
            take += dp(left.left, dp)+ dp(left.right, dp);
        if(right !=null)
            take+=dp(right.left, dp) + dp(right.right, dp) ;
        int skip = dp(left, dp) + dp(right, dp);
        dp.put(node, Math.max(take, skip));
        return dp.get(node);
    }
}