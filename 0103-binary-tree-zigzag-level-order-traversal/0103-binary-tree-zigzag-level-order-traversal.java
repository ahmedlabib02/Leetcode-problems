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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        if(root==null)
            return ans;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        boolean flag= true;
        while(!s.isEmpty())
        {   
            int size = s.size();
            List<Integer> zeby = new ArrayList<>();
            Stack<TreeNode> temp = new Stack<>();
            for(int i=0;i<size;i++)
            {   
                TreeNode node = s.pop();
                if(flag){
                    if(node.left!=null)
                   temp.push(node.left);

                    
                if(node.right!=null)
                    temp.push(node.right);
                }
                else
                {
                    

                    
                if(node.right!=null)
                    temp.push(node.right);
                    if(node.left!=null)
                   temp.push(node.left);
                }
                
                
                zeby.add(node.val);
            }
            flag=!flag;
            s = temp;
            ans.add(zeby);
        }
        return ans;
    }
}