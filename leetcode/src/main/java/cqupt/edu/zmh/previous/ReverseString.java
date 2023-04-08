package cqupt.edu.zmh.previous;

import org.junit.Test;

import java.util.Arrays;

/***
 * https://leetcode.cn/problems/reverse-string/
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int len = s.length;
        int n = len / 2;
        char temp;
        for (int i = 0; i < n; i++) {
            temp = s[i];
            s[i] = s[len-i-1];
            s[len-i-1] = temp;
        }
    }

    @Test
    public void test(){
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
