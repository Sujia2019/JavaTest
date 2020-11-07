package Exam;

// 打怪 金币

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
//        int start = 0;
//        int player = 0;
//        int monsterCount = 0;
//        int money = 0;
//        int cost = 0;
//        int win = 0;
//
//        Scanner sc = new Scanner(System.in);
//
//        player = sc.nextInt();
//        start = player;
//        monsterCount = sc.nextInt();
//        int[] monsters = new int[monsterCount];
//
//        for(int i=0;i<monsterCount;i++){
//            monsters[i]=sc.nextInt();
//        }
//        //排序
//        Arrays.sort(monsters);
//
//        //从能力最强的怪物开始比
//        for(int i=monsterCount-1;i>0;i--){
//            //如果我打不过大的那个
//            c2:if(player<monsters[i]){
//
//                //从第一个怪开始打，获取金币 提升能力
//                for(int j=0;j!=i;){
//                    //如果我打不过，返回
//                    if(player<monsters[j]){
//                        break ;
//                    }
//                    //如果打得过
//                    else{
//                        if(start>=monsters[j]){
//                            win = win+1;
//                        }
//                        //能力+1
//                        player = player+1;
//                        //记录你的花费
//                        cost = cost+1;
//                        //然后再去比较能不能打得过最大的
//                        if(player>=monsters[i]){
//                            //打得过 钱+1
//
//                            //打下一个
//                            break c2;
//                            //打不过，就继续打小怪
//                        }else{
//                            j=j+1;
//                        }
//                    }
//                }
//            }
//            //如果打得过
//
//            money = money+1;
//
//            //找下一个
//        }
//
//        if(win>money){
//            System.out.println(win);
//        }
//        System.out.println(money);

//        String a = "abc";
//        String b = new String("abc");
//        String c = "abc";
//        System.out.println(a==c);
//        HashMap map = new HashMap();
//
//        System.out.println();
//
//        Object obj = new Object();
//        String str = "92057|99033|99999";
//        String[] strs = str.split("");
//        for (int i=0;i<strs.length;i++){
//            System.out.println(strs[i]);
//        }
//        StringBuilder builder = new StringBuilder("18539403150");
//        builder.insert(3,"-");
//        builder.insert(8,"-");
//        System.out.println(builder.toString());
        String content = "18539";
        String regexTel = "^((\\+?86)|(\\(\\+86\\)))?(13[0123456789][0-9]{8}|15[0123456789][0-9]{8}|18[0123456789][0-9]{8}|14[57][0-9]{8}|1349[0-9]{7}|17[01678][0-9]{8})$";
        String regex = "^(0\\d{2,3}-?\\d{7,8})$";
        Pattern p1 = Pattern.compile(regexTel);
        Pattern p2 = Pattern.compile(regex);
        Matcher matcher1 = p1.matcher(content);
        Matcher matcher2 = p2.matcher(content);
        if (matcher1.matches()) {
            System.out.println("匹配");
        }
        if (matcher2.matches()) {
            System.out.println("匹配");
        }
        if (matcher1.matches() || matcher2.matches()) {
            System.out.println("匹配");
        } else {
            System.out.println("不匹配");
        }
    }
}