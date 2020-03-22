package Algorithm.past.Merge;

public class MinMax {

    public int min;
    public int max;
    public MinMax(int max,int min){
        this.max=max;
        this.min=min;
    }

    public void setMin(int min){
        this.min=min;
    }
    public void setMax(int max){
        this.max=max;
    }
    public int getMin(){
        return min;
    }
    public int getMax(){
        return max;
    }
}
