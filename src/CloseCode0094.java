import java.util.ArrayList;
import java.util.List;

/*
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 */
public class CloseCode0094 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        addElement94(list, root);
        return list;
    }

    private static void addElement94(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            addElement94(list, root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            addElement94(list, root.right);
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
