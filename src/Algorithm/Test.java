package Algorithm;

import java.util.*;

public class Test {

    public static void main(String[] args) {
//        Sort s  = new Sort();
//        int arr[] = {1,5,3,5,0,4,11,1111,3,5,7,8};
//        s.bubbleSort(arr);
//
//        s.selectSort(arr);
//
//        s.insertSort(arr);
//
//        for (int value : arr) {
//            System.out.print(value + " ");
//        }

//        String s ;
//        System.out.println("s="+s);
//        Arrays.asList()//返回的是他自己实现的ArrayList,不是java.util.ArrayList;
//        getYears();
//        Scanner sc = new Scanner(System.in);
//
//        String xxx =  sc.nextLine();
//        System.out.println(xxx);

        Map<Long, Long> map = new HashMap<>();
        map.put(5007L, 5007L);
        map.put(5008L, 5008L);
        System.out.println(map);
    }

    public static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isFirst(char c) {
        return c >= '1' && c <= '3';
    }

    public static void getYears() {
        TreeSet<String> set = new TreeSet<>();
        ArrayList<String> arrays = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        char[] ss = sc.nextLine().toCharArray();
        int length = ss.length;
        for (int i = 0; i < length - 4; ) {
            // 如果第一个是数字
            if (isFirst(ss[i])) {
                // 如果前一项不为数字 且后一项也不为数字
                // 这里少加判断条件
                char[] res = new char[4];
                res[0] = ss[i];
                //判断第四个是不是数字
                if (isNumber(ss[i + 3])) {
                    res[3] = ss[i + 3];
                } else {
                    i = i + 4;
                    continue;
                }
                if (isNumber(ss[i + 2])) {
                    res[2] = ss[i + 2];
                } else {
                    i = i + 3;
                    continue;
                }
                if (isNumber(ss[i + 1])) {
                    res[1] = ss[i + 1];
                    String year = String.valueOf(res);
                    if (!set.contains(year)) {
                        arrays.add(year);
                    }
                    set.add(year);
                    i = i + 4;
                } else {
                    i = i + 2;
                }
            } else {
                i = i + 1;
            }
        }
        for (String array : arrays) {
            System.out.print(array + " ");
        }
    }
}

