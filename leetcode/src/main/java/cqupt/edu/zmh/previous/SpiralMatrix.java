package cqupt.edu.zmh.previous;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        /**
         *          top(上->下)
         *          1, 2, 3
         *  left    4, 5, 6  right
         * (左->右)  7, 8, 9  (右->左)
         *          10,11,12
         *          bottom(下->上)
         */
        List<Integer> mat = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0, right = cols - 1, bottom = rows - 1, left = 0;
        int index = rows * cols;
        foo:while (index > 0){
            // 从左到右
            for (int i = left; i <= right; i++) {
                mat.add(matrix[top][i]);
                //System.out.print(matrix[top][i] + "\t");
                index--;
                if (index == 0)break foo;// 直接跳出外层循环
            }
            top++;

            // 从上到下
            for (int i = top; i <= bottom; i++) {
                mat.add(matrix[i][right]);
                //System.out.print(matrix[i][right] + "\t");
                index--;
                if (index == 0)break foo;
            }
            right--;

            // 从右到左
            for (int i = right; i >= left; i--) {
                mat.add(matrix[bottom][i]);
                //System.out.print(matrix[bottom][i] + "\t");
                index--;
                if (index == 0)break foo;
            }
            bottom--;

            // 从下到上
            for (int i = bottom; i >= top; i--) {
                mat.add(matrix[i][left]);
                //System.out.print(matrix[i][left] + "\t");
                index--;
                if (index == 0)break foo;
            }
            left++;
        }
        return mat;
    }

    @Test
    public void test(){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> mat = spiralOrder(matrix);
        for (Integer integer : mat) {
            System.out.println(integer);
        }
    }
}
