import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] nums = new int[]{7, 1, 5, 6, 2, 4, 3};
        insertionSort(nums);
        System.out.println("结果为" + Arrays.toString(nums));
    }

    /**
     * 冒泡排序（Bubble Sort）
     * <p>
     * 思路：
     * <p>
     * 1. 数组分为未排序区和已排序区，已排序区在数组末尾，遍历数组的未排序区，从前到后依次遍历
     * <p>
     * 2. 如果相邻两元素大小和位置不一致，就交换位置，每次遍历会把最大的一个元素移动到最后
     * <p>
     * 3. 优化：如果有一次遍历的时候没有元素发生位置交换，说明已经排序完成
     */
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean isSwap = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }

    /**
     * 插入排序（Insertion Sort）
     * <p>
     * 思路：
     * <p>
     * 1. 数组分为未排序区和已排序区，已排序区在数组的前端，每次从未排序区中选择一个元素，依次和已排序区进行比较，从后往前比较
     * <p>
     * 2. 如果已排序区当前位置的元素比选择的元素大，则后移一位，否则，在此位置插入选择的元素
     */
    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > temp) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = temp;
        }
    }

    /**
     * 选择排序（Selection Sort）
     * <p>
     * 思路
     * <p>
     * 1. 对数组进行数组长度次遍历，用一个值来记录最小值的索引，遍历开始的索引为当前遍历的次数减一
     * <p>
     * 2. 遍历完成后将起始遍历位置的值和最小值位置的值进行交换
     */
    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }
}
