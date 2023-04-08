package cqupt.edu.zmh.previous;

public class Tools {
    // 打印一位数组
    public static void printArr(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "  ");
        }
    }

    // 打印二维数组
    public static void printArr2(int[][] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
