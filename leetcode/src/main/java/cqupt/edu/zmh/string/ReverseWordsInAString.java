package cqupt.edu.zmh.string;

import org.junit.Test;

import java.util.*;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        int len = s.length();
        List<String> list = new ArrayList<>();
        int pointer = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0 && s.charAt(i) == ' '){ // 忽略前导空格
                while (s.charAt(i) == ' '){
                    i++;
                    pointer++;
                }
            }
            if (s.charAt(i) == ' '){
                list.add(s.substring(pointer,i));
                pointer = i+1;
            }
            if (i == len-1){    // 如果没有后导空格
                list.add(s.substring(pointer,i+1));
            }
        }
        Collections.reverse(list);
        String result = "";
        int index = 0;
        for (String s1 : list) {
            if (s1.equals("")){
                index++;
                continue;
            }
            if (list.size()-1 != index){
                result += s1;
                result += " ";
            }else {
                // 最后一个元素就不用加" "
                result += s1;
            }
            index++;
        }
        return result;
    }
    @Test
    public void test(){
        String s = "   s    the    sky    i s blue";
        System.out.println(reverseWords(s));
    }
}
