import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * https://leetcode-cn.com/problems/combinations
 */
public class CloseCode0077 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        recursion77(res, 1, new LinkedList<>(), n, k);
        return res;
    }

    public void recursion77(List<List<Integer>> res, int first, LinkedList<Integer> list, int n, int k) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
        }
        for (int i = first; i < n + 1; ++i) {
            list.add(i);
            recursion77(res, i + 1, list, n, k);
            list.removeLast();
        }
    }
}
