package Algorithm;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Sort s  = new Sort();
        int arr[] = {1,5,3,5,0,4,11,1111,3,5,7,8};
        s.bubbleSort(arr);

        s.selectSort(arr);

        s.insertSort(arr);

        for (int value : arr) {
            System.out.print(value + " ");
        }

//        String s ;
//        System.out.println("s="+s);
//        Arrays.asList()//返回的是他自己实现的ArrayList,不是java.util.ArrayList;



    }
}

