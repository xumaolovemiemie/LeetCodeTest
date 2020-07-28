import java.util.ArrayList;
import java.util.List;

/*
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 */
public class OpenCode0102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        recursion102(1, root, res);
        return res;
    }

    private void recursion102(int index, TreeNode root, List<List<Integer>> res) {
        if (res.size() < index) {
            res.add(new ArrayList<>());
        }
        res.get(index - 1).add(root.val);
        if (root.left != null) {
            recursion102(index + 1, root.left, res);
        }
        if (root.right != null) {
            recursion102(index + 1, root.right, res);
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
