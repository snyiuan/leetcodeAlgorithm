package leetCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author zzq
 * @create 2021-09-07-17:25
 */
public class L567checkInclusion {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        String s3 = "eidboaoo";

        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{1, 2, 3, 4, 5};
        L567checkInclusion l567checkInclusion = new L567checkInclusion();
        System.out.println(l567checkInclusion.checkInclusion3(s1, s3));
    }

    public boolean checkInclusion3(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] arr = new int[26];
        int s1len = s1.length();
        int s2len = s2.length();
        for (int i = 0; i < s1len; i++) {
            char c = s1.charAt(i);
            arr[c - 97]++;
        }
        A:
        for (int i = 0; i < s2.length(); i++) {
            if (i + s1len > s2len) {
                break;
            } else {
                String sub = s2.substring(i, i + s1len);
                int[] tmp = new int[26];
                for (int j = 0; j < sub.length(); j++) {
                    char c = sub.charAt(j);
                    tmp[c - 97]++;
                }
                if(Arrays.equals(arr,tmp)){
                    return true;
                }else {
                    continue A;
                }
       /*         for (int j = 0; j < arr.length; j++) {
                    if (arr[j] != tmp[j]) {
                        continue A;
                    }
                }*/
            }
        }
        return false;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int s1len = s1.length();
        int s2len = s2.length();
        A:
        for (int i = 0; i < s2.length(); i++) {
            if (i + s1len > s2len) {
                break;
            } else {
                HashMap<Character, Integer> copy = new HashMap();
                copy.putAll(map);
                String substring = s2.substring(i, i + s1len);
                for (int j = 0; j < substring.length(); j++) {
                    char c = substring.charAt(j);
                    if (copy.containsKey(c) && copy.get(c) == 1) {
                        copy.remove(c);
                    } else if (copy.containsKey(c)) {
                        copy.put(c, copy.get(c) - 1);
                    } else {
                        continue A;
                    }
                }
                if (copy.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }
}
