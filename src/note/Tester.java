package note;

public class Tester{
    public static void main(String[] args){
//        Integer var1=new Integer(1);
//        Integer var2=var1;
//        Integer var3 = doSomething(var2);
//        System.out.println(var1.intValue());
//        System.out.println(var2.intValue());
//        System.out.println(var1==var2);
//        System.out.println(var1.equals(var2));
//        System.out.println(var3.equals(var2));
//        System.out.println(var3.intValue());
//        Thread.State
        String test = "currentUser,test";
        String[] fen = test.split(",");
        for (String index : fen) {
            System.out.println(index);
        }
    }
    public static Integer doSomething(Integer integer){
        return integer=new Integer(2);
    }
}