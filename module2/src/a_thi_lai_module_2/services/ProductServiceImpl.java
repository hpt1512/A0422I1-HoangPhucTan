package a_thi_lai_module_2.services;

import a_thi_lai_module_2.models.Product;
import a_thi_lai_module_2.models.ProductIn;
import a_thi_lai_module_2.models.ProductOut;
import pitch.utils.RegexData;
import a_thi_lai_module_2.utils.ReadAndWrite;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductServiceImpl implements ProductService {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    private List<Product> productArrayList = new ArrayList<>();
    private static int count_idProduct = 1;

    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void displayProduct() {
        productArrayList = (List<Product>) ReadAndWrite.read("D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\a_thi_lai_module_2\\data\\products.csv");
        for (Product product : productArrayList) {
            System.out.println(product.toString());
        }
    }

    @Override
    public void addProductIn() {
        int id = count_idProduct++;
        try {
            System.out.println("Nhập mã sản phẩm: ");
            String codeProduct = inputCodeProduct();
            System.out.println("Nhập tên sản phẩm: ");
            String nameProduct = scanner.nextLine();
            System.out.println("Nhập giá sản phẩm: ");
            int price = inputPrice();
            System.out.println("Nhập số lượng: ");
            int count = inputCount();
            System.out.println("Nhập nhà sản xuất: ");
            String nsx = scanner.nextLine();
            System.out.println("Nhập giá nhập khẩu: ");
            int priceIn = inputPrice();
            System.out.println("Nhập tỉnh thành nhập khẩu: ");
            String proviceIn = scanner.nextLine();
            System.out.println("Nhập thuế nhập khẩu: ");
            int thueIn = Integer.parseInt(scanner.nextLine());

            ProductIn productIn = new ProductIn(id, codeProduct, nameProduct, price, count, nsx, priceIn, proviceIn, thueIn);
            productArrayList.add(productIn);

            System.out.println(ANSI_CYAN + "-- Thêm mới thành công --" + ANSI_RESET);
        } catch (Exception e) {
            System.err.println("Nhập sai định dạng");
        }
        // Ghi file csv
        ReadAndWrite.write(productArrayList, "D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\a_thi_lai_module_2\\data\\products.csv");
    }

    @Override
    public void addProductOut() {
        int id = count_idProduct++;
        try {
            System.out.println("Nhập mã sản phẩm: ");
            String codeProduct = inputCodeProduct();
            System.out.println("Nhập tên sản phẩm: ");
            String nameProduct = scanner.nextLine();
            System.out.println("Nhập giá sản phẩm: ");
            int price = inputPrice();
            System.out.println("Nhập số lượng: ");
            int count = inputCount();
            System.out.println("Nhập nhà sản xuất: ");
            String nsx = scanner.nextLine();
            System.out.println("Nhập giá xuất khẩu: ");
            int priceOut = inputPrice();
            System.out.println("Nhập quốc gia nhập sản phẩm: ");
            String countryOut = scanner.nextLine();

            ProductOut productOut = new ProductOut(id, codeProduct, nameProduct, price, count, nsx, priceOut, countryOut);
            productArrayList.add(productOut);

            System.out.println(ANSI_CYAN + "-- Thêm mới thành công --" + ANSI_RESET);
        } catch (Exception e) {
            System.err.println("Nhập sai định dạng");
        }
        // Ghi file csv
        ReadAndWrite.write(productArrayList, "D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\a_thi_lai_module_2\\data\\products.csv");

    }

    @Override
    public void deleteProduct() {
        System.out.print("Nhập id sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        int count = 0;
        for (int i = 0; i < productArrayList.size(); i++) {
            if (id == productArrayList.get(i).getId()) {
                count++;
                productArrayList.remove(i);
                System.out.println(ANSI_CYAN + "-- Xoá thành công --" + ANSI_RESET);
            }
        }
        if (count == 0) {
            System.err.println("KHÔNG TÌM THẤY " + id);
        }
        // Ghi file csv
        ReadAndWrite.write(productArrayList, "D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\a_thi_lai_module_2\\data\\products.csv");

    }

    @Override
    public void searchProduct() {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String nameFind = scanner.nextLine();
        int count = 0;
        for (Product product : productArrayList) {
            if (product.getNameProduct().toLowerCase().contains(nameFind.toLowerCase())) {
                count++;
                System.out.println(product.toString());
            }
        }
        if (count == 0) {
            System.out.println("Không tìm thấy sản phẩm " + nameFind);
        }
    }


    // Validate input value
    private String inputCodeProduct() {
        String id = scanner.nextLine();
        return RegexData.regexStr(id,"^SP[0-9][0-9]$", "Nhập sai định dạng, id khách hàng phải có định dạng là SPXX");
    }
    private int inputPrice() {
        int price;
        do {
            price  = Integer.parseInt(scanner.nextLine());
            if (price <= 0) {
                System.out.println("Nhập sai - Giá phải lớn hơn 0");
            }
        } while (price <= 0);

        return price;
    }
    private int inputCount() {
        int count;
        do {
            count  = Integer.parseInt(scanner.nextLine());
            if (count <= 0) {
                System.out.println("Nhập sai - Giá phải lớn hơn 0");
            }
        } while (count <= 0);

        return count;
    }
}
