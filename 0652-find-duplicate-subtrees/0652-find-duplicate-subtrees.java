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
    List<TreeNode> res;
    HashMap<String,Integer> map;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        res= new ArrayList<>();
        map = new HashMap<>();
        helper(root, "");
        
        return res;
    }
    public String helper(TreeNode root,String s){
        if(root==null)
            return "N";
        s+= root.val;
        s+= ','+helper(root.left,"");
        s+= ','+ helper(root.right,"");
        
        map.put(s,map.getOrDefault(s,0)+1);
        if(map.get(s)==2)
            res.add(root);
        
        return s;
    }
   
}