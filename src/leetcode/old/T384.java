package leetcode.old;

import java.util.Random;

/**
 * @Author: tianbin9611
 * @Date: 2020/9/23 11:14
 * @Description: 打乱一个没有重复元素的数组。
 * <p>
 * 示例:
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 */
public class T384 {
    private int[] array;
    private int[] original;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        T384 obj = new T384(nums);
        int[] param_1 = obj.reset();
        int[] param_2 = obj.shuffle();
    }


    public T384(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return array;
    }

    /**
     * 随机交换索引之后的数据
     */
    public int[] shuffle() {

        for (int i = 0; i < original.length; i++) {
            swapAt(original, i, rangeInt(i, original.length));
        }
        return original;
    }

    Random random = new Random();

    /**
     * 生成 i j之间的随机数
     */
    public int rangeInt(int i, int j) {
        return random.nextInt(j - i) + i;
    }

    public void swapAt(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
