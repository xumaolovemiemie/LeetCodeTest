import java.util.Stack;

/*
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * https://leetcode-cn.com/problems/min-stack
 */
public class CloseCode0155 {

    public static class MinStack {
        private final Stack<Integer> stack;
        private final Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.size() == 0 || minStack.peek() >= x) {
                minStack.push(x);
            }
        }

        public void pop() {
            int pop = stack.pop();
            if (pop == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
