package Algorithm.past.Bag;

public class Stuff {

    private int weight=0;
    private int value=0;
    private int count=0;

    Stuff(){  }
    Stuff(int weight,int value){
        this.value=value;
        this.weight=weight;
    }
    Stuff(int weight,int value,int count){
        this.count=count;
        this.value=value;
        this.weight=weight;
    }
    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int[][] mathord(Stuff s[],int n,int W) {
        int c[][]=new int[n][W];//因为数组长度问题，有5个物品17承重的包，需要建立6x18的数组
        for(int w=0;w<W;w++) {      //有0，0的情况
            c[0][w]=0;            //这个代码还没有优化，有重复的部分，并且没有消除无用的0
        }
        for(int i=1;i<n;i++) {
            c[i][0]=0;
            for(int w=1;w<W;w++) {
                if(s[i].weight<=w) {
                    if(s[i].value+c[i-1][w-s[i].weight]>c[i-1][w]) {
                        c[i][w]=s[i].value+c[i-1][w-s[i].weight];
                    }
                    else {
                        c[i][w]=c[i-1][w];
                    }
                }
                else {
                    c[i][w]=c[i-1][w];
                }
            }
        }
        return c;
    }

    public int[] OUTPUT_SACK(Stuff s[],int[][] c,int n,int w){//c为二维数组价值矩阵，w为最大重，n为物品数量
        int x[] = new int[n+1];
        for(int i=n;i>=2;i--){
            if(c[i][w]==c[i-1][w]){
                x[i]=0;
            }else {
                x[i] = 1;
                w=w-s[i].weight;
            }
        }
        return x;
    }
}
