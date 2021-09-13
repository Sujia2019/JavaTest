package Algorithm.leetcode;

import java.util.Stack;

/**
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * ( * )
 *
 */
public class ch0912 {
    public static void main(String[] args) {
        String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        String s2 = "(*))";// true
        String s3 = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        String s4 = "()";//true
        String s5 = "(((((()*)(*)*))())())(()())())))((**)))))(()())()";

        // true
        String s6 = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        System.out.println(checkValidString(s6));
    }

    // 栈存下标  ！！
    public static boolean checkValidString(String s) {
        int start =0;
        int end = s.length()-1;
        if(s.length()==0){
            return true;
        }
        if(s.equals("*")){
            return true;
        }
        if(s.charAt(start) == ')'){
            return false;
        }
        if(s.charAt(end) == '('){
            return false;
        }
        Stack<Integer> stack1 = new Stack<>(); // 存放左括号
        Stack<Integer> stack2 = new Stack<>(); // 存放 *
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) == '('){
                stack1.push(i);
            }else if(s.charAt(i) == '*'){
                stack2.push(i);
            }else{ // 如果是 )
                // 先检查左括号的栈
                if(!stack1.isEmpty()){
                    stack1.pop();
                }else if(!stack2.isEmpty()){ //检查通配符是否够用
                    stack2.pop();
                }else{
                    // 两个都为空,说明右括号太多了
                    return false;
                }
            }
        }
        // 左括号太多了
        while (!stack1.isEmpty()){
            int left = stack1.peek();
            // 通配符不为空
            if (!stack2.isEmpty()){
                // 左括号在通配符右边
                if (left>stack2.peek()){
                    return false;
                }else{
                    stack1.pop();
                    stack2.pop();
                }
            }else{
                // 通配符不够用
                return false;
            }
        }
        return true;
    }
    // 大神的代码
    public static boolean test(String s){
        int l = 0;  //l代表左括号比较多，星号作为右括号时左括号的数量
        int h = 0;  //h代表右括号比较多，星号作为左括号时左括号的数量
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == '(') { // ( l和h都增加
                l++;
                h++;
            } else if (tmp == ')') { // ） 如果l不为空，说明左括号比较多，则l--.同时因为h也是代表左括号的数量，所以相应的h--
                if (l > 0) {
                    l--;
                }
                h--;
            } else if (tmp == '*') { // * 如果l不为空，说明左括号比较多，星号作为右括号则l--.同时h是星号作为左括号，所以h++
                if (l > 0) {
                    l--;
                }
                h++;
            }
            if (h < 0) { // h < 0.说明将*当做左括号也不够，返回false
                return false;
            }
        }
        return l == 0; //  同时查看l == 0，如果不等于0，说明将星号视为右括号也不够左括号数量。
    }
}
//  (*))
//  (((((
//  (((((((*(
//  *((((*(*(**(())(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()



// "*****)*)(****"
// ()(), (((((()))))    (*(*(*)*)*)(*)  (*****)))))

// (****)))))*****
// ()))))))*******

// "***)))**)))"

// "****(("
// ***(((
// (((***

// (*(*(*(*(*(*))))))))