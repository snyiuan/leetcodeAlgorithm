package leetCode;

import java.util.HashMap;
import java.util.Map;

public class L205isIsomorphic {
    public static void main(String[] args) {
        System.out.println('a' - 0);
        System.out.println('z' - 0);
        int[] arr = new int[5];
        System.out.println(arr[4]);
        System.out.println(isIsomorphic("egg", "add"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map map = new HashMap<Character, Character>();  
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            } else if ((Character) map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }

        }
        return true;
    }

    public static boolean isIsomorphic1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map1 = new HashMap<Character, Character>();
        Map<Character, Character> map2 = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!map1.containsKey(s.charAt(i))) {
                if (map2.containsKey(t.charAt(i))) {
                    return false;
                }
                map1.put(s.charAt(i), t.charAt(i));
                map2.put(t.charAt(i), s.charAt(i));
            } else if (map1.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }
        return true;

    }
}
