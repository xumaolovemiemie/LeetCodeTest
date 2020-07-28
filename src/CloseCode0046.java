import java.util.ArrayList;
import java.util.List;

/*
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * https://leetcode-cn.com/problems/permutations
 */
public class CloseCode0046 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int[] visited = new int[nums.length];
        recursion46(list, nums, new ArrayList<Integer>(), visited);
        return list;
    }

    private static void recursion46(List<List<Integer>> list, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            list.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            tmp.add(nums[i]);
            recursion46(list, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }

}
