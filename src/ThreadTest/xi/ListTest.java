package ThreadTest.xi;

import java.util.ArrayList;

public class ListTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("aaa");
        list.add(1);
        ArrayList list1 = new ArrayList();
        list1.addAll(list);
    }
}
