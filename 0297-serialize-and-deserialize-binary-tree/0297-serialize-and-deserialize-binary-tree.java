/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        if(root==null)
            return "";
        StringBuilder sb = new StringBuilder();
        boolean flag=true;
        while(!q.isEmpty()&&flag)
        {
            int size = q.size();
            flag=false;
            
            for(int i=0;i<size;i++)
            {
                TreeNode node = q.remove();
                if(node!=null)
                {
                    if(node.left!=null)
                    flag = true;
                     
                if(node.right!=null)
                    flag=true;
                q.add(node.left);
                q.add(node.right);
                }
                
                if(node==null)
                    sb.append('N');
                else
                    sb.append(node.val);
            
                sb.append(',');
            }
        }
        System.out.print(sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        
        Queue<TreeNode> q2 = new LinkedList<>();
        int p = 0;
        if(data.length()==0)
            return null;
        String[] arr = data.split(",");
        TreeNode head = new TreeNode(Integer.parseInt(arr[p]));
        q2.add(head);
        p++;
        while(!q2.isEmpty()&& p<arr.length-1)
        {
            int size = q2.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node = q2.remove();
                if(!arr[p].equals("N"))
                {   
                    
                    node.left = new TreeNode(Integer.parseInt(arr[p]));
                    q2.add(node.left);
                }     
                p++;
                if(!arr[p].equals("N"))
                {
                    node.right= new TreeNode(Integer.parseInt(arr[p]));
                    q2.add(node.right);
                }
                p++;
            }
        }
        return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));