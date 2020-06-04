package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort {

    //冒泡排序
    public int[] bubbleSort(int[] array){
        if(array.length<=1){
            return array;
        }
        for(int i=0;i<array.length-1;i++){
           for(int j=0;j<array.length-i-1;j++){
               if(array[j+1]<array[j]){
                   int temp = array[j+1];
                   array[j+1] = array[j];
                   array[j]=temp;
               }
           }
        }
        return array;
    }

    //选择排序    找出最小的和最前面的交换
    public int[] selectSort(int[] array){
        if(array.length<=1){
            return array;
        }
        for(int i=0;i<array.length;i++){
            int minIndex=0;
            for(int j=i;j<array.length;j++){
                if(array[j]<array[minIndex]){
                    minIndex=j;
                }
                int temp=array[minIndex];
                array[minIndex]=array[i];
                array[i]=temp;
            }
        }
        return array;
    }

    //插入排序
    public int[] insertSort(int[] array){
        if(array.length<=1){
            return array;
        }
        int current=0;
        for(int i=0;i<array.length-1;i++){
            current=array[i+1];
            int preIndex=i;
            while(preIndex>=0&&current<array[preIndex]){
                array[preIndex+1]=array[preIndex];
                preIndex--;
            }
            array[preIndex+1]=current;
        }
        return array;
    }

    //希尔排序，隔着排
    public int[] shellSort(int[] array){
        int len = array.length;
        int temp,gap=len/2;
        while (gap>0){
            for(int i=gap;i<len;i++){
                temp=array[i];
                int preIndex=i-gap;
                while(preIndex>=0&&array[preIndex]>temp){
                    array[preIndex+gap]=array[preIndex];
                    preIndex-=gap;
                }
                array[preIndex+gap]=temp;
            }
            gap /= 2;
        }
        return array;
    }

    //归并排序
    public int[] mergeSort(int[] arr){
        if(arr.length<2) return arr;
        int mid=arr.length/2;
        int[] left = Arrays.copyOfRange(arr,0,mid);
        int[] right = Arrays.copyOfRange(arr,mid,arr.length);
        return merge(mergeSort(left),mergeSort(right));

    }
    public int[] merge(int[] left,int[] right){
        int[] result = new int[left.length+right.length];
        for(int index = 0,i=0,j=0;index<result.length;index++){
            if(i>=left.length)
                result[index] = right[j++];
            else if(j>=right.length)
                result[index]=left[i++];
            else if(left[i]>right[j])
                result[index]=right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }
//快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，
// 其中一部分记录的关键字均比另一部分的关键字小，
// 则可分别对这两部分记录继续进行排序，以达到整个序列有序。
    public int[] QuickSort(int[] array,int start,int end){
        if(array.length<1||start<0||end>=array.length||start>end) return null;
        int smallIndex = partition(array,start,end);
        if(smallIndex>start)
            QuickSort(array,start,smallIndex-1);
        if(smallIndex<end)
            QuickSort(array,smallIndex+1,end);
        return array;
    }
    public int partition(int[] array,int start,int end){
        int pivot=(int)(start+Math.random()*(end-start+1));//随机一个基准
        int smallIndex=start-1;
        swap(array,pivot,end);
        for(int i=start;i<=end;i++){
            if(array[i]<=array[end]){
                smallIndex++;
                if(i>smallIndex)
                    swap(array,i,smallIndex);
            }
        }
        return smallIndex;
    }
    public void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //堆排序 利用堆这种数据结构
    static int len;
    public int[] heapSort(int[] array){
        len=array.length;
        if(len<1) return array;
        //1,构建一个最大堆
        buildMaxHeap(array);
        //2,循环将堆首位(最大值)与末位交换，然后再重新调整最大堆
        while(len>0){
            swap(array,0,len-1);
            len--;
            adjustHeap(array,0);
        }
        return array;
    }

    private void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始向上构建最大堆
        for(int i=(len/2-1);i>=0;i--){
            adjustHeap(array,i);
        }
    }
    private void adjustHeap(int[] array, int i) {
        int maxIndex=i;
        if(i*2<len&&array[i*2]>array[maxIndex])
            maxIndex=i*2;
        if(i*2+1<len&&array[i*2+1]>array[maxIndex])
            maxIndex=i*2+1;
        if(maxIndex!=i){
            swap(array,maxIndex,i);
            adjustHeap(array,maxIndex);
        }
    }


    /*
    桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。

    桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，
    将数据分到有限数量的桶里，每个桶再分别排序
    (有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排)
     */
    public ArrayList<Integer> bucketSort(ArrayList<Integer> array,int bucketSize){
        if(array==null||array.size()<2)
            return array;
        int max=array.get(0),min=array.get(0);
        //找到最大值最小值
        for(int i=0;i<array.size();i++){
            if(array.get(i)>max)
                max=array.get(i);
            if(array.get(i)<min)
                min=array.get(i);
        }

        int bucketCount=(max-min)/bucketSize+1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>();
        ArrayList<Integer> resultArr = new ArrayList<>();
        for(int i=0;i<bucketCount;i++){
            bucketArr.add(new ArrayList<Integer>());
        }
        for(int i=0;i<array.size();i++){
            bucketArr.get((array.get(i)-min)/bucketSize).add(array.get(i));
        }
        for(int i=0;i<bucketCount;i++){
            if(bucketSize==1){
                for(int j=0;j<bucketArr.get(i).size();j++)
                    resultArr.add(bucketArr.get(i).get(j));
            }else{
                if(bucketCount==1)
                    bucketSize--;
                ArrayList<Integer> temp = bucketSort(bucketArr.get(i),bucketSize);
                for(int j=0;j<temp.size();j++)
                    resultArr.add(temp.get(j));
            }
        }
        return resultArr;
    }

    //二分查找
    public static int Search(int[] a,int v,int low,int high){
        if(low>high) return 0;
        int mid=(low+high)/2;
        if(v==a[mid]) return mid;
        if(v<a[mid]) return Search(a,v,low,mid-1);
        else return Search(a,v,mid+1,high);
    }
    //二分查找 非递归
    public static int Search(int[] a,int key){
        int left = 0;
        int right = a.length-1;
        int mid;
        while (left<=right){
            mid = (left+right)/2;
            if(a[mid] == key){
                return a[mid];
            }else if(a[mid]<key){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }

}
