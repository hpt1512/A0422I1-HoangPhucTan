package ss4_class_and_object_in_java.exercise.quadratic_equation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập a: ");
        int a = scanner.nextInt();
        System.out.print("Nhập b: ");
        int b = scanner.nextInt();
        System.out.print("Nhập c: ");
        int c = scanner.nextInt();

        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        double delta = equation.getDiscriminant();
        System.out.println("Delta = " + delta);

        if (delta > 0) {
            System.out.printf("Phương trình có 2 nghiệm : \n x1 = %.2f \n x2 = %.2f", equation.getRoot1(), equation.getRoot2());
        } else if (delta == 0) {
            System.out.printf("Phương trình có 1 nghiệm : x = %.2f ", equation.getRoot());
        } else {
            System.out.println("Phương trình vô nghiệm");
        }

    }
}
