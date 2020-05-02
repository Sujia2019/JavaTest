package Exam.shape;

public class Shape2 {
    /*
    面积法
    四边形每两个顶点与E构成的三角形面积，之和，
    大于四边形面积，则E在四边形外
    等于四边形面积，则E在四边形内或上
    (判断E是否在边上)
    A--------D
    |        |
    |        |
    B--------C
    (凸多边形)
     */
    public static void main(String[] args) {

        Point A = new Point(2,4);
        Point B = new Point(1,3);
        Point C = new Point(3,7);
        Point D = new Point(3,8);
        Point E = new Point(1,1);

        compare(A,B,C,D,E);
    }

    /*
     * 公式推导
     * 两点确定一条直线
     * 第三点到直线的距离为高
     * 底乘高除以二为面积
     *
     */
    public static double area3(Line AB ,Point C){
        double h;
        if(AB.k==null){
            h=Math.abs(C.x-AB.p1.x);
        }else if(AB.b==null){
            h=Math.abs(C.y-AB.p1.y);
        }else{
            //判断是否在边上
            if(C.y==(AB.k*C.x+AB.b)){
                return 0;
            }
            double cb = C.y-AB.k*C.x;
            double dd = Math.abs(AB.b-cb);
            //h=dd*根号下1-k2
            h=dd*Math.sqrt(1+Math.pow(AB.k,2));
            System.out.println(h);
        }
        return (AB.bian*h)/2;
    }

    public static void compare(Point A,Point B,Point C,Point D,Point E){
        Line AB = new Line(A,B);
        Line BC = new Line(B,C);
        Line CD = new Line(C,D);
        Line DA = new Line(D,A);

        Line[] lines = new Line[]{AB,BC,CD,DA};
        // 求四边形的面积
        // 斜边为低的俩三角形
        Line AC = new Line(A,C);
        double S4 = area3(AC,B)+area3(AC,D);//四边形的面积
        System.out.println(S4);

        double ss = 0; //与E点相连的面积
        for(int i=0;i<4;i++){
            double s = area3(lines[i],E);
            if(s==0){
                System.out.println("在四边形的边上");
                return;
            }else{
                ss+=s;
            }
        }
        System.out.println(ss);
        if(ss>S4){
            System.out.println("在四边形之外");
        }else{
            System.out.println("在四边形之内");
        }
    }
}
