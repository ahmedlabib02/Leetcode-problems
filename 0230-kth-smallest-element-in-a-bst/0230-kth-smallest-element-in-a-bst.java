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
    ArrayList<Integer> zeby;
    public int kthSmallest(TreeNode root, int k) {
        zeby = new ArrayList<>();
        helper(root);
        return zeby.get(k-1);
    }
    public void helper(TreeNode root){
        if(root==null)
            return;
        helper(root.left);
        zeby.add(root.val);
        helper(root.right);
    }
}