package ss12_java_collection.exercise.training_arraylist_linkedlist;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> productArrayList = new ArrayList<>();
        ProductManager productManager = new ProductManager(productArrayList);

        productManager.addProduct(101, "Samsung", 5000000);
        productManager.addProduct(102, "Nokia", 3000000);
        productManager.addProduct(103, "Iphone", 7000000);


//        System.out.println("********** DANH SÁCH SẢN PHẨM **********");
//        productManager.showProductList();
//
//        System.out.println("****************************************");

        int option;
        do {
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm");
            System.out.println("3. Xoá sản phẩm");
            System.out.println("4. Tìm kiếm sản phẩm theo tên");
            System.out.println("5. Sắp xếp tăng dần");
            System.out.println("6. Sắp xếp giảm dần");
            System.out.println("0. Thoát");
            System.out.println("Bạn muốn làm gì ? ");
            option = scanner.nextInt();


            int id, price;
            String name;

            switch (option) {
                case 1:
                    System.out.println("---Thêm 1 sản phẩm : ");
                    System.out.println("Nhập id sản phẩm : ");
                    id = scanner.nextInt();
                    System.out.println("Nhập tên sản phẩm : ");
                    scanner.nextLine();
                    name = scanner.nextLine();
                    System.out.println("Nhập giá sản phẩm : ");
                    price = Integer.parseInt(scanner.nextLine());

                    productManager.addProduct(id, name, price);

                    System.out.println("********** DANH SÁCH SẢN PHẨM **********");
                    productManager.showProductList();

                    System.out.println("****************************************");
                    break;
                case 2:
                    System.out.println("---Sửa thông tin sản phẩm : ");
                    System.out.print("Nhập id sản phẩm cẩn sửa: ");
                    id = scanner.nextInt();

                    productManager.updateProduct(id);

                    System.out.println("********** DANH SÁCH SẢN PHẨM **********");
                    productManager.showProductList();

                    System.out.println("****************************************");
                    break;
                case 3:
                    System.out.println("---Xoá sản phẩm : ");
                    System.out.print("Nhập id sản phẩm cẩn xoá: ");
                    id = scanner.nextInt();

                    productManager.removeProduct(id);

                    System.out.println("********** DANH SÁCH SẢN PHẨM **********");
                    productManager.showProductList();

                    System.out.println("****************************************");
                    break;
                case 4:
                    System.out.println("---Tìm sản phẩm theo tên: ");
                    System.out.print("Nhập tên sản phẩm cẩn tìm: ");
                    scanner.nextLine();
                    name = scanner.nextLine();

                    if (productManager.searchByName(name) == null) {
                        System.out.println("KHÔNG TÌM THẤY SẢN PHẨM " + name);
                    } else {
                        System.out.println(productManager.searchByName(name).toString());
                    }

                    System.out.println("********** DANH SÁCH SẢN PHẨM **********");
                    productManager.showProductList();

                    System.out.println("****************************************");
                    break;
                case 5: // Sắp xếp tăng dần
                    productManager.SortUpByPrice();
                    System.out.println("********** DANH SÁCH SẢN PHẨM **********");
                    productManager.showProductList();

                    System.out.println("****************************************");
                    break;
                case 6: // Sắp xếp giảm dần
                    productManager.SortDescendByPrice();
                    System.out.println("********** DANH SÁCH SẢN PHẨM **********");
                    productManager.showProductList();

                    System.out.println("****************************************");
                    break;
                case 0:
                    System.out.println("----- Thoát chương trình -----");
                    System.exit(0);
            }


            if (option < 0 || option > 6) {
                System.out.println("Nhập sai - Nhập lại giùm");
            }

        } while (option != 0);
    }
}
