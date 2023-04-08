package cqupt.edu.zmh.previous;

import org.junit.Test;

/***
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-element
 */

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int store = 0, find = 0;    // 分别负责存储与查找val
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val){
                find++;
            }else {
                nums[store] = nums[find];
                find++;
                store++;
            }
        }
        return store;
    }
    @Test
    public void testRemoveElement(){
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int result = removeElement(nums,val);
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i] + "  ");
        }
        System.out.println();
        System.out.println(result);
    }
}
