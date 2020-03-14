package JVMTest;

import java.io.IOException;

public class GcTest {
    public void finalize(){
        System.out.println("full gc running");
    }
    public static void main(String[] args) throws Throwable {
        for(int i=0;i<4;i++){
            GcTest t = new GcTest();
            System.gc();
            Runtime.getRuntime().runFinalization();
            System.out.println("i="+i);
//            t.finalize();
        }
//        Runtime.getRuntime().gc();
        try{
            System.in.read();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
