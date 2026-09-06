class Solution {
    public int countNodes(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        if(root == null)
            return 0;

        q.offer(root);

        while(!q.isEmpty()){

            int size = q.size();

            for(int i = 0; i < size; i++){

                TreeNode node = q.poll();

                list.add(node.val);

                if(node.left != null)
                    q.offer(node.left);

                if(node.right != null)
                    q.offer(node.right);
            }
        }

        return list.size();
    }
}
