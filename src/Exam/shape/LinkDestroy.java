package Exam.shape;

import java.util.Random;
import java.util.Stack;

//连锁破坏
//广度优先遍历
public class LinkDestroy {

    static class Block{
        int x;
        int y;
        int direction = 1; // 0上 1下 2左 3右
        Block(int x,int y){
            this.x = x;
            this.y = y;
        }
        public void setDirection(){
            direction++;
        }
        public int getDirection(){
            return direction;
        }
    }
    public static void main(String[] args) {
        int [][] mm = create(5,3);
        printArray(mm);
        destroy(mm,0,3);
        printArray(mm);
    }


    public static int[][] destroy(int [][] mm,int x,int y){
        int length = mm.length;
        int target = mm[x][y];
        Block start = new Block(x,y);
        //四个方位 上下左右
        Stack<Block> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()){
            Block p = stack.peek();
            int px = p.x;
            int py = p.y;
            int dir = p.getDirection();

            mm[p.x][p.y]=-1;
            //判断方向
            switch (dir){
                case 1:
                    //判断是否越界，判断是否和目标相同
                    if(px-1>=0&&mm[px-1][py]==target){
                        //记录这个位置
                        stack.push(new Block(px-1,py));
                    }
                    //换方向
                    p.setDirection();
                    continue;
                case 2:
                    if(px+1<length&&mm[px+1][py]==target){
                        stack.push(new Block(px+1,py));
                    }
                    p.setDirection();
                    continue;
                case 3:
                    if(py-1>=0&&mm[px][py-1]==target){
                        stack.push(new Block(px,py-1));
                    }
                    p.setDirection();
                    continue;
                case 4:
                    if(py+1<length&&mm[px][py+1]==target){
                        stack.push(new Block(px,py+1));
                    }
                    p.setDirection();
                    continue;
            }
            p=stack.pop();
            //设-1代表块儿被消灭
            mm[p.x][p.y]=-1;
        }
        return mm;
    }

    public static int[][] create(int size,int random){
        int[][] mm = new int[size][size];
        Random r = new Random();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                mm[i][j]= r.nextInt(random);
            }
        }
        return mm;
    }

    public static void printArray(int[][] mm){
        int length=mm.length;
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                System.out.print(mm[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
