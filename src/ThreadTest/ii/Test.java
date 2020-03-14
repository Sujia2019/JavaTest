package ThreadTest.ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

class A extends Thread{
    public A(String name){
        super(name);
    }

    public void run(){
        try{
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("name: "+this.getName());
            Control.cdl.countDown();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class B extends Thread{
    public B (String name){
        super(name);
    }
    public void run(){
        try{
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("name: "+this.getName());
            Control.cdl.countDown();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class C extends Thread{
    public C(String name){
        super(name);
    }
    public void run(){
        try{
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("name: "+this.getName());
            Control.cdl.countDown();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class D extends Thread{
    public D(String name){
        super(name);
    }
    public void run(){
        try{
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("name: "+this.getName());
            Control.cdl.countDown();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Control extends Thread{
    public static CountDownLatch cdl;
    public HashMap getHashMap(){
        return hashMap;
    }
    public void setHashMap(HashMap hashMap){
        this.hashMap = hashMap;
    }

    private HashMap<String,Thread> hashMap;

    @Override
    public void run() {
        //为啥用set?
        Set<String> keys = hashMap.keySet();
        int i = keys.size();

        System.out.println("key "+i);

        cdl=new CountDownLatch(i);
        for(String key :keys){
            //从hashmap中取出线程
            Thread t = hashMap.get(key);
            System.out.println("-------------------------"+key);
            t.start();
        }
        try{
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



public class Test {

    public static void main(String[] args) {
        ArrayList<HashMap> level = new ArrayList<>();
        HashMap<String,Thread> hashMap = new HashMap<>();
        A a = new A("a");
        B b = new B("b");
        C c = new C("c");
        D d = new D("d");
        hashMap.put("A",a);
        level.add(hashMap);
        HashMap hashMap1 = new HashMap();
        hashMap1.put("B",b);
        level.add(hashMap1);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("C",c);
//        level.add(hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap2.put("D",d);
        level.add(hashMap2);

        //level里放了三个hashmap，每个hashmap里放各自的线程
        for(HashMap obj : level){
            Control ct = new Control();
            System.out.println(obj);
            ct.setHashMap(obj);
            ct.start();
            try {
                ct.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("xxx");
        }
    }
















}
