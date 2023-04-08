package cqupt.edu.zmh.previous;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/***
 * https://leetcode.cn/problems/4sum-ii/
 */
public class FourSum_2 {
    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        Map<Integer,Integer> mapA = new HashMap<>();
        Map<Integer,Integer> mapB = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                mapA.put(i + j, mapA.getOrDefault(i + j, 0) + 1);
            }
        }

        for (int i : nums3) {
            for (int j : nums4) {
                mapB.put(-i-j,mapB.getOrDefault(-i-j,0) + 1);
            }
        }
        for (int val : mapB.keySet()) {
            if (mapA.containsKey(val)) {
                result += mapA.get(val) * mapB.get(val);
            }
        }
        return result;
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }

        for (int i : nums3){
            for (int j : nums4){
                if (map.containsKey(-i-j)){
                    result += map.get(-i-j);
                }
            }
        }
        return result;
    }

    @Test
    public void test(){
        int[] nums1 = {-1,1,1,1,-1};
        int[] nums2 = {0,-1,-1,0,1};
        int[] nums3 = {-1,-1,1,-1,-1};
        int[] nums4 = {0,1,0,-1,-1};
        System.out.println(fourSumCount(nums1,nums2,nums3,nums4));
    }
}
