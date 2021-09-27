package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzq
 * @create 2021-09-26-10:14
 */
public class L17letterCombinations {
    public static void main(String[] args) {
        System.out.println('2' - '3');
        L17letterCombinations self = new L17letterCombinations();
        System.out.println(self.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        //2-9
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        String[] arr = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(list, sb, arr, digits, 0);
        return list;
    }

    public void helper(List<String> list, StringBuilder sb, String[] map, String digits, int index) {
        if (index >= digits.length()) {
            list.add(sb.toString());
            return;
        }
        String value = map[digits.charAt(index) - '2'];
        for (int i = 0; i < value.length(); i++) {
            sb.append(value.charAt(i));
            helper(list, sb, map, digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
