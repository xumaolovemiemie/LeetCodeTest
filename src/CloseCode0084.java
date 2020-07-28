import java.util.Stack;


/*
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 */
public class CloseCode0084 {


    /**
     * 思路一
     * <p>
     * 1.从左往右遍历，依次记录下最接近并且小于当前柱高的柱子的索引，第一个元素记录索引为-1
     * <p>
     * 2.从右往左遍历，依次记录下最接近并且小于当前柱高的柱子的索引，最后一个元素记录索引为n
     * <p>
     * 3.遍历计算所有柱子所能生成的最大矩形的面积，只需要用右边的索引减去左边索引并且减一，乘以当前柱高，通过对比，最后得出最大面积
     */
    public static int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int length = heights.length;
        int[] leftMinIndex = new int[length];
        leftMinIndex[0] = -1;
        for (int i = 1; i < length; i++) {
            //先假设最近并且小于当前柱子的索引为当前索引前面一位
            int minIndex = i - 1;
            while (minIndex >= 0 && heights[i] <= heights[minIndex]) {
                minIndex = leftMinIndex[minIndex];
            }
            leftMinIndex[i] = minIndex;
        }
        int[] rightMinIndex = new int[length];
        rightMinIndex[length - 1] = length;
        for (int i = length - 2; i >= 0; i--) {
            //先假设最近并且小于当前柱子的索引为当前索引后面一位
            int minIndex = i + 1;
            while (minIndex < length && heights[i] <= heights[minIndex]) {
                minIndex = rightMinIndex[minIndex];
            }
            rightMinIndex[i] = minIndex;
        }
        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            maxArea = Math.max(maxArea, (rightMinIndex[i] - leftMinIndex[i] - 1) * heights[i]);
        }
        return maxArea;
    }

    /**
     * 思路二
     * <p>
     * 1.从前到后依次遍历（栈用于记录元素索引）
     * <p>
     * 2.如果当前元素小于栈顶元素，则栈顶元素出栈，计算出以栈顶元素为高的最大矩形面积
     * <p>
     * 3.直到当前元素小于或者等于栈顶元素后，将当前元素放入栈中，依次循环
     */
    public static int largestRectangleArea2(int[] heights) {
        int res = 0;
        Stack<Integer> deque = new Stack<>();
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        for (int i = 0; i < newHeights.length; i++) {
            while (!deque.isEmpty() && newHeights[deque.peek()] > newHeights[i]) {
                int cur = deque.pop();
                res = Math.max(res, (i - deque.peek() - 1) * newHeights[cur]);
            }
            deque.push(i);
        }
        return res;
    }
}
