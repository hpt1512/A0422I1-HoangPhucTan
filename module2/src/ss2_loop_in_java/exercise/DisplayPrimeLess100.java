package ss2_loop_in_java.exercise;

public class DisplayPrimeLess100 {
    //    Hiển thị các số nguyên tố nhỏ hơn 100
    public static void main(String[] args) {
        int count = 0; //đếm số lượng snt
        int N = 2;
        System.out.println("Các số nguyên tố nhỏ hơn 100 là: ");
        while (N < 100) {
            int dem = 0;
            for (int i = 1; i <= N; i++) {
                if (N % i == 0) {
                    dem++;
                }
            }
            if (dem == 2) {
                System.out.print(N + "\t");
                count++;
            }
            N++;
        }
    }
}
