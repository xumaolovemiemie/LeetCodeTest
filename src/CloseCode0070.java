/*
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * https://leetcode-cn.com/problems/climbing-stairs
 */
public class CloseCode0070 {

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int num = 0;
        int num1 = 2;
        int num2 = 1;
        for (int i = 3; i <= n; i++) {
            num = num1 + num2;
            num2 = num1;
            num1 = num;
        }
        return num;
    }

}
