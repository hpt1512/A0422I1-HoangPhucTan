package ss10_list.exercise.array_list;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> integerMyList = new MyList<>(5);

        integerMyList.set(0,1);
        integerMyList.set(1,10);
        integerMyList.set(2,20);
        integerMyList.set(3,30);
        integerMyList.set(4,40);
        integerMyList.showArrayList();
        System.out.println();

        integerMyList.add(1, 123);
        integerMyList.showArrayList();
        System.out.println();
//        System.out.println(integerMyList.get(4));
    }
}
