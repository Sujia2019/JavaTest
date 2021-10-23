package Algorithm.leetcode;

public class ch1023 {
    public int[] constructRectangle(int area) {
        int width = (int) Math.sqrt(area);
        while (area % width != 0) {
            width--;
        }
        return new int[]{area / width, width};
    }

    public static void main(String[] args) {
        System.out.println((int)Math.floor(Math.sqrt(6)));
    }
}
