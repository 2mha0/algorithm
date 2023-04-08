package cqupt.edu.zmh.previous;

import org.testng.annotations.Test;

import java.util.Arrays;

/***
 * https://leetcode.cn/problems/assign-cookies/
 */
public class AssignCookies {
    // 错误思路：如果不排序，先分配饼干值和胃口值相等的情况，再分配饼干值大于胃口值的情况
    // 会导致饼干值大的被浪费，测试用例：g=[1,50,50]  s=[100,49]
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        // 先分配饼干值和胃口值相等的情况
        int gLen = g.length;
        int sLen = s.length;
        for (int i = 0; i < gLen; i++) {
            for (int j = 0; j < sLen; j++) {
                if (g[i] != -1 && s[j] != -1 && g[i] == s[j]){
                    g[i] = -1;
                    s[j] = -1;
                    count++;
                }
            }
        }

        // 再分配饼干值大于胃口值的情况
        for (int i = 0; i < gLen; i++) {
            for (int j = 0; j < sLen; j++) {
                if (g[i] != -1 && s[j] != -1 && g[i] < s[j]){
                    g[i] = -1;
                    s[j] = -1;
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void test(){
        int[] g = {1,50,50};  // 胃口值
        int[] s = {100,49,49};  // 饼干尺寸
        System.out.println(findContentChildren(g,s));
    }
}
