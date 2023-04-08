package cqupt.edu.zmh.previous;

import org.junit.Test;

import java.util.*;

/***
 * https://leetcode.cn/problems/intersection-of-two-arrays-ii/
 */
public class IntersectionOfTwoArrays_2 {
    // 思路：使用map容器，key代表数组的值，val代表这个值在数组中有多少个。插入数组的时候通过val来获取最小值
    public int[] intersect2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        // key代表数组的值，val代表值有几个
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for (int i : nums1) {
            // 如果没有这个值就为0，有就+1
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2){
            map2.put(i,map2.getOrDefault(i,0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (Integer i : map2.keySet()){
            if (map1.containsKey(i)){
                int min = Math.min(map1.get(i), map2.get(i));
                for (int j = 0; j < min; j++) {
                    list.add(i);
                }
            }
        }
        int[] result = new int[list.size()];
        int index = 0;
        for (int i : list){
            result[index++] = i;
        }
        return result;
    }

    // 思路：上面版本的优化，现将第一个数组放如map，遍历第二个数组如果找到key则
    public int[] intersect3(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        for (int i = 0; i < len1; i++) {
            map.put(nums1[i],map.getOrDefault(nums1[i],0) + 1);
        }
        for (int i = 0; i < len2; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) != 0){
                list.add(nums2[i]);
                map.put(nums2[i],map.getOrDefault(nums2[i],0) - 1);
            }
        }
        int size = list.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    // 思路：排序 + 双指针
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ptr1 = 0,ptr2 = 0;
        int len1 = nums1.length, len2 = nums2.length;
        List<Integer> list = new ArrayList<>();
        while (ptr1 < len1 && ptr2 < len2){
            if (nums1[ptr1] == nums2[ptr2]){
                list.add(nums1[ptr1]);
                ptr1++;
                ptr2++;
            }else if (nums1[ptr1] < nums2[ptr2]){
                ptr1++;
            }else if (nums1[ptr1] > nums2[ptr2]){
                ptr2++;
            }
        }
        int size = list.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    @Test
    public void test(){
        int[] nums1 = {4,9,5,4,4};
        int[] nums2 = {9,4,9,8,4,6};
        int[] result = intersect(nums1,nums2);

    }
}
