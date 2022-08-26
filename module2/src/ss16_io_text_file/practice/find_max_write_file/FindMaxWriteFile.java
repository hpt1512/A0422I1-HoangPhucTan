package ss16_io_text_file.practice.find_max_write_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FindMaxWriteFile {
    public List<Integer> readFile(String filePath) {
        List<Integer> numberList = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader bfReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bfReader.readLine()) != null) {
                numberList.add(Integer.parseInt(line));
            }
            bfReader.close();
        } catch (Exception e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        return numberList;
    }

    public void writeFile(String filePath, int max) {
        try {
            BufferedWriter bfWriter = new BufferedWriter(new FileWriter(filePath));
            bfWriter.write("Gía trị lớn nhất là: " + max);
            bfWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int findMax(List<Integer> numbers) {
//        numbers = new ArrayList<>();
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        FindMaxWriteFile readAndWriteFile = new FindMaxWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\ss16_io_text_file\\practice\\find_max_write_file\\numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\ss16_io_text_file\\practice\\find_max_write_file\\result.txt", maxValue);
    }

}
