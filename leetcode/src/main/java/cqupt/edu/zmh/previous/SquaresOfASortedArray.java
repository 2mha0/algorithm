package cqupt.edu.zmh.previous;

import org.junit.Test;

import java.util.Arrays;

/***
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/squares-of-a-sorted-array
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares1(int[] nums) {
        int[] numsSquare = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsSquare[i] = nums[i] * nums[i];
        }
        Arrays.sort(numsSquare);
        return numsSquare;
    }

    // 双指针:先找到分界点，一个指针指向最大的负数，另一个指针指向0或者最小的正数。然后向两边移动
    public int[] sortedSquares2(int[] nums) {
        int n = nums.length;
        int[] numsSquare = new int[n];
        int negative = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0)
                negative = i;
            else
                break;
        }
        int nonNegative = negative + 1; // 非负数
        int index = 0; // 新数组的索引
        while (index < n) {
            if (negative == -1)
            {
                numsSquare[index] = nums[nonNegative]*nums[nonNegative];
                index++;
                nonNegative++;
            }else if(nonNegative == n){
                numsSquare[index] = nums[negative]*nums[negative];
                index++;
                negative--;
            } else if (nums[negative]*nums[negative] > nums[nonNegative]*nums[nonNegative])
            {
                numsSquare[index] = nums[nonNegative]*nums[nonNegative];
                index++;
                nonNegative++;
            }else
            {
                numsSquare[index] = nums[negative]*nums[negative];
                index++;
                negative--;
            }
        }
        return numsSquare;
    }

    @Test
    public void test1(){
        int[] nums = {-4,-1,0,3,10};
        long start = System.currentTimeMillis();
        int[] numsSquare = sortedSquares1(nums);
        long end = System.currentTimeMillis();
        System.out.println("花费时间：" + (end - start));
        Tools.printArr(numsSquare);
    }

    @Test
    public void test2(){
//        int[] nums = new int[1000];
//        int n = -50;
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = n;
//            n++;
//        }
        int[] nums = {1};
        int[] numsSquare = sortedSquares2(nums);

        Tools.printArr(numsSquare);

    }
}
