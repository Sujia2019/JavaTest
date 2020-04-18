package Collection.map;

import java.util.Map;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        //会根据key排序
        //底层实现 红黑树
        TreeMap<Integer,String> map = new TreeMap<>();
        map.put(4,"4");
        map.put(5,"5");
        map.put(1,"1");
        for(Map.Entry<Integer,String> entry:map.entrySet()){
            System.out.println("key:"+entry.getKey()+"value:"+entry.getValue());
        }
    }
}
