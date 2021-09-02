package leetCode;

import java.util.Stack;

/**
 * @author zzq
 * @create 2021-08-26-9:46
 */
public class L20isValid {
    public static void main(String[] args) {
        String str1 = "()";
        String str2 = "()[]{}";
        String str3 = "(]";
        String str4 = "([)]";
        String str5 = "{[]}";
        System.out.println(isValid(str1));
        System.out.println(isValid(str2));
        System.out.println(isValid(str3));
        System.out.println(isValid(str4));
        System.out.println(isValid(str5));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid1(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                if (stack.peek().equals(')') || stack.peek().equals(']') || stack.peek().equals('}')) {
                    return false;
                }
            } else {
                switch (c) {
                    case ')':
                        if (stack.peek().equals('(')) {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                        break;
                    case ']':
                        if (stack.peek().equals('[')) {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                        break;
                    case '}':
                        if (stack.peek().equals('{')) {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                        break;
                    default:
                        stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}
