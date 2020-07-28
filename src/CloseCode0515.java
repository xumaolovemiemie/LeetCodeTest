import java.util.*;

/*
 * 515. 在每个树行中找最大值
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 */
public class CloseCode0515 {

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        recursion515(1, root, res);
        return res;
    }

    private void recursion515(int index, TreeNode root, List<Integer> res) {
        if (res.size() < index) {
            res.add(root.val);
        } else if (res.get(index - 1) < root.val) {
            res.set(index - 1, root.val);
        }
        if (root.left != null) {
            recursion515(index + 1, root.left, res);
        }
        if (root.right != null) {
            recursion515(index + 1, root.right, res);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
