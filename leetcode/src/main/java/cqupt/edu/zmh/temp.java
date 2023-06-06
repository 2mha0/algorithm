package cqupt.edu.zmh;

import org.junit.Test;

public class temp {
    public int[] applyOperations(int[] nums) {
        int pre = 0,last = nums.length;
        while ((pre + 1) < nums.length){
            if (nums[pre] == 0){
                nums[pre] = nums[last];
                nums[last] = 0;
                pre++;
                last--;
            }else if (nums[pre] == nums[pre + 1]){
                nums[pre] *= 2;
                nums[pre + 1] = nums[last];
                nums[last] = 0;
                pre += 2;
                last--;
            }else {
                pre++;
            }
        }
        return nums;
    }

    @Test
    public void test(){
        int[] nums = {1,2,2,1,1,0};
        int[] result = applyOperations(nums);
        System.out.println(result);
    }
}
