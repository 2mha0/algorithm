package cqupt.edu.zmh.previous;

import org.junit.Test;

/***
 * 1 ， 2， 3， 4
 * 12，13，14， 5
 * 11，16，15， 6
 * 10， 9， 8， 7
 * 输入：4
 * 输出：[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]
 *
 *
 *  1, 2, 3, 4, 5
 * 16,17,18,19, 6
 * 15,24,25,20, 7
 * 14,23,22,21, 8
 * 13,12,11,10, 9
 *
 * 1	2	3	4	5	6
 * 20	21	22	23	24	7
 * 19	32	33	34	25	8
 * 18	31	36	35	26	9
 * 17	30	29	28	27	10
 * 16	15	14	13	12	11
 *
 * https://leetcode.cn/problems/spiral-matrix-ii/
 */
public class SpiralMatrix_2 {
    public int[][] generateMatrix(int n) {
        /*
         *              top(上->下)
         *          1 ， 2， 3， 4
         * left     12，13，14， 5
         * (左->右)  11，16，15， 6     right
         *          10， 9， 8， 7     (右->左)
         *              bottom(下->上)
         */
        int[][] matrix = new int[n][n];
        int count = 1; // 负责计数，从1～n
        int loop = n*n;
        int top = 0, right = n - 1, bottom = n - 1, left = 0; // 由于数组下标从0开始，所以要 -1
        while (count <= loop){
            // 顺时针循环
            // 从左到右
            for (int i = left; i <= right; i++) {
                matrix[top][i] = count;
                count++;
            }
            top++;

            // 从上到下
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = count;
                count++;
            }
            right--;

            // 从右到左
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = count;
                count++;
            }
            bottom--;

            // 从下到上
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = count;
                count++;
            }
            left++;
        }
        return matrix;
    }
    @Test
    public void test(){
        long start = System.currentTimeMillis();
        int[][] arr = new int[6][6];
        arr = generateMatrix(6);
        Tools.printArr2(arr);
        long end = System.currentTimeMillis();
        System.out.println("花费时间：" + (end - start));
    }
}
