package com.example.appdictionary.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository {
    private static Map<String, String> elVieWordMap = new HashMap<>();

    static {
        elVieWordMap.put("hello", "xin chào");
        elVieWordMap.put("thank you", "cảm ơn");
        elVieWordMap.put("sorry", "xin lỗi");
        elVieWordMap.put("happy", "hạnh phúc");
        elVieWordMap.put("funny", "vui vẻ");
    }

    public String convert(String input) {
        String result = "";
        for (Map.Entry<String, String> entry : elVieWordMap.entrySet()) {
            if (entry.getKey().equals(input)) {
                result = entry.getValue();
            }
        }
        return result;
    }
}
