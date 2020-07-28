import java.util.Arrays;

/*
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * https://leetcode-cn.com/problems/valid-anagram
 */
public class CloseCode0242 {

    public static boolean isAnagram(String s, String t) {
        char[] charsS = s.toCharArray();
        Arrays.sort(charsS);
        String newS = new String(charsS);
        char[] charsT = t.toCharArray();
        Arrays.sort(charsT);
        String newT = new String(charsT);
        return newS.equals(newT);
    }
}
