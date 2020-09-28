package Exam;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 在一个n行m列的二维地图中，王子的位置为(x1,y1)，公主的位置为(x2,y2)。
 * <p>
 * 在地图中设有一些障碍物，王子只能朝上、下、左、右四个方向行走，且不允许走出地图也不允许穿越障碍物。
 * <p>
 * 请编写一个程序判断王子是否可以顺利走到公主所在的位置。
 */
public class Main {

    public static void find() {
        Scanner sc = new Scanner(System.in);
        int group = sc.nextInt();
        ArrayList<Character[][]> groups = new ArrayList<>(); // 记录迷宫组
        ArrayList<Integer> SS = new ArrayList<>();// 记录王子的位置
        for (int i = 0; i < group; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Character[][] g = new Character[n][m];
            for (int x = 0; x < n; x++) {
                char[] cs = sc.next().toCharArray();
                for (int y = 0; y < cs.length; y++) {
                    if (cs[y] == 'S') {
                        SS.add(x);
                        SS.add(y);
                    }
                    g[x][y] = cs[y];
                }
            }
            groups.add(g);
        } // 保存输入的用例

        //对记录的迷宫组遍历 执行找公主的方法
        for (int i = 0; i < group; i++) {
            int xn = i * 2;
            int yn = xn + 1;
            find(groups.get(i), SS.get(xn), SS.get(yn));
        }

    }

    public static void find(Character[][] nm, int x, int y) {
        int length = nm.length;
        WangZi start = new WangZi(x, y);
        //四个方位 上下左右
        Stack<WangZi> stack = new Stack<>();
        stack.push(start);
        out:
        while (!stack.isEmpty()) {
            WangZi p = stack.peek();
            int px = p.x;
            int py = p.y;
            int dir = p.getDirection();

            nm[p.x][p.y] = 'S';
            //判断方向
            switch (dir) {
                case 1:
                    // E!找到公主
                    if (px - 1 >= 0 && nm[px - 1][py] == 'E') {
                        System.out.println("YES");
                        break out;
                    }
                    //判断是否越界，判断是否是'.'
                    if (px - 1 >= 0 && nm[px - 1][py] == '.') {
                        //记录王子走过的位置
                        stack.push(new WangZi(px - 1, py));
                    }
                    //换方向
                    p.setDirection();
                    continue;
                case 2:
                    if (px + 1 < length && nm[px + 1][py] == 'E') {
                        System.out.println("YES");
                        break out;
                    }
                    if (px + 1 < length && nm[px + 1][py] == '.') {
                        stack.push(new WangZi(px + 1, py));
                    }
                    p.setDirection();
                    continue;
                case 3:
                    if (py - 1 >= 0 && nm[px][py - 1] == 'E') {
                        System.out.println("YES");
                        break out;
                    }
                    if (py - 1 >= 0 && nm[px][py - 1] == '.') {
                        stack.push(new WangZi(px, py - 1));
                    }
                    p.setDirection();
                    continue;
                case 4:
                    if (py + 1 < length && nm[px][py + 1] == 'E') {
                        System.out.println("YES");
                        break out;
                    }
                    if (py + 1 < length && nm[px][py + 1] == '.') {
                        stack.push(new WangZi(px, py + 1));
                    }
                    p.setDirection();
                    continue;
            }
            p = stack.pop();
            //S代表王子走过了
            nm[p.x][p.y] = 'S';
        }
        if (stack.isEmpty())
            System.out.println("NO");
    }

    static class WangZi {
        int x;
        int y;
        int direction = 1; // 0上 1下 2左 3右

        WangZi(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setDirection() {
            direction++;
        }

        public int getDirection() {
            return direction;
        }
    }

    public static void main(String[] args) {
        find();
    }
}
