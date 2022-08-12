package maptree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountCharacter {
    public static void main(String[] args) {
        String st = "Hom nay la ngay thu tu";
        Map map = count(st);
        Set<Character> keys = map.keySet();
        for(Character c: keys) {
            System.out.println(c + ": " + map.get(c) + " lan");
        }
//        String b = null;
//        String a = b + "1";
//        System.out.println(a);
//        Integer c = null;
//        int d = c;
    }

    public static Map<Character, Integer> count(String st) {
        Map<Character, Integer> map = new HashMap<>();
        st = st.toLowerCase();
        for (int i = 0; i < st.length(); i++) {
            char c = st.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
        }
        return map;
    }
}
