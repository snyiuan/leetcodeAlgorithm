package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L438findAnagrams {
    public static void main(String[] args) {
        /**
         * "cbaebabacd"
         * "abc"
         */
    /*     System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("asdfsdekjadsoifzxoicuoiasdufpoi", "abc"));
        System.out.println(findAnagrams("udoiaf[qwiepofsld;fjalksdufoifbj[abnipaoidgbpasoidbposadibpoasidpbaoaisdpobiasdpobhiuapsdfbuaoifbujasdiofuviospuv[osadiuvjosadi", "abc"));
        System.out.println(findAnagrams("casdcasdjoijqwoejcabcabcbacbabdcaccaaasasjdopcjasdaaocjasodjcoasdjcoaacdsssdcascsdcascbascbabcbacba", "aa")); */
        List<Integer> res = new ArrayList<Integer>();
        res.add(5);
        res.add(5);
        res.remove((Object)5);
        System.out.println(res);


    }

    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] count = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }

        int differ = 0;
        for (int j = 0; j < 26; ++j) {
            if (count[j] != 0) {
                ++differ;
            }
        }

        if (differ == 0) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            if (count[s.charAt(i) - 'a'] == 1) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i) - 'a'] == 0) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            --count[s.charAt(i) - 'a'];

            if (count[s.charAt(i + pLen) - 'a'] == -1) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            ++count[s.charAt(i + pLen) - 'a'];
            
            if (differ == 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
    public static List<Integer> findAnagrams5(String s, String p) {













        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        int len = p.length();
        for (int i = 0; i < p.length(); i++) {
            ++sCount[s.charAt(i) - 97];
            ++pCount[p.charAt(i) - 97];
        }
        if (Arrays.equals(sCount, pCount)) {
            list.add(0);
        }

        for (int i = 0; i < s.length() - len; i++) {
            sCount[s.charAt(i) - 97]--;
            sCount[s.charAt(i + len)-97]++;
            if (Arrays.equals(sCount, pCount)) {
                list.add(i + 1);
            }

        }
        return list;
    }
}
