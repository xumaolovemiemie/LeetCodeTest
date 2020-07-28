/*
 * 367. 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * https://leetcode-cn.com/problems/valid-perfect-square
 */
public class CloseCode0367 {

    public boolean isPerfectSquare(int num) {
        if (num <= 1) {
            return true;
        }
        int high = num, low = 0, res = -1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if ((long) middle * middle <= num) {
                res = middle;
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return res * res == num;
    }

    /**
     * 牛顿迭代法
     */
    public boolean isPerfectSquare2(int num) {
        long i = num;
        while (i * i > num) {
            i = (i + num / i) / 2;
        }
        return i * i == num;
    }
}
