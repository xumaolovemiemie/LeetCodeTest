import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 图片见{path:..\img\img0017.png}
 * 说明:
 * 你可以任意选择答案输出的顺序。
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class CloseCode0017 {

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
//        recursion17(0, digits, "", res, map);
        backtrack17("", digits, map, res);
        return res;
    }

    public static void backtrack17(String combination, String nextDigits, Map<Character, String> phone, List<String> res) {
        if (nextDigits.length() == 0) {
            res.add(combination);
        } else {
            Character digit = nextDigits.charAt(0);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                char letter = phone.get(digit).charAt(i);
                backtrack17(combination + letter, nextDigits.substring(1), phone, res);
            }
        }
    }

    public static void recursion17(int level, String digits, String str, List<String> list, HashMap<Character, String> map) {
        if (level == digits.length()) {
            list.add(str);
            return;
        }
        String letters = map.get(digits.charAt(level));
        for (int i = 0; i < letters.length(); i++) {
            recursion17(level + 1, digits, str + letters.charAt(i), list, map);
        }
    }
}
