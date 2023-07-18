/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class state {
    int step;
    TreeNode node;
    public state(TreeNode node,int step){
        this.step = step;
        this.node= node;
    }
}
class Solution {
    HashMap<TreeNode,TreeNode> map ;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        map = new HashMap<>();
        dfs(root);
        Queue<state> q = new LinkedList<>();
        q.add(new state(target,0));
        ArrayList<Integer> ans =new ArrayList<Integer>();
        HashSet<TreeNode> seen = new HashSet<>();
        seen.add(target);
        while(!q.isEmpty())
        {
            state s = q.remove();
            if(s.step==k)
                ans.add(s.node.val);
            TreeNode parent = map.get(s.node);
            TreeNode left = s.node.left;
            TreeNode right = s.node.right;
            if(parent!=null && !seen.contains(parent)){
                seen.add(parent);
                q.add(new state(parent,s.step+1));
            }   
            if(left!=null&& !seen.contains(left)){
                seen.add(left);
                q.add(new state(left,s.step+1));
            }
            if(right!=null && !seen.contains(right)){
                seen.add(right);
                q.add(new state(right,s.step+1));
            }
                
            
        }
        return ans;
    }
    public void dfs(TreeNode root){
        if(root.left!=null)
        {
            map.put(root.left,root);
            dfs(root.left);
        }
        
        if(root.right!=null)
        {
            map.put(root.right,root);    
            dfs(root.right);
        }
       
    }
    
}