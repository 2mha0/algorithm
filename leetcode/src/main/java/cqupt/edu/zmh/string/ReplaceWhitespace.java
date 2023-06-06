package cqupt.edu.zmh.string;

import org.junit.Test;

public class ReplaceWhitespace {
    public String replaceSpace(String s) {
        String result ="";
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (chars[i] != ' '){
                result += chars[i];
            }else {
                result += "%20";
            }
        }
        return result;
    }
    @Test
    public void test(){
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
}
