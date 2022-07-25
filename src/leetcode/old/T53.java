package leetcode.old;

/**
 * @Author: tianbin9611
 * @Date: 2020/9/18 16:38
 * @Description: 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class T53 {
    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray2(a));
    }

    /**
     * 动态规划
     * 遍历 找出所有当前位置的最大值。
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int pre = 0;
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            max = Math.max(pre, max);
        }
        return max;

    }


    /**
     * 分治，找出左起右起最大值，和最大值
     *
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {


        return getInfo(nums, 0, nums.length - 1).maxSum;
    }

    public static status getInfo(int[] nums, int left, int right) {
        if (left == right) {
            return new status(nums[left], nums[left], nums[left], nums[left]);
        }
        int mid = left + (right - left) / 2;
        status leftStatus = getInfo(nums, left, mid);
        status rightStatus = getInfo(nums, mid + 1, right);

        return pushStatus(leftStatus, rightStatus);
    }

    //合并两个分治区间
    private static status pushStatus(status leftStatus, status rightStatus) {
        int sum = leftStatus.sum + rightStatus.sum;
        //左端起始的最大值，有两种情况，1直接等于左端点的最大，2等于左区间的和加上右区间的左端点起始的值
        int lSum = Math.max(leftStatus.lSum, leftStatus.sum + rightStatus.lSum);
        int rSum = Math.max(rightStatus.rSum, rightStatus.sum + leftStatus.rSum);
        int maxSum = Math.max(Math.max(leftStatus.maxSum, rightStatus.maxSum), leftStatus.rSum + rightStatus.lSum);
        return new status(lSum, rSum, maxSum, sum);
    }

    static class status {
        public status(int lSum, int rSum, int maxSum, int sum) {
            //左端起始子序和最大值
            this.lSum = lSum;
            //右端起始子序和最大值
            this.rSum = rSum;
            //子序和最大值
            this.maxSum = maxSum;
            //和
            this.sum = sum;
        }

        public int getlSum() {
            return lSum;
        }

        public void setlSum(int lSum) {
            this.lSum = lSum;
        }

        public int getrSum() {
            return rSum;
        }

        public void setrSum(int rSum) {
            this.rSum = rSum;
        }

        public int getMaxSum() {
            return maxSum;
        }

        public void setMaxSum(int maxSum) {
            this.maxSum = maxSum;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        /**
         * 左区间最大子序和
         */
        int lSum;
        /**
         * 右区间最大子序和
         */
        int rSum;
        /**
         * 最大子序和
         */
        int maxSum;
        /**
         * 和
         */
        int sum;

    }

}
