package Algorithm;

import java.util.*;


public class C1 {
    /**
     * 拆数字，若不是素数就求出个数之和
     * 9(2+2+2+3)
     * 素数 2，3，5，7，11(2+2+2+3),13(2+2+2+2+2+3)
     */
    public static void c1 (){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
//        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;

        for(int i=0;i<count;i++){
            int x =sc.nextInt();
            if(x==2||x==3){
                res=res+1;
            }else if(x>3){
                res=res+x/2;
            }
//            if(map.containsKey(x)){
//                int xc = map.get(x);
//                map.put(x,xc+1);
//            }else{
//                map.put(x,1);
//            }
        }

//        for(Integer x:map.keySet()){
//            int s = 0;
//            int c = map.get(x);
//            if(x==2||x==3){
//                s=1;
//            }else if(x>3){
//                s=x/2;
//            }
//            res = res+s*c;
//        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        c1();
    }

    /**
     * 字典序最小得排列
     * 给定长度为m的序列T
     * abcdefghijklmnopqrstuvwxyz
     */
    public static void c2 (){

    }

    /**
     * 现在有n个物品，每个物品都有一个价值，现在将这些物品分给两个人，
     * 要求这两个人每个人分到的物品总价值和相同(个数可以不同，价值相同即可)
     * 剩下的物品就需要扔掉，最少要仍多少价值的物品？
     */
    public static void c3(){
        Scanner sc = new Scanner(System.in);
        int group = sc.nextInt();//几组测试数据
        int groupNum ;
        int [][] vs = new int[group][];
        for(int i=0;i<group;i++){
            groupNum=sc.nextInt();//记录每组测试数据的个数
            vs[i]=new int[groupNum];
        }
        for(int i=0;i<group;i++){
            for(int j=0;j<vs[i].length;j++){
                vs[i][j] = sc.nextInt();//每个物品的价值
            }
            //排序
            Arrays.sort(vs[i]);
        }
        int res = 0;
        int[] ret=new int[group];
        for(int n=0;n<group;n++){
            ret[n]=-1;
        }
        for(int i=0;i<group;i++){
            if(vs[i][0]==vs[i][vs[i].length-1]){
                if((vs[i].length-1)%2!=0){
                    res = res+vs[i][0];
                }
            }
            int p1=0;
            for(int j=vs[i].length-1;;j--){
                int p2=0;
                for(int k=1;j-k>0;k++){
                    p1 = p1+vs[i][j];
                    p2 = p2+vs[i][j-k];
                    if(p2==p1){
                        int summ = sum(vs[i],0,j-2);
                        if(ret[i]!=-1&&summ<ret[i]){
                            ret[i]=summ;
                        }
                    }else{
                        p2 = p2+vs[i][j-k];
                    }
                }
            }
        }
        System.out.println(res);
    }

    public static int sum(int[] a, int start, int end){
        int res = 0;
        for (int value : a) {
            res += value;
        }
        return res;
    }

    public static void c4(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//结点数目
        int m = sc.nextInt();//边的个数
        int[][] view = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int index = sc.nextInt();
            }
        }
    }
}
