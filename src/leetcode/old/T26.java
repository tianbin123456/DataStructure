package leetcode.old;

/**
 * @Author: T
 * @Date: 2020/8/31 14:08
 * @Description: LeetCode 26 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *  
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T26 {
    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates2(a));
        System.out.println(a);
    }

    /**
     * 查看当前值和前值是否相等，相等不重复的数就减一，不相等，插入到首次相等的位置
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int l = nums.length;
        int result = l;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                result--;
            } else {
                nums[i - (l - result)] = nums[i];
            }
        }
        return result;
    }


    /**
     * 双指针，一个记录有效位置，一个记录当前位置。
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        int i = 0;
        int j = i + 1;
        for (; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }

    /**
     * 双指针
     * 优化不需要排序情况
     * 优化数组长度位0，1的情况
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int i = 0;
        int j = i + 1;
        for (; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                //优化不需要重新排序的情况
                if (j - i > 1) {
                    nums[i + 1] = nums[j];
                }
                i++;
            }
        }
        return i + 1;
    }
}
