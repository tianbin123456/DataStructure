package leetcode.old;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: T
 * @Date: 2020/9/2 16:56
 * @Description: T 350 两个数组的交集II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T350 {
    public static void main(String[] args) {
        int[] a = {1,2,2,1};
        int[] b = {2,2};
        int[] intersect = intersect2(a, b);
        for (int x : intersect) {
            System.out.println(x + ",");
        }
    }

    /**
     * 利用hash值的比较
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item : nums1) {
            if (map.containsKey(item)) {
                Integer integer = map.get(item);
                integer++;
                map.put(item, integer);
            } else {
                map.put(item, 1);
            }
        }
        int[] rst = new int[nums1.length];
        int j = 0;
        for (int value : nums2) {
            if (map.containsKey(value)) {
                Integer integer = map.get(value);
                integer--;
                rst[j] = value;
                j++;
                if (integer > 0) {
                    map.put(value, integer);
                } else {
                    map.remove(value);
                }
            }
        }
        return Arrays.copyOfRange(rst, 0, j);
    }

    /**
     * 先排序，然后两个指针指向各自数组，比较，小的后移一位， 相等，同时移一位
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index=0;
        int[] rst = new int[nums1.length];
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                rst[index] = nums1[i];
                i++;
                j++;
                index++;
            } else {
                if (nums1[i] > nums2[j]) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        return Arrays.copyOfRange(rst, 0, index);
    }
}
