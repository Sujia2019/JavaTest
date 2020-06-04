package Algorithm.leetcode;

import java.util.*;

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
public class ch0604 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> temp = new HashMap<>();
        for (String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String str = String.valueOf(cs);
            if (!temp.containsKey(str)) {
                temp.put(str, new ArrayList<>());
            }
            temp.get(str).add(s);
        }
        return new ArrayList<>(temp.values());
    }
    public static void main(String[] args) {
        String a = "abc";
        String b = "bc";
        System.out.println(a.compareTo(b));
    }
}
