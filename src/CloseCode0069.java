/*
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * https://leetcode-cn.com/problems/sqrtx
 */
public class CloseCode0069 {

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int high = x;
        int low = 0;
        int res = -1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if ((long) middle * middle <= x) {
                res = middle;
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return res;
    }

    /**
     * 牛顿迭代法
     */
    public int mySqrt2(int x) {
        long i = x;
        while (i * i > x) {
            i = (i + x / i) / 2;
        }
        return (int) i;
    }
}
