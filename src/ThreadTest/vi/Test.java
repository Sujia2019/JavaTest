package ThreadTest.vi;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private static List list = new ArrayList();
    public static void main(String[] args){
        while (true){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println("aaa");
                    }
                }
            });
            list.add(t);
            t.start();
        }
    }
}
