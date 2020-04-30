package Exam;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;

class Point{
    float x;
    float y;
    Point(float x,float y){
        this.x = x;
        this.y = y;
    }
}
class Line{
    float k;//斜率
    float b;//
    Line(float k,float b,Point p1,Point p2){
        this.k = k;
        this.b = b;
        this.p1 = p1;
        this.p2 = p2;
    }
    //直线上所包含的两端点
    Point p1;
    Point p2;
}

public class Shape {

    /*
    思路
    过点E的平行线一定会穿过2条边，则在四边形内部
    若与边重合  则点在四边形上
    其他情况则是在四边形外
    (适用于凸多边形)
    A -------D
    |        |
    |        |
    B -------C
     */

    public static void main(String[] args) {
        Point A = new Point(2,4);
        Point B = new Point(1,1);
        Point C = new Point(4,2);
        Point D = new Point(6,6);
        Point E = new Point(3,3);
        position(A,B,C,D,E);
//        position();
    }
    public static void position(Point A,Point B,Point C,Point D,Point E){
        //y=kx+b
        //1,求斜率
        //2,求b
        float kab = k(A,B);
        float kbc = k(B,C);
        float kcd = k(C,D);
        float kda = k(D,A);

        float bab = b(A,kab);   //yA = kab * xA + bab
        float bbc = b(B,kbc);   //yB = kbc * xB + bbc
        float bcd = b(C,kcd);   //yC = kcd * xC + bcd
        float bda = b(D,kda);   //yD = kda * xD + bda

        float[] ks = new float[]{kab,kbc,kcd,kda};

        Line AB = new Line(kab,bab,A,B);
        Line BC = new Line(kbc,bbc,B,C);
        Line CD = new Line(kcd,bcd,C,D);
        Line DA = new Line(kda,bda,D,A);

        //3,代入公式求交点
        float be = E.y-kab*E.x;     //yE = ke * xE - be;

        Line[] ls = new Line[]{AB,BC,CD,DA};

        for(int i=0;i<4;i++){
            ArrayList<Line> lines = new ArrayList<>();
            for(int j=0;j<4;j++){
                if (j!=i){
                    lines.add(ls[i]);
                }
            }
            //获得交点
            float[] xes = crossX(E,ks[i],lines);
            //如果交点不在线段上，则E一定是在四边形外，不必找下去了
            if(!isOnSegment(xes,lines)){
                System.out.println("外");
                return;
            }
        }
        System.out.println("内");

    }

    /*
    求k
     */
    public static float k(Point A,Point B){
        if(A.y==B.y){
            return 0;
        }
        else{
            return  (A.x-B.x)/(A.y-B.y);
        }
    }
    /*
    求b
     */
    public static float b(Point A,float k){
        return A.y-k*A.x;
    }


    /**
     *
     * @param E 待判断位置的E
     * @param ke 与哪条线平行的斜率
     * @param list 其他的线
     * @return 交点坐标的x
     */
    public static float[] crossX(Point E, float ke, ArrayList<Line> list){
        float be = E.y-ke*E.x;     //yE = ke * xE - be;

        //与三条边所在直线的交点的x坐标
        float x1 = (list.get(0).b-be)/(list.get(0).k-ke);
        float x2 = (list.get(1).b-be)/(list.get(1).k-ke);
        float x3 = (list.get(2).b-be)/(list.get(2).k-ke);

        return new float[]{x1,x2,x3};

    }

    /**
     *
     * @param xes 交点x坐标
     * @param lines 线段
     * @return 判断是否有两个与边的交点
     */
    public static boolean isOnSegment(float[] xes,ArrayList<Line> lines){
//        for(int i=0;i<3;i++){
//            if(B.x>C.x){
//                if(x1<=B.x&&x1>=C.x){
//                    //有交点
//                    continue;
//                }else{
//                    break;
//                }
//            }else{
//                if(x1<=C.x&&x1>=B.x){
//                    continue;
//                }else{
//                    break;
//                }
//            }
//        }
        //求范围
        int count = 0;
        for(int i=0;i<3;i++){
            Point p1 = lines.get(i).p1;
            Point p2 = lines.get(i).p2;
            if(p1.x>p2.x){
                if(xes[i]<=p1.x&&xes[i]>=p2.x){
                    count++;
                    if(count==2){
                        return true;
                    }
                }
            }else{
                if(xes[i]<=p2.x&&xes[i]>=p1.x){
                    count++;
                    if(count==2){
                        return true;
                    }
                }
            }
        }
        System.out.println(count);
        return false;
    }
}
