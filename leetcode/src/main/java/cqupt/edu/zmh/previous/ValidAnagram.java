package cqupt.edu.zmh.previous;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 * https://leetcode.cn/problems/valid-anagram/
 */
public class ValidAnagram {
    // 思路:先对字符串进行排序，然后用equals方法比较
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        byte[] bytes_S = s.getBytes();
        byte[] bytes_T = t.getBytes();
        Arrays.sort(bytes_S);
        Arrays.sort(bytes_T);
        return Arrays.toString(bytes_S).equals(Arrays.toString(bytes_T));
    }

    // 思路:由于字符串只会出现26的英文字母的小写，因此用一个大小为26的int数组存储即可，
    // 数组的索引代表字母的ASCII码(a为0,b为1依次)，值代表出现的个数
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];    // arr的索引代表字母的ASCII码，值代表出现个数
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
           // arr[t.charAt(i) - 'a']--;
            if (--arr[t.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }

    // 思路:使用Map，和getOrDefault方法
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character,Integer> map = new HashMap<>();
        char ch ;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            ch = t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0) - 1);
            if (map.get(ch) < 0){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        String s = "anagram";
        String t = "nagaram";
        boolean anagram = isAnagram(s, t);
        System.out.println(anagram);
    }
}
