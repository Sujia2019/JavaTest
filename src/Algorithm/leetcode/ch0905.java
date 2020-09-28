package Algorithm.leetcode;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class ch0905 {
    private static List<String> resStrings = new ArrayList<>();
    private static String[] dict = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            return resStrings;
        }
        trackBack("",digits,0);
        return resStrings;
    }
    //回溯法
    public static void trackBack(String temp,String digits,int index){
        if(index == digits.length()){
            resStrings.add(temp);
            return;
        }
                        //       字符串的第index个，转换成数字，再从dict数组中找，再转换成char数组遍历
        for(Character c : dict[Integer.parseInt(String.valueOf(digits.charAt(index)))].toCharArray()){
            trackBack(temp+c,digits,index+1);
        }
    }

    public static void main(String[] args) {
        List<String> list = letterCombinations("");
        System.out.println(list);
    }

}
