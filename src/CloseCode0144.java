import java.util.ArrayList;
import java.util.List;

/*
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 */
public class CloseCode0144 {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        addElement144(list, root);
        return list;
    }

    private static void addElement144(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left != null) {
            addElement144(list, root.left);
        }
        if (root.right != null) {
            addElement144(list, root.right);
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
