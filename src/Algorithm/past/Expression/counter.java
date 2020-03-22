package Algorithm.past.Expression;

import java.util.*;

public class counter {

    public int priority(char x){  //比较优先级
        if(x=='+'||x=='-'){
            return 1;
        }
        if(x=='*'||x=='/'){
            return 2;
        }else
            return 0;     //数字优先级最低
    }

    public boolean isoperation(char c){
        if(c=='+'||c=='-'||c=='*'||c=='/')
            return true;
        else return false;
    }

    public void jisuan(Stack stack){
        int res = 0;
        int b=(Integer)stack.peek();
        stack.pop();
        int a=(Integer)stack.peek();
        stack.pop();
        char x = (char)stack.peek();
        stack.pop();
        switch (x){
            case'+':res=a+b;break;
            case'-':res=a-b;break;
            case'*':res=a*b;break;
            case'/':res=a/b;break;
        }
        System.out.println(res);
        stack.push(res);

    }

    public void method(char []bds,int n,Stack stack){
        char []lbds = new char[n];
        char []rbds = new char[n];
        int i=0;
        if(n==1){
            stack.push(bds[i]);
//            jisuan(stack);
            System.out.print(bds[i]);
        }else{
            for(i=0;i<n;i++){
                if (priority(bds[i])==1){
                    stack.push(bds[i]);
                    System.out.print(bds[i]);
                    int ln = i;
                    int rn = n-i-1;
                    for(int j=0;j<ln;j++){
                        lbds[j] = bds[j];
                    }
                    for(int j=0;j<rn;j++){
                        rbds[j] = bds[j+1+i];
                    }
                    method(lbds,ln,stack);
                    method(rbds,rn,stack);
                    break;
                }
            }
        }if(i==n){
            for(i=0;i<n;i++){
                if (priority(bds[i])==2){
                    System.out.print(bds[i]);
                    int ln=i;
                    int rn=n-i-1;
                    for(int j=0;j<ln;j++){
                        lbds[j]=bds[j];
                    }
                    for(int j=0;j<rn;j++){
                        rbds[j]=bds[j+i+1];
                    }
                    method(lbds,ln,stack);
                    method(rbds,rn,stack);
                    break;
                }
            }
        }
    }

    public static void main(String[] args){
        System.out.println("请输入表达式，以'='结束");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char []bds = s.toCharArray();
        int n=bds.length;

        Stack stack = new Stack();

        counter c = new counter();
        c.method(bds,n,stack);






    }


}
