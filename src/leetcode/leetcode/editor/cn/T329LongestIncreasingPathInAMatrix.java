//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4 
//解释：最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2： 
//
// 
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4 
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 231 - 1 
// 
// Related Topics 深度优先搜索 拓扑排序 记忆化 
// 👍 448 👎 0


package leetcode.leetcode.editor.cn;

public class T329LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        Solution solution = new T329LongestIncreasingPathInAMatrix().new Solution();
        int[][] matrix = {{1}};
        System.out.println(solution.longestIncreasingPath(matrix));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //左移 右移 上移 下移
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        public int longestIncreasingPath(int[][] matrix) {
            int max = 0;
            int length = matrix.length;
            int length1 = matrix[0].length;
            int[][] rst = new int[length][length1];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length1; j++) {
                    int dep = dep(rst, i, j, matrix, length, length1);
                    max = Math.max(dep, max);
                }

            }
            return max;
        }
        //依次计算每个节点的最长串
        private int dep(int[][] rst, int i, int j, int[][] matrix, int length, int length1) {
            //判断第一次
            if (rst[i][j] == 0) {
                ++rst[i][j];
                for (int[] ints : dir) {
                    int temI = i + ints[0];
                    int temJ = j + ints[1];
                    //控制在范围内
                    if (temI != length && temJ != length1 && temI >= 0 && temJ >= 0) {
                        //符合 递增
                        if (matrix[i][j] < matrix[temI][temJ]) {
                            rst[i][j] = Math.max(rst[i][j], dep(rst, temI, temJ, matrix, length, length1) + 1);
                        }
                    }
                }
            }
            return rst[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}