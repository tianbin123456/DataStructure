//整数数组 nums 按升序排列，数组中的值 互不相同 。
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// nums 肯定会在某个点上旋转 
// -10^4 <= target <= 10^4 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？ 
// Related Topics 数组 二分查找 
// 👍 1197 👎 0


package leetcode.leetcode.editor.cn;


public class T33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new T33SearchInRotatedSortedArray().new Solution();
        int[] ints={3,1};
        System.out.println(solution.search(ints, 1));


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            if(nums.length==1){
                if(target==nums[0]){
                    return 0;
                }else {
                    return -1;
                }
            }
            //查找旋转后的最小值位置
            int flag = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    flag = i + 1;
                }
            }
            if(target<nums[flag]){
                return -1;
            }
            if(flag==0){
                if(nums[nums.length-1]<target){
                    return -1;
                }
                return fenzhi(nums,0,nums.length-1,target);
            }else {
                if(nums[flag-1]<target){
                    return -1;
                }
                if(nums[0]<=target){
                    return fenzhi(nums,0,flag-1,target);
                }else {
                    return fenzhi(nums,flag,nums.length-1,target);
                }
            }
            //二分分治
        }

        public int fenzhi(int[] nums, int start, int end, int target) {
            if (nums[start] > target) {
                return -1;
            }
            if (nums[end] < target) {
                return -1;
            }
            if (nums[start] == target) {
                return start;
            }
            if (nums[end] == target) {
                return end;
            }
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] > target) {
                return fenzhi(nums, ++start, --middle, target);
            }
            if (nums[middle] < target) {
                return fenzhi(nums, ++middle, --end, target);
            }
            return -1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}