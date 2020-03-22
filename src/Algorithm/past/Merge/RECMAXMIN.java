package Algorithm.past.Merge;

public class RECMAXMIN {    //找最大值最小值

    public int MAXMIN(int A[]){
        int max=A[0];
        int min=A[0];
        for(int i=1;i<A.length;i++){
            if(A[i]>max)      max=A[i];
            else if(A[i]<min) min=A[i];
        }
        return max&min;
    }

    public int max(int a,int b){
        if(a>b) return a;
        else    return b;
    }
    public int min(int a,int b){
        if(a<b) return a;
        else    return b;
    }
    public MinMax REC_MAXMIN(int A[],int i,int j) {
        if (i == j) return new MinMax(A[i], A[i]);
        else if (i == (j - 1)) {
            if (A[i] > A[j]) return new MinMax(A[i], A[j]);
            else return new MinMax(A[j], A[i]);
        } else {
            int mid = (i + j) / 2;
            MinMax left = REC_MAXMIN(A, i, mid);
            MinMax right = REC_MAXMIN(A, mid + 1, j);
            int min=0,max=0;
            min=left.getMin()>right.getMin()?right.getMin():left.getMin();
            max=left.getMax()>right.getMax()?left.getMax():right.getMax();
            return new MinMax(max,min);
        }


    }
    public MinMax REC_MAXMIDMIN(int A[],int i,int j) {
        if (i == j) return new MinMax(A[i], A[i]);
        else if (i == (j - 1)) {
            if (A[i] > A[j]) return new MinMax(A[i], A[j]);
            else return new MinMax(A[j], A[i]);
        } else {
             int mid1 = i+(j-i)/3;
             int mid2 = mid1+(j-mid1)/2;
            MinMax left = REC_MAXMIDMIN(A, i, mid1);
            MinMax MidNum = REC_MAXMIDMIN(A, mid1+1 , mid2);
            MinMax right = REC_MAXMIDMIN(A, mid2+1, j);

            int min = 0, max = 0;
            max = max(left.getMax(), max(MidNum.getMax(), right.getMax()));
            min = min(left.getMin(), min(MidNum.getMin(), right.getMin()));
            return new MinMax(max, min);
        }
    }
}
