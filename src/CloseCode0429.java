import java.util.ArrayList;
import java.util.List;

/*
 * 429. N叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 说明:
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 *
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 */
public class CloseCode0429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) {
            addElement429(list, root, 0);
        }
        return list;
    }

    private void addElement429(List<List<Integer>> list, Node root, int level) {
        if (list.size() <= level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        for (Node child : root.children) {
            addElement429(list, child, level + 1);
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
