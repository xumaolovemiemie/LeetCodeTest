import java.util.*;

public class Week5 {
    public static void main(String[] args) {
        int a = new Week5().jump(new int[]{2, 3, 1, 1, 4,});
        System.out.println(">>>" + a);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 4) {
            return lists;
        }
        Arrays.sort(nums);
        int l, r;
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] > target) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                l = j + 1;
                r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (sum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }

        }
        return lists;
    }


    public int jump(int[] nums) {
//        int N = nums.length;
//        int[] res = new int[N];
//        res[N - 1] = 0;
//        for (int i = N - 2; i >= 0; i--) {
//            res[i] = nums[i] + i >= N ? 1 : res[nums[i] + i] + 1;
//            for (int j = i + 1; j < N && res[j] >= res[i] + 1; j++) {
//                res[j] = res[i] + 1;
//            }
//        }
//        for (int i = 1; i <= nums[0]; i++) {
//            if (res[0] > res[i] + 1) {
//                res[0] = res[i] + 1;
//            }
//        }
//        return res[0];
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = (nums[i] + i) >= nums.length ? 1 : res[nums[i] + i] + 1;
            for (int j = i + 1; j < nums.length && res[j] >= res[i] + 1; j++) {
                res[j] = res[i] + 1;
            }
        }
        for (int i = 1; i <= nums[0] && i < nums.length; i++) {
            if (res[0] > res[i] + 1) {
                res[0] = res[i] + 1;
            }
        }
        return res[0];
    }
}
