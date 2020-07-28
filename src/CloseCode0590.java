import java.util.*;

/*
 * 590. N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 */
public class CloseCode0590 {

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        addElement590(list, root);
        return list;
    }

    private void addElement590(List<Integer> list, Node root) {
        if (root == null) {
            return;
        }
        List<Node> children = root.children;
        if (children != null && children.size() > 0) {
            for (Node child : children) {
                addElement590(list, child);
            }
        }
        list.add(root.val);
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
