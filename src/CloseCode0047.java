import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * https://leetcode-cn.com/problems/permutations-ii
 */
public class CloseCode0047 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int[] visited = new int[nums.length];
        recursion47(list, nums, new ArrayList<Integer>(), visited);
        return list;
    }

    private static void recursion47(List<List<Integer>> list, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            list.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
                continue;
            }
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            tmp.add(nums[i]);
            recursion47(list, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}
