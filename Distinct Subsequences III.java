class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);

        if (leftHeight == rightHeight) {
            return (int)Math.pow(2, leftHeight) - 1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int findLeftHeight(TreeNode root) {
        int height = 0;

        while (root != null) {
            height++;
            root = root.left;
        }

        return height;
    }

    public int findRightHeight(TreeNode root) {
        int height = 0;

        while (root != null) {
            height++;
            root = root.right;
        }

        return height;
    }
}
