package Algorithm;

public class Test {

    public static void main(String[] args) {
        Sort s  = new Sort();
        int arr[] = {1,5,3,5,0,4,11,1111,3,5,7,8};
        s.bubbleSort(arr);

        s.selectSort(arr);

        s.insertSort(arr);

        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
