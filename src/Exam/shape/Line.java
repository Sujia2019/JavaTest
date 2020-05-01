package Exam.shape;

public class Line{
    Double k;//斜率
    Double b;//
    double bian; // 线段的距离
    Line(Point p1,Point p2){
        this.p1 = p1;
        this.p2 = p2;
        this.bian = p1p2();
        this.k = k();
        this.b = b();

    }
    //直线上所包含的两端点
    Point p1;
    Point p2;

    private double p1p2(){
        return Math.sqrt(Math.pow(p1.x-p2.x,2)+Math.pow(p1.y-p2.y,2));
    }
    private Double k(){
        if(p1.x==p2.x){
            return null;
        }
        else{
            return  (p1.y-p2.y)/(p1.x-p2.x);
        }
    }

    private Double b(){
        if(k==null){
            //斜率不存在
            return null;
        }
        return p1.y-k*p1.x;
    }
}
