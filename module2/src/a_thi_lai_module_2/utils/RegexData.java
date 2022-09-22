package a_thi_lai_module_2.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexData {
    static Scanner scanner = new Scanner(System.in);
    public static String regexStr(String temp, String regex, String error) {
        boolean check = true;
        do {
            if(temp.matches(regex)) {
                check = false;
                return temp;
            } else {
                System.out.println(error);
                temp = scanner.nextLine();
            }
        } while (check);
        return null;
    }
    public static String regexAge(String temp, String regex, String error) {
        boolean check = true;
        while (check) {
            try {
                if (Pattern.matches(regex, temp)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate age = LocalDate.parse(temp, formatter);
                    LocalDate now = LocalDate.now();
                    int current = Period.between(age, now).getYears();
                    if (current < 100 && current > 18) {
                        check = false;
                    } else {
                        throw new AgeException("Tuổi phải lớn hơn 18 và nhỏ hơn 100");
                    }
                } else {
                    throw new AgeException("Định dạng nhập vào không đúng");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                temp = scanner.nextLine();
            }
        }
        return temp;
    }

}
