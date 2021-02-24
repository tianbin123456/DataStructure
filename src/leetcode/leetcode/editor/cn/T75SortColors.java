//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针 
// 👍 793 👎 0


package leetcode.leetcode.editor.cn;


public class T75SortColors {
    public static void main(String[] args) {
        Solution solution = new T75SortColors().new Solution();

        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        System.out.println(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
//            quickSort(nums, 0, nums.length - 1);
            aTraversal(nums);
        }

        /**
         * 一次遍历
         *
         * @param nums
         */
        public void aTraversal(int[] nums) {
            int p0 = 0;
            int p1 = 0;
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                if (nums[i] == 0) {
                    int temp = nums[p0];
                    nums[p0] = nums[i];
                    nums[i] = temp;
                    //如果p0<p1 说明p0位置放的满足p1的值，需要将p0的值放入p1，将p1的值放入i
                    if (p0 < p1) {
                        temp = nums[i];
                        nums[i] = nums[p1];
                        nums[p1] = temp;
                    }
                    p0++;
                    p1++;
                } else if (nums[i] == 1) {
                    int temp = nums[p1];
                    nums[p1] = nums[i];
                    nums[i] = temp;
                    p1++;
                }
            }
        }


        /**
         * 快排
         *
         * @param nums
         * @param start
         * @param end
         */
        public void quickSort(int[] nums, int start, int end) {
            int length = end - start;
            if (length < 1) {
                return;
            }
            int flag = (start + end) / 2;
            int j = end;
            int i = start;
            while (i < j) {
                while (j > flag) {
                    if (nums[j] < nums[flag]) {
                        swap(nums, j, flag);
                        flag = j;
                        break;
                    } else {
                        j--;
                    }
                }
                while (i < flag) {
                    if (nums[i] > nums[flag]) {
                        swap(nums, i, flag);
                        flag = i;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (flag > start) {
                quickSort(nums, start, flag - 1);
            }
            if (flag < end) {
                quickSort(nums, flag + 1, end);
            }
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}