package cqupt.edu.zmh.previous;

import org.junit.Test;

/***
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * https://leetcode.cn/problems/move-zeroes/
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        // find指向未处理的头部，store指向已处理的尾部
        int find = 0, store = 0, temp;
        while (find < nums.length){
            if (nums[find] != 0){
                temp = nums[store];
                nums[store] = nums[find];
                nums[find] = temp;
                find++;
                store++;
            }else {
                find++;
            }
        }
    }
    @Test
    public void testMoveZeroes(){
        int[] nums = {1,0,1,3,12};
        moveZeroes(nums);
        Tools.printArr(nums);
    }
}
