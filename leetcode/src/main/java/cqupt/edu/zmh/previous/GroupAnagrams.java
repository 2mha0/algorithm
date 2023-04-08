package cqupt.edu.zmh.previous;

import org.junit.Test;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.*;

/***
 * https://leetcode.cn/problems/group-anagrams/
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            byte[] bytes = strs[i].getBytes();
            Arrays.sort(bytes);
            String s = Arrays.toString(bytes);
            List<String> list = map.getOrDefault(s, new ArrayList<String>());
            list.add(strs[i]);
            map.put(s,list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    @Test
    public void test(){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);

    }
}
