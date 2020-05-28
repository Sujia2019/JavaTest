package DesignPattern;

public class test {
    public static void foo(int a,int b,int x){
        if(a > 1 && b == 0){
            x = x / a;
        }
        if(a == 2 || x > 1){
            x = x + 1;
        }
        System.out.println(x);
    }

    public static void main(String[] args) {
        foo(3,0,1);
    }
}
