/*
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class OpenCode0104 {

    /**
     * 可以理解为求二叉树的深度
     * 如果当前节点为空，则以该节点为根节点的二叉树最大深度为0
     * 如果当前节点不为空，左叶子节点为根节点的最大深度和右叶子节点为根节点的最大深度中较大者加上1
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
