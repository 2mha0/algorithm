package cqupt.edu.zmh.previous;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 * https://leetcode.cn/problems/happy-number/
 */
public class HappyNumber {
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    @Test
    public void test(){
        long start = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (isHappy(i)){
                list.add(i);
            }
        }
        System.out.println("快乐数:");
        for (Integer integer : list) {
            System.out.print(integer + "\t");
        }
        System.out.println();
        long end = System.currentTimeMillis();
        System.out.println("花费时间为：" + (end - start));
    }
}
