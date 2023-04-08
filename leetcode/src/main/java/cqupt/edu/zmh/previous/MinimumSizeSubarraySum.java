package cqupt.edu.zmh.previous;

import org.junit.Test;

import java.util.Vector;

/***
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * https://leetcode.cn/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0,min_length = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target){
                    min_length = Math.min(min_length,j-i+1);
                    break;
                }
            }
        }
        return min_length == Integer.MAX_VALUE? 0:min_length;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int start = 0,end = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        sum += nums[0];
        while (start<n || end<n){
            if(sum < target && start < n-1){
                start++;
                sum += nums[start];
            }else if (sum >= target){
                minLen = Math.min(minLen,start - end + 1);
                sum -= nums[end];
                end++;
            }else {
                break;
            }
        }
        return minLen == Integer.MAX_VALUE? 0:minLen;
    }

    @Test
    public void test(){
        int[] nums = {1212,213,31,32323};
        int target = 7;
        System.out.println(minSubArrayLen2(target, nums));
    }
}
