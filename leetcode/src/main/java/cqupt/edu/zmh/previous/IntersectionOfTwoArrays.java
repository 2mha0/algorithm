package cqupt.edu.zmh.previous;

import org.junit.Test;

import java.util.*;

/***
 * https://leetcode.cn/problems/intersection-of-two-arrays/
 */
public class IntersectionOfTwoArrays {
    // 思路：先排序，然后在使用双指针遍历两个数组，使用set来进行存储使得集合唯一
    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ptr1 = 0;   //指向nums1
        int ptr2 = 0;   //指向nums2
        int len1 = nums1.length;
        int len2 = nums2.length;
        Set<Integer> set = new HashSet<>();
        while (ptr1 < len1 || ptr2 < len2){
            if (ptr1 == len1){
                ptr2++;
            }else if (ptr2 == len2){
                ptr1++;
            }else if(nums1[ptr1] < nums2[ptr2]){
                ptr1++;
            }else if (nums1[ptr1] > nums2[ptr2]){
                ptr2++;
            }else if (nums1[ptr1] == nums2[ptr2]){
                set.add(nums1[ptr1]);
                if (ptr1 < len1 - 1) ptr1++;
                if (ptr2 < len2 - 1) ptr2++;
                else if (ptr1 == len1-1 && ptr2 == len2-1) break;
            }

        }
        int index = 0;
        int[] arr = new int[set.size()];
        for (Integer integer : set) {
            arr[index++] = integer;
        }
        return arr;
    }

    // 思路:将数组1全部添加到set中(因为set不可重复并且无序)，然后遍历数组2判断数组2中的元素是否在数组1中，在就保存
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        for (int i = 0; i < len1; i++) {
            set1.add(nums1[i]);

        }
        for (int i = 0; i < len2; i++) {
            if (set1.contains(nums2[i])){
                set2.add(nums2[i]);
            }
        }

        int[] result = new int[set2.size()];
        int index = 0;
        for (Integer integer : set2) {
            result[index++] = integer;
        }


        return result;
    }

    @Test
    public void test(){
        int[] nums1 = {4,7,9,7,6,7};
        int[] nums2 = {5,0,0,6,1,6,2,2,4};
        int[] intersection = intersection(nums1, nums2);

    }
}
