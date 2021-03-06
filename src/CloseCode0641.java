/*
 * 641. 设计循环双端队列
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 *
 * 提示：
 * 所有值的范围为 [1, 1000]
 * 操作次数的范围为 [1, 1000]
 * 请不要使用内置的双端队列库。
 *
 * https://leetcode-cn.com/problems/design-circular-deque
 */
public class CloseCode0641 {

    public static class MyCircularDeque {
        private ListNode head;
        private ListNode tail;
        private int size;
        private int k;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            this.k = k;
            size = 0;
            head = new ListNode(-1);
            tail = new ListNode(-1);
            head.next = tail;
            tail.pre = head;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (size == k) {
                return false;
            }
            ListNode listNode = new ListNode(value);
            ListNode next = head.next;
            head.next = listNode;
            listNode.next = next;
            next.pre = listNode;
            listNode.pre = head;
            size++;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (size == k) {
                return false;
            }
            ListNode listNode = new ListNode(value);
            ListNode pre = tail.pre;
            tail.pre = listNode;
            listNode.pre = pre;
            pre.next = listNode;
            listNode.next = tail;
            size++;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (size == 0) {
                return false;
            }
            head.next = head.next.next;
            head.next.pre = head;
            size--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (size == 0) {
                return false;
            }
            tail.pre = tail.pre.pre;
            tail.pre.next = tail;
            size--;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            return head.next.val;
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            return tail.pre.val;
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return head.next == tail;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return size == k;
        }

        static class ListNode {
            int val;
            ListNode pre;
            ListNode next;

            public ListNode(int val) {
                this.val = val;
            }
        }
    }
}
