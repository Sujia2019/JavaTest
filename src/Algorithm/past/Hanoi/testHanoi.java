package Algorithm.past.Hanoi;

public class testHanoi {
    public static void main(String[]args){
        Hanoi h = new Hanoi();
        char c1 = 'X';
        char c2 = 'Y';
        char c3 = 'Z';
        int times = h.HanoiMove(4,c1,c2,c3);

        System.out.println("移动了"+times+"次");

    }
}
