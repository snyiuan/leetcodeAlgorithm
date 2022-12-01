package leetCode;

import java.util.HashMap;
import java.util.Map;

public class L424characterReplacement {
    public static void main(String[] args) {
        // String s = "01234567";
        // System.out.println(s.substring(1, 2));

    

    }

    public static int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int max = 0;
        int len = s.length();
        int[] arr= new int[26];
        while(r < len){
            arr[s.charAt(r)-'A']++;
            max = Math.max(max,arr[s.charAt(r)-'A']);
            if(r-l+1-max>k){
                arr[s.charAt(l)-'A']--;
                l++;
            }
            r++;
        }
        return r-l;
    }
    public static int characterReplacement2(String s, int k) {
        int[] num = new int[26];
        int n = s.length();
        int maxn = 0;
        int left = 0, right = 0;
        while (right < n) {
            num[s.charAt(right) - 'A']++;
            maxn = Math.max(maxn, num[s.charAt(right) - 'A']);
            if (right - left + 1 - maxn > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;

    }
}
