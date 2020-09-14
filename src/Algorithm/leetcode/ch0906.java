package Algorithm.leetcode;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。
 */
public class ch0906 {
    public static boolean isValid(String s) {
        if(s==null||s.equals("")){
            return true;
        }
        char[] cs = s.toCharArray();
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');//'('，')'，'{'，'}'，'['，']'
        map.put('}','{');
        map.put(']','[');
        for(int i=0;i<length;i++){
            if(!stack.empty()&&stack.peek()==map.get(cs[i])){
                stack.pop();
            }else{
                stack.push(cs[i]);
            }
        }
        return stack.empty();
    }
    public static void main(String[] args) {
        boolean b = isValid("()");
        System.out.println(b);
    }
}
