/*
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 说明:
 * 1.尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 2.要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * https://leetcode-cn.com/problems/rotate-array
 */
public class CloseCode0189 {

    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        k = k % nums.length;
        int current = nums[nums.length - k];
        for (int i = 0; i < k * nums.length; i = i + k) {
            int z = nums[i % k];
            nums[i % k] = current;
            current = z;
        }
    }
}
