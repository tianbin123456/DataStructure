package leetcode;

/**
 * @Author: T
 * @Date: 2020/8/31 14:08
 * @Description: LeetCode 21
 */
public class T21 {
    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates2(a));
        System.out.println(a);
    }

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

    //双指针
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

    public static int removeDuplicates3(int[] nums) {
        int i = 0;
        int j = i + 1;
        for (; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                //优化不需要重新排序的情况
                if (j - i > 0) {
                    nums[i + 1] = nums[j];
                }
                i++;
            }
        }
        return i + 1;
    }
}
