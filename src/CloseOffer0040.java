import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 剑指Offer40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class CloseOffer0040 {

    /**
     * 思路一：通过排序
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    /**
     * 思路二：通过顶堆实现
     */
    public static int[] getLeastNumbers2(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : arr) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (num < queue.peek()) {
                queue.poll();
                queue.offer(num);
            }
        }
        int[] res = new int[k];
        int index = 0;
        for (int value : queue) {
            res[index++] = value;
        }
        return res;
    }
}
