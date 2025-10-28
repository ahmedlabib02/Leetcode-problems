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
        int[] res = dfs(root);          // res[0] = notRob, res[1] = rob
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        int[] L = dfs(node.left);
        int[] R = dfs(node.right);

        int rob    = node.val + L[0] + R[0];
        int notRob = Math.max(L[0], L[1]) + Math.max(R[0], R[1]);

        return new int[]{notRob, rob};
    }
}