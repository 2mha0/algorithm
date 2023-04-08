package cqupt.edu.zmh.previous;

import org.junit.Test;

/***
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        // 从第1个位置开始找，因为第0个位置只用保持原状即可
        int store = 1, find  = 1, loopNum = nums.length;
        while (find < loopNum){
            // 如果find和find-1相同就让find一直往后找
            if (nums[find] == nums[find - 1]){
                find++;
            }else {
                // 如果不同就将find指向的值放到store中，然后指针后移
                nums[store] = nums[find];
                store++;
                find++;
            }
        }
        return store;
    }

    @Test
    public void testRemoveDuplicates(){
        int[] nums = {1,2};
        int result = removeDuplicates(nums);
        printArr(nums);
        System.out.println();
        System.out.println(result);
    }

    public void printArr(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "  ");
        }
    }
}
