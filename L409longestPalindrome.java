package leetCode;

import java.util.ArrayList;
import java.util.List;

public class L409longestPalindrome {
    public static void main(String[] args) {
        List list = new ArrayList();
        System.out.println(list.get(2));
    }

    public int longestPalindrome(String s) {
        List list = new ArrayList();
        
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i))) {
                cnt += 2;
                list.remove((Object) s.charAt(i));
            } else {
                list.add(s.charAt(i));
            }
        }
        if (!list.isEmpty()) {
            cnt++;
        }
        return cnt;
    }

}
