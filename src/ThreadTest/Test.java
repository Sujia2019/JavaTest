package ThreadTest;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Test {
    public static void main(String[] args) {
        AtomicIntegerArray atest = new AtomicIntegerArray(10);
        atest.set(1,10);
        System.out.println(atest.toString());
    }
}
