package Collection;

public class Test {
    public static void main(String[] args) {
//        Thread t = new Thread(new Runnable() {
//            public void run() {
//                pong();
//            }
//        });
//        t.run();
//        System.out.println("ping");

        int a = 127;
        int b = a++;
        System.out.println(b);
        System.out.println(++b);
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.err.println(str1 == str2);

    }

    static void pong(){
        System.out.println("pong");
    }


}
