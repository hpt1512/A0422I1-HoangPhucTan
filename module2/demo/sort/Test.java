package sort;

public class Test {
    public static void main(String[] args) {
        int[] a = {7, 2, 8, 6, 3, 5};
//        BubbleSort.sort(a);
//        SelectionSort.sort(a);
        InsertionSort.sort(a);
        println(a);
    }

    public static void println(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%4d", a[i]);
        }
        System.out.println();
    }
}
