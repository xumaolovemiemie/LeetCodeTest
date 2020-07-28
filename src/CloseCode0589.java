import java.util.ArrayList;
import java.util.List;

/*
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 */
public class CloseCode0589 {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        addElement589(list, root);
        return list;
    }

    private void addElement589(List<Integer> list, Node root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        List<Node> children = root.children;
        if (children == null || children.size() == 0) {
            return;
        }
        for (Node child : children) {
            addElement589(list, child);
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
