/*
 * 509. 斐波拉契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 *
 * https://leetcode-cn.com/problems/fibonacci-number
 */
public class CloseCode0509 {

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int n1 = 1;
        int n2 = 0;
        int temp = n1 + n2;
        for (int i = 2; i <= n; i++) {
            temp = n2 + n1;
            n2 = n1;
            n1 = temp;
        }
        return temp;
    }
}
