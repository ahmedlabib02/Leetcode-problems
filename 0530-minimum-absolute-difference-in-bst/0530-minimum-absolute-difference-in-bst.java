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
    ArrayList<Integer> res;
    public int getMinimumDifference(TreeNode root) {
        res= new ArrayList<>();
        helper(root);
        int min = 1000000;
        for(int i=0;i<res.size()-1;i++){
            min = Math.min(Math.abs(res.get(i)-res.get(i+1)),min);
        }
        
        return min;
    }
    public void helper(TreeNode root){
        if(root== null)
            return;
        helper(root.left);
        res.add(root.val);
        helper(root.right);
        
    }
}