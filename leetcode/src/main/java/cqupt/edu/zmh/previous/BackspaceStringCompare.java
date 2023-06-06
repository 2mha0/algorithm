package cqupt.edu.zmh.previous;


import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/***
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 * https://leetcode.cn/problems/backspace-string-compare/
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        s.indexOf("#");
        return false;
    }

    @Test
    public void testBackspaceCompare(){
        String s = "ab#c#";
        System.out.println(s.indexOf("#"));
    }
}
