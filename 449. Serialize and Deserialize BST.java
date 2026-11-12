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
        if(root==null)return "#";
        //BFS
        Queue<TreeNode>queue=new LinkedList<>();
        StringBuilder str=new StringBuilder();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cnode=queue.poll();
            if(cnode==null){
                str.append("# ");
                continue;
            }
            str.append(cnode.val).append(" ");
            queue.add(cnode.left);
            queue.add(cnode.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null)return null;
        Queue<TreeNode>queue=new LinkedList<>();
        String[]strarray=data.split(" ");
        if(strarray[0].equals("#"))return null;
        TreeNode root=new TreeNode(Integer.parseInt(strarray[0]));
        queue.add(root);
        int index=1;
        while(!queue.isEmpty()){
            TreeNode cnode=queue.poll();
            // "# " meanse next data item is null
            if(!strarray[index].equals("#")){
                TreeNode left=new TreeNode(Integer.parseInt(strarray[index]));
                cnode.left=left;
                queue.add(left);
            }
            index++;
            if(!strarray[index].equals("#")){
                TreeNode right=new TreeNode(Integer.parseInt(strarray[index]));
                cnode.right=right;
                queue.add(right);
            }
            index++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
