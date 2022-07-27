/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * -10⁴ <= nums[i] <= 10⁴
 * nums 为 无重复元素 的 升序 排列数组
 * -10⁴ <= target <= 10⁴
 * <p>
 * <p>
 * Related Topics 数组 二分查找 👍 1638 👎 0
 */

package leetcode.leetcode.editor.cn;

public class T35SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new T35SearchInsertPosition().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int i = left + ((right - left) >> 1);
                if (nums[i] < target) {
                    left = i + 1;
                } else {
                    right = i - 1;
                }
            }
            return left;
        }

//        public int searchInsert(int[] nums, int target) {
//            int left=0;
//            int right=nums.length-1;
//            int result = 0;
//            while (left<=right) {
//                if(nums[left]>=target){
//                    result= left;
//                    break;
//                }
//
//                if(nums[right]==target){
//                    result= right;
//                    break;
//                }
//                if(nums[right]<target){
//                    result= right+1;
//                    break;
//                }
//                int i = left + (right - left) / 2;
//                if(nums[i]==target){
//                    result= i;
//                    break;
//                }
//                if(nums[i]>target){
//                    right=i-1;
//                }
//                if(nums[i]<target){
//                    left=i+1;
//                }
//            }
//            return result;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}