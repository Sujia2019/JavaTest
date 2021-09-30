package Collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
        //会根据key排序
        //底层实现 红黑树
        TreeMap<Integer,String> map = new TreeMap<>();
        map.put(4,"4");
        map.put(5,"5");
        map.put(1,"1");
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"xxx");
        hashMap.put(null,null);//可以存空
        ConcurrentHashMap<Integer,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(null,null);// 不可以 会抛异常
        for(Map.Entry<Integer,String> entry:map.entrySet()){
            System.out.println("key:"+entry.getKey()+"value:"+entry.getValue());
        }
    }
}
