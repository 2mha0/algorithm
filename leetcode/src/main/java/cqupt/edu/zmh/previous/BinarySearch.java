package cqupt.edu.zmh.previous;

import org.junit.Test;


/***
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 * 链接：https://leetcode.cn/problems/binary-search
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int low = 0,mid = nums.length /2 ,high = nums.length - 1;
        while (low <= high){
            if (target < nums[mid]){
                high = mid - 1;
                mid = (low + high)/2;
            }else if (target > nums[mid]){
                low = mid + 1;
                mid = (low + high)/2;
            }else{
                return mid;
            }
        }
        return -1;
    }
    @Test
    public void test(){
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int result = search(nums,target);
        System.out.println(result);
    }
}
