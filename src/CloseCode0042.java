/*
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 例：由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）
 * 图片见{path:..\img\img0042.png}
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class CloseCode0042 {

    public static int trap(int[] height) {
        int area = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] < leftMax) {
                    area += leftMax - height[left++];
                } else {
                    leftMax = height[left++];
                }
            } else {
                if (height[right] < rightMax) {
                    area += rightMax - height[right--];
                } else {
                    rightMax = height[right--];
                }
            }
        }
        return area;
    }
}
