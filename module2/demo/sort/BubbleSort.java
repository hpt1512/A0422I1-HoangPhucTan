package sort;

public class BubbleSort {
    public static void sort(int[] a) {
        boolean isPassed = true;
        for (int i = 0; i < a.length - 1; i++) {
            isPassed = true;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] < a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    isPassed = false;
                }
            }
            if (isPassed) break;
        }
    }
}
