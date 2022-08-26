package ss16_io_text_file.exercise.copy_flie;

import ss16_io_text_file.practice.find_max_write_file.FindMaxWriteFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {
    public List<String> readFile(String filePath) {
        List<String> strings = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader bfReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bfReader.readLine()) != null) {
                strings.add(line);
            }
            bfReader.close();
        } catch (Exception e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        return strings;
    }

    public void copyFile(String filePathSource, String filePathTarget) {
        try {
            CopyFile copyFile = new CopyFile();
            List<String> strings = copyFile.readFile(filePathSource);
            BufferedWriter bfWriter = new BufferedWriter(new FileWriter(filePathTarget));

            StringBuilder result = new StringBuilder();
            for (String item: strings) {
                result.append(item);
            }

            bfWriter.write(result.toString());
            bfWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CopyFile copyFile = new CopyFile();
        copyFile.copyFile("D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\ss16_io_text_file\\exercise\\copy_flie\\source_file.txt", "D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\ss16_io_text_file\\exercise\\copy_flie\\target_file.txt");
    }

}
