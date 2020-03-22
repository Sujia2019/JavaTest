package merge;

public class MERGEMETHOD {    //归并

    public void MERGE(int[] A, int p, int q, int r){//p是开头，q是分段，r是最后
        int n1 = q-p+1;   //第一段的length
        int n2 = r-q;     //第二段的length
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        for(int i=0;i<L.length-1;i++){
            L[i+1]=A[p+i];
        }
        for(int j=0;j<R.length-1;j++){
            R[j+1]=A[q+j+1];
        }
        L[0]=-1;
        R[0]=-1;
        int i=L.length-1;
        int j=R.length-1;
        for(int k=r;k>=p;k--){
            if(L[i]>R[j]){
                A[k]=L[i];
                i=i-1;
            }else{
                A[k]=R[j];
                j=j-1;
            }
        }
    }

    public void MERGE_SORT(int[] A, int p, int r){
        if(p<r){
            double mid = Math.floor((p+r)/2);
            int q = (int)mid;
            MERGE_SORT(A,q+1,r);
            MERGE_SORT(A,p,q);
            MERGE(A,p,q,r);

        }
    }

}
