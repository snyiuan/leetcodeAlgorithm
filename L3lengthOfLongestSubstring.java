package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author zzq
 * @create 2021-09-07-9:39
 */
public class L3lengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = "abcabcbb";
        String str2 = "bbbbb";
        String str3 = "au";
        String str4 = "aab";
        String str5 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));
        System.out.println(lengthOfLongestSubstring(str2));
        System.out.println(lengthOfLongestSubstring(str3));
        System.out.println(lengthOfLongestSubstring(str4));
        System.out.println(lengthOfLongestSubstring(str5));
    }


    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int l = 0;
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                l = Math.max(l, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - l + 1);
        }
        return res;
    }
}
