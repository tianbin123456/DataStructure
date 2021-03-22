//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 659 👎 0


package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class T54SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new T54SpiralMatrix().new Solution();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(solution.spiralOrder2(matrix));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 输出最外层数据
         */
        public List<Integer> spiralOrder(int[][] matrix) {
            int rowMax = matrix.length - 1;
            int rowMin = 0;
            int colMax = matrix[0].length - 1;
            int colMin = 0;
            int i = 0;
            int j = 0;
            int n = 0;
            int size = matrix.length * matrix[0].length;
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(matrix[i][j]);
            n++;
            while (n < size) {
                if (i == rowMin) {
                    while (j < colMax) {
                        j++;
                        integers.add(matrix[i][j]);
                        n++;
                    }
                }
                rowMin++;
                if (n == size) {
                    return integers;
                }
                if (j == colMax) {
                    while (i < rowMax) {
                        i++;
                        integers.add(matrix[i][j]);
                        n++;
                    }
                }
                colMax--;
                if (n == size) {
                    return integers;
                }
                if (i == rowMax) {
                    while (j > colMin) {
                        j--;
                        integers.add(matrix[i][j]);
                        n++;
                    }
                }
                rowMax--;
                if (n == size) {
                    return integers;
                }
                if (j == colMin) {
                    while (i > rowMin) {
                        i--;
                        integers.add(matrix[i][j]);
                        n++;
                    }
                }
                colMin++;
                if (n == size) {
                    return integers;
                }
            }
            return integers;

        }

        public List<Integer> spiralOrder2(int[][] matrix) {
            List<Integer> order = new ArrayList<>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return order;
            }
            int rows = matrix.length, columns = matrix[0].length;
            boolean[][] visited = new boolean[rows][columns];
            int total = rows * columns;
            int row = 0, column = 0;
            //方向
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int directionIndex = 0;
            for (int i = 0; i < total; i++) {
                order.add(matrix[row][column]);
                visited[row][column] = true;
                int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
                //超出界限或者已经走过则转换方向
                if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                    directionIndex = (directionIndex + 1) % 4;
                }
                row += directions[directionIndex][0];
                column += directions[directionIndex][1];
            }
            return order;
        }

        /**
         * 输出最外层数据
         */
        public List<Integer> spiralOrder3(int[][] matrix) {
            List<Integer> order = new ArrayList<Integer>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return order;
            }
            int rows = matrix.length, columns = matrix[0].length;
            int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
            while (left <= right && top <= bottom) {
                for (int column = left; column <= right; column++) {
                    order.add(matrix[top][column]);
                }
                for (int row = top + 1; row <= bottom; row++) {
                    order.add(matrix[row][right]);
                }
                if (left < right && top < bottom) {
                    for (int column = right - 1; column > left; column--) {
                        order.add(matrix[bottom][column]);
                    }
                    for (int row = bottom; row > top; row--) {
                        order.add(matrix[row][left]);
                    }
                }
                left++;
                right--;
                top++;
                bottom--;
            }
            return order;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}