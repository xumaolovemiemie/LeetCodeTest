import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/*
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class CloseCode0020 {

    public static boolean isValid(String s) {
        Map<Character, Character> map = new TreeMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                if (stack.size() == 0 || !map.get(aChar).equals(stack.pop())) {
                    return false;
                }
            } else {
                stack.push(aChar);
            }
        }
        return stack.size() == 0;
    }

}
