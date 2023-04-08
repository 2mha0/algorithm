package cqupt.edu.zmh.previous;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * https://leetcode.cn/problems/3sum/
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 3) return null;
        int a=0,b=1,c=len-1;
        List<List<Integer>> list = new ArrayList<>();
        while (a <= len - 3){
            if (a>0 && nums[a]==nums[a-1]){
                a++;
                continue;
            }
            b = a + 1;
            c = len - 1;
            int sum = nums[a] + nums[b] + nums[c];
            if (sum == 0){
                list.add(Arrays.asList(nums[a],nums[b],nums[c]));
                while (b<c && nums[b]==nums[b+1]) b++;
                while (b<c && nums[c]==nums[c-1]) c--;
                b++;
                c--;
            }else if (sum > 0) c--;
            else if (sum < 0) b++;
            a++;
        }
        return list;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }


    @Test
    public void test(){
        int[] nums = {-4,-4,-4,8};
        List<List<Integer>> list = threeSum(nums);
    }
}
