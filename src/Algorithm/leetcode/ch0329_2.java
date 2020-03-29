package Algorithm.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class ch0329_2 {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        String res = strs[0];
        for (String str : strs) {
            //表示必须从0开始包含
            while (str.indexOf(res) != 0) {
                //开始滑动
                res = res.substring(0, res.length()-1);
            }
        }
        return res;
    }

    public static void main(String[] args) {


    }
}
