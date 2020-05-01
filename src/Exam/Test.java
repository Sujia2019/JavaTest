package Exam;

// 打怪 金币

import java.util.Arrays;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        int start = 0;
        int player = 0;
        int monsterCount = 0;
        int money = 0;
        int cost = 0;
        int win = 0;

        Scanner sc = new Scanner(System.in);

        player = sc.nextInt();
        start = player;
        monsterCount = sc.nextInt();
        int[] monsters = new int[monsterCount];

        for(int i=0;i<monsterCount;i++){
            monsters[i]=sc.nextInt();
        }
        //排序
        Arrays.sort(monsters);

        //从能力最强的怪物开始比
        for(int i=monsterCount-1;i>0;i--){
            //如果我打不过大的那个
            c2:if(player<monsters[i]){

                //从第一个怪开始打，获取金币 提升能力
                for(int j=0;j!=i;){
                    //如果我打不过，返回
                    if(player<monsters[j]){
                        break ;
                    }
                    //如果打得过
                    else{
                        if(start>=monsters[j]){
                            win = win+1;
                        }
                        //能力+1
                        player = player+1;
                        //记录你的花费
                        cost = cost+1;
                        //然后再去比较能不能打得过最大的
                        if(player>=monsters[i]){
                            //打得过 钱+1

                            //打下一个
                            break c2;
                            //打不过，就继续打小怪
                        }else{
                            j=j+1;
                        }
                    }
                }
            }
            //如果打得过

            money = money+1;

            //找下一个
        }

        if(win>money){
            System.out.println(win);
        }
        System.out.println(money);

    }

//    public static void money(){
//
//    }


}