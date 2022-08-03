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
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("asdfsdekjadsoifzxoicuoiasdufpoi", "abc"));
        System.out.println(findAnagrams("udoiaf[qwiepofsld;fjalksdufoifbj[abnipaoidgbpasoidbposadibpoasidpbaoaisdpobiasdpobhiuapsdfbuaoifbujasdiofuviospuv[osadiuvjosadi", "abc"));
        System.out.println(findAnagrams("casdcasdjoijqwoejcabcabcbacbabdcaccaaasasjdopcjasdaaocjasodjcoasdjcoaacdsssdcascsdcascbascbabcbacba", "aa"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
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
