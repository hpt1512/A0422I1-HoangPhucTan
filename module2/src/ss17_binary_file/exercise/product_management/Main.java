package ss17_binary_file.exercise.product_management;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void writeToFile(String path, List<Product> products) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readDataFromFile(String path) {
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return products;
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Samsung", 10000));
        products.add(new Product(2, "Nokia", 20000));
        products.add(new Product(3, "Lenovo", 30000));
        products.add(new Product(4, "Oppo", 40000));
        products.add(new Product(5, "Xiaomi", 50000));

        writeToFile("D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\ss17_binary_file\\exercise\\product_management\\product.txt", products);

        boolean check = true;
        while (check) {
            System.out.println("----- 1. Hiển thị thông tin sản phẩm");
            System.out.println("----- 2. Thêm sản phẩm");
            System.out.println("----- 3. Tìm kiếm thông tin");
            System.out.println("----- 4. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();

            if (choose < 1 || choose > 4) {
                System.err.println("INPUT ERROR - PLEASE ENTER A VALUE IN [1-4]");
            }

            switch (choose) {
                case 1:
                    List<Product> productDataFromFile = readDataFromFile("D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\ss17_binary_file\\exercise\\product_management\\product.txt");
                    for (Product product : productDataFromFile) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    System.out.print("Nhập id sản phẩm: ");
                    scanner.nextLine();
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập tên sản phẩm: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập giá sản phẩm: ");
                    int price = Integer.parseInt(scanner.nextLine());
                    Product product = new Product(id, name, price);
                    products.add(product);
                    writeToFile("D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\ss17_binary_file\\exercise\\product_management\\product.txt", products);
                    break;
                case 3:
                    System.out.print("Nhập tên sản phẩm cần tìm: ");
                    scanner.nextLine();
                    String nameFind = scanner.nextLine();
                    int count = 0;
                    for (Product product1: products) {
                        if (product1.getName().toLowerCase().contains(nameFind.toLowerCase())) {
                            count++;
                            System.out.println(product1.toString());
                        }
                    }
                    if (count == 0) {
                        System.out.println("Không tìm thấy sản phẩm " + nameFind);
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }


    }
}
