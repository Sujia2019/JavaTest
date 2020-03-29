package Algorithm.leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class ch0329_1 {

    //转换字符串的方式
    public static boolean isPalindrome(int x) {
        if(x<0)
            return false;
        if(x<10){
            return true;
        }
        else{
            String str = String.valueOf(x);
            int n=str.length();
            String s = "";
            int i1=n/2;
            if(n%2!=0){
                for(int i=n-1;i>i1;i--){
                    s+=str.charAt(i);
                }
            }else{
                for(int i=n-1;i>i1-1;i--){
                    s+=str.charAt(i);
                }
            }
            if(str.substring(0,i1).equals(s)){
                return true;
            }else{
                return false;
            }
        }
    }

    //不转换
    private static boolean test(int x){
        if(x<0){
            return false;
        }
        int n=0;
        int x1 = x;
        while(x1!=0){
            n=n*10+x1%10;
            x1=x1/10;
        }
        return n==x;
    }





    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
    }
}
