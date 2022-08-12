/**
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数
 * 不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * <p>
 * Related Topics 数组 哈希表 双指针 二分查找 排序 👍 803 👎 0
 */

package leetcode.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

public class T350IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new T350IntersectionOfTwoArraysIi().new Solution();
        int[] nums11 = {9, 4, 9, 8, 4};
        int[] nums12 = {4, 9, 5};
        int[] intersect = solution.intersect(nums11, nums12);
        for (int i : intersect) {
            System.out.println(i);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * hashMap key-出现次数
         */
        public int[] intersect(int[] nums1, int[] nums2) {
            int[] intersection = new int[Math.min(nums1.length, nums2.length)];
            int index = 0;
            HashMap<Integer, Integer> nums1Map = new HashMap<>();
            for (int i : nums1) {
                nums1Map.put(i, nums1Map.getOrDefault(i, 0) + 1);
            }
            for (int i : nums2) {
                if (nums1Map.containsKey(i)) {
                    Integer integer = nums1Map.get(i);
                    integer--;
                    if (integer <= 0) {
                        nums1Map.remove(i);
                    } else {
                        nums1Map.put(i, integer);
                    }
                    intersection[index] = i;
                    index++;
                }
            }
            return Arrays.copyOf(intersection, index);
        }
        /**
         * 循环遍历
         */

//        public int[] intersect(int[] nums1, int[] nums2) {
//
//            int l1 = nums1.length;
//            int l2 = nums2.length;
//            if (l1 <= l2) {
//                return deal(nums1, nums2);
//            } else {
//                return deal(nums2, nums1);
//            }
//        }
//
//        private int[] deal(int[] nums1, int[] nums2) {
//            int[] rst = new int[nums1.length];
//            int n = nums2.length - 1;
//            for (int i : nums1) {
//                for (int j = 0; j <= n; j++) {
//                    if (nums2[j] == i) {
//                        rst[nums2.length - n - 1] = nums2[j];
//                        nums2[j] = nums2[n];
//                        nums2[n] = rst[nums2.length - n - 1];
//                        n--;
//                        break;
//                    }
//                }
//            }
//            return Arrays.copyOf(rst, nums2.length - n - 1);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}