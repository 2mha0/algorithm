package cqupt.edu.zmh.previous;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/***
 * https://leetcode.cn/problems/two-sum/
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        // key代表数组的值，val代表该值对应的索引
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{i,map.get(target - nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    @Test
    public void test(){
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums,target);
    }
}
