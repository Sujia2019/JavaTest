package com.sj.learning;


public class NewClass {


    public static void method(){
        c:for (int n=2;n<=100;n++){
            for(int x=2;x<n;){
                // n可以被x整除
                if (n%x==0){
                    System.out.println(n+"不是质数");
                    continue c;
                }else{
                    x++;
                }
            }
            System.out.println(n+"质数");
        }

    }

    public static void main(String[] args) {
        method();
    }
}
