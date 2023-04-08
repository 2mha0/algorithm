package cqupt.edu.zmh.previous;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/***
 * https://leetcode.cn/problems/ransom-note/
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        Map<Character,Integer> map = new HashMap<>();
        char ch;
        for (int i = 0; i < magazine.length(); i++) {
            ch = magazine.charAt(i);
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            ch = ransomNote.charAt(i);
            map.put(ch,map.getOrDefault(ch,0) - 1);
            if (map.get(ch) < 0){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        String ransomNote = "aa";
        String magazine = "aab";
        boolean result = canConstruct(ransomNote,magazine);
        System.out.println(result);
    }
}
