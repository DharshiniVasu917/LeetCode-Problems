import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        findPaths(root, "", result);

        return result;
    }

    public void findPaths(TreeNode root, String path, List<String> result) {
        path = path + root.val;

        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        path = path + "->";

        if (root.left != null) {
            findPaths(root.left, path, result);
        }

        if (root.right != null) {
            findPaths(root.right, path, result);
        }
    }
}
