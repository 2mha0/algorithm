package cqupt.edu.zmh.previous;

import org.junit.Test;

import java.util.Arrays;

public class ReverseString2 {
    public String reverseStr(String s, int k) {
        if (s.length() == 1) return s;
        char[] chars = s.toCharArray();
        int len = chars.length;
        for(int i=0;i<len;i+=2*k){
            reverse(chars,i,Math.min(i+k,len)-1);
        }
        return String.copyValueOf(chars);
    }
    public void reverse(char[] ch,int start,int end){
        while(start < end){
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }

    @Test
    public void test(){
        String s = "abcdefg";
        String result = reverseStr(s,8);
        System.out.println(result);
    }
}
