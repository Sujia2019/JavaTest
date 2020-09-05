package Algorithm.leetcode;

//给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
//
// 注意：整数序列中的每一项将表示为一个字符串。
//
// 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
//
// 1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
//
//
// 第一项是数字 1
//
// 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
//
// 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
//
// 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
//
// 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
//
//
//
// 示例 1:
//
// 输入: 1
//输出: "1"
//解释：这是一个基本样例。
//
// 示例 2:
//
// 输入: 4
//输出: "1211"
//解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似
//"1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
// Related Topics 字符串
// 👍 503 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public String countAndSay(int n) {
//
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)

import java.util.HashMap;

public class ch0720 {
    public static String countAndSay(int n){
        if(n==1){
            return "1";
        }else{
            StringBuilder last = new StringBuilder("1");
            //循环项
            for(int i=1;i<n;i++){
                char index = last.charAt(0);
                int count =0;
                StringBuilder builder = new StringBuilder("");
                for(int start = 0;start<last.length();start++){
                    char c = last.charAt(start);
                    if(index==c){
                        count++;
                        if(start==last.length()-1){
                            //替换重复部分
                            builder.append(count).append(index);
                            last=builder;
                            break;
                        }
                    }else{
                        builder.append(count).append(index);
                        index = last.charAt(start);
                        start--;
                        count=0;
                    }
                }
            }
            return last.toString();
        }
    }
    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder("123456");
//        sb.replace(0,1,"11");
//        System.out.println(sb);
        System.out.println(countAndSay(7));
    }
}
