import java.util.ArrayList;
import java.util.List;

/*
 * 51. N皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 提示：
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步，可进可退。（引用自 百度百科 - 皇后 ）
 *
 * https://leetcode-cn.com/problems/n-queens
 */
public class OpenCode0051 {


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        boolean[][] place = new boolean[n][n];
        recursion51(list, 0, 0, n, place);
        return list;
    }

    private void recursion51(List<List<String>> list, int level, int index, int max, boolean[][] place) {
        // TODO: 2020/6/7 实现有问题
        if (level == max || index == max) {
            return;
        }
        if (list.size() == level) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < max; i++) {
            recursion51(list, level, i, max, place);
        }
        recursion51(list, level + 1, 0, max, place);
    }
}
