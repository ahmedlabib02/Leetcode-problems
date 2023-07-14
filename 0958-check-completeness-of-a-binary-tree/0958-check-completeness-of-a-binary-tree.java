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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)
            return true;
        root.val=1;
        int val = 0;
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                
                   
                TreeNode node = q.remove();
                if(node.val-val!=1)
                    return false;
                val = node.val; 
                if(node.left!=null)
                {
                    node.left.val = node.val*2;
                    q.add(node.left);
                }
                if(node.right!=null)
                {
                    node.right.val = (node.val*2)+1;
                    q.add(node.right);
                }    
            }
        }
        return true;
    }
}