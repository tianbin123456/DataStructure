//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 647 👎 0


package leetcode.leetcode.editor.cn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class T347TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new T347TopKFrequentElements().new Solution();
        int[] nums={1};
        System.out.println(solution.topKFrequent(nums,1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int num : nums) {
                hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
            }
            //优先队列
            PriorityQueue<Integer> integers = new PriorityQueue<>(Comparator.comparingInt(hashMap::get));
            for (Integer integer : hashMap.keySet()) {
                if (integers.size() < k) {
                    integers.add(integer);
                } else {
                    if (hashMap.get(integer) > hashMap.get(integers.peek())) {
                        integers.add(integer);
                        integers.remove();
                    }
                }
            }
            int[] rst = new int[k];
            for (int i = 0; i < k; i++) {
                rst[i] = integers.poll();
            }
            return rst;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}