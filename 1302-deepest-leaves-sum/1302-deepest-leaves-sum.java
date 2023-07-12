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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int ans=0;
        if(root==null)
            return 0;
        q.add(root);
        while(!q.isEmpty()){
             int size = q.size();
             ans=0;
         for(int i=0;i<size;i++)
            {
                TreeNode node = q.remove();
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
                ans+= node.val;
            }
        }
         return ans;  
    }
}