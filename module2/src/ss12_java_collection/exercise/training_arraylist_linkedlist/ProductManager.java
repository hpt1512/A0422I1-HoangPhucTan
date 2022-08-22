package ss12_java_collection.exercise.training_arraylist_linkedlist;

import ss12_java_collection.practice.comparable_and_comparator.AgeComparator;
import ss12_java_collection.practice.distinguish_hashset_hashmap.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    private ArrayList<Product> productArrayList = new ArrayList<>();

    public  ProductManager() {

    }
    public  ProductManager(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }


    public void addProduct(int id, String name, int price) {
        Product product = new Product(id, name, price);
        productArrayList.add(product);
    }

    public void removeProduct(int id) {
        int count = 0;
        for (int i = 0; i < productArrayList.size(); i++) {
            if (id == productArrayList.get(i).getId()) {
                count++;
                productArrayList.remove(i);
            }
        }
        if (count == 0) {
            System.out.println("--*** ERROR: Không tồn tại sản phẩm " + id);
        }
    }

    public void showProductList() {
        for (int i = 0; i < productArrayList.size(); i++) {
            System.out.println("STT : " + (i + 1));
            System.out.println("id : " + productArrayList.get(i).getId());
            System.out.println("name : " + productArrayList.get(i).getName());
            System.out.println("price : " + productArrayList.get(i).getPrice());
        }
    }

    public void updateProduct(int id) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        for (int i = 0; i < productArrayList.size(); i++) {
            if (id == 0) break;
            if (id == productArrayList.get(i).getId()) {
                System.out.println("Sửa thông tin sản phẩm " + productArrayList.get(i).getId() + " :");
                System.out.print("Nhập tên sản phẩm: ");
                String newName = scanner.nextLine();
                System.out.print("Nhập giá sản phẩm: ");
                int newPrice = Integer.parseInt(scanner.nextLine());

                productArrayList.get(i).setName(newName);
                productArrayList.get(i).setPrice(newPrice);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("--*** ERROR: Không tồn tại sản phẩm " + id);
        }
    }

    public Product searchByName(String name) {
        for (Product product : productArrayList) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
    //    sắp xếp tăng dần
    public void SortUpByPrice() {
        PriceComparatorUp priceComparatorUp = new PriceComparatorUp();
        Collections.sort(productArrayList, priceComparatorUp);
    }
    //    sắp xếp giảm dần
    public void SortDescendByPrice() {
        PriceComparatorDescend priceComparatorDescend = new PriceComparatorDescend();
        Collections.sort(productArrayList, priceComparatorDescend);
    }
}
