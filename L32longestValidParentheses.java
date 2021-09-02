package leetCode;

import java.util.Stack;

/**
 * @author zzq
 * @create 2021-08-28-17:04
 */
public class L32longestValidParentheses {
    public static void main(String[] args) {
        String str = "(()";
        String str1 = ")()())";
        String str2 = "(";
        String str3 = ")()())";
        String str4 = "()(()";
        String str5 = "(()";
        System.out.println(longestValidParentheses(str));
        System.out.println(longestValidParentheses(str1));
        System.out.println(longestValidParentheses(str2));
        System.out.println(longestValidParentheses(str3));
        System.out.println(longestValidParentheses(str4));
        System.out.println(longestValidParentheses(str5));
    }

    public static int longestValidParentheses1(String s) {
        Stack<Integer> stack = new Stack();
        int start = -1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        res = Math.max(res, i - start);
                    } else {
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
        }
        return res;
    }

    public static int longestValidParentheses(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength,left*2);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                right++;
            } else {
                left++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength,left*2);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return maxLength;
    }
}
