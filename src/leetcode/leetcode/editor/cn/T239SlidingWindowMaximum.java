//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 888 👎 0


package leetcode.leetcode.editor.cn;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class T239SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new T239SlidingWindowMaximum().new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(solution.maxSlidingWindow2(nums, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 优先队列
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[0]
            );
            for (int i = 0; i < k; i++) {
                pq.offer(new int[]{nums[i], i});
            }
            int[] ans = new int[nums.length - k + 1];
            ans[0] = pq.peek()[0];
            for (int i = k; i < nums.length; i++) {
                pq.offer(new int[]{nums[i], i});
                while (pq.peek()[1] <= i - k) {
                    pq.poll();
                }
                ans[i - k + 1] = pq.peek()[0];
            }
            return ans;
        }


        /**
         * 双端队列  存储数组下标  按数组大小排序 大在前
         */
        public int[] maxSlidingWindow2(int[] nums, int k) {
            Deque<Integer> deque = new LinkedList<>();
            int length = nums.length;
            for (int i = 0; i < k; i++) {
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }
            int[] rst = new int[length - k + 1];
            rst[0] = nums[deque.peekFirst()];
            for (int i = k; i < length; i++) {
                while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                while (deque.peekFirst() <= i - k) {
                    deque.pollFirst();
                }
                rst[i - k + 1] = nums[deque.peekFirst()];
            }
            return rst;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}