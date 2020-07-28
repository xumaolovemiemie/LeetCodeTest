import java.util.ArrayList;
import java.util.List;

/*
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class CloseCode0022 {

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        recursion22(list, 0, 0, n, "");
        return list;
    }

    private static void recursion22(List<String> list, int left, int right, int max, String str) {
        if (left == max && right == max) {
            list.add(str);
            return;
        }
        if (left < max) {
            recursion22(list, left + 1, right, max, str + "(");
        }
        if (right < left) {
            recursion22(list, left, right + 1, max, str + ")");
        }
    }
}
