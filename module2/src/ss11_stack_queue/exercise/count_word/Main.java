package ss11_stack_queue.exercise.count_word;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> stringMap = new TreeMap<>();
        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi : ");
        str = scanner.nextLine();

//        System.out.println(s);

        String[] arrayString = str.toLowerCase().split(" ");
        System.out.println(Arrays.toString(arrayString));

        for (String item : arrayString) {
            if (stringMap.containsKey(item)) {
                Integer value = stringMap.get(item);
                stringMap.put(item, value);
                value++;
                stringMap.replace(item, value);

            }
            else {
                stringMap.put(item, 1);
            }

        }


        Set<String> strings = stringMap.keySet();
        for (String string: strings) {
            System.out.println("Key: " + string
                    + " | Value: " + stringMap.get(string));
        }




    }
}
