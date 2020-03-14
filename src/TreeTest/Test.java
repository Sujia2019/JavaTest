package TreeTest;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<String, Integer> h = new HashMap<String, Integer>();
        h.put("test1",20);
        h.put("test2",30);
        h.put("test3",40);
        h.put("test4",50);
        h.put("test5",0);
        h.put("test6",60);
        h.put("test7",70);
        h.put("test8",80);
        h.put("test9",90);
        h.put("test10",130);
        h.put("test11",320);
        h.put("test12",330);
        h.put("test13",350);
        h.put("test14",730);
        h.remove("test7");


        int getNumber= h.get("test8");

        System.out.println(getNumber);

    }
}
