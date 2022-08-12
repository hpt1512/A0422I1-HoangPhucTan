package maptree;

public class Test {
    public static void main(String[] args) {
//        MyLinkedList<String> list = new MyLinkedList<>();
//        list.addFirst("Da Nang");
//        list.add(0, "Ha Noi");
//        list.addLast("Ho Chi Minh");
//
//        MyLinkedList<String> listClone = list.clone();
//        System.out.println("List");
//        list.print();
//        System.out.println("List clone");
//        listClone.print();

        MyLinkedList<Student> list = new MyLinkedList<>();
        list.addFirst(new Student(1, "Nam", 20));
        list.addFirst(new Student(5, "Hung", 20));
        list.addFirst(new Student(6, "Thanh", 20));
//        list.addFirst(null);
//        list.print();

//        list.remove(new Student(6, "Hanh", 19));
        list.remove(null);
        list.print();
    }
}
