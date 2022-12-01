package leetCode;

public class L394decodeString {
    public static void main(String[] args) {
        System.out.println((int) '0');
        System.out.println((int) '1');
        System.out.println((int) '2');
        System.out.println((int) '3');
        System.out.println((int) '4');
        System.out.println((int) '5');
        System.out.println((int) '6');
        System.out.println((int) '7');
        System.out.println((int) '8');
        System.out.println((int) '9');
        System.out.println('1' > 48);

        System.out.println(decodeString("3[a2[c]]"));
    }

    public static String decodeString(String s) {
        return helper(s);
    }

    public static String helper(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                int numStart = index;
                int numEnd = index;
                while (s.charAt(index) != '[') {
                    numEnd++;
                    index++;
                }
                index++;
                int count = Integer.parseInt(s.substring(numStart, numEnd));
                String str = helper(s.substring(index));
                while (count > 0) {
                    sb.append(str);
                    count--;
                }

                int left = 1;
                while (index < s.length()) {
                    if (s.charAt(index) == '[') {
                        left++;
                    } else if (s.charAt(index) == ']') {
                        left--;
                        if (left == 0) {
                            index++;
                            break;
                        }
                    }
                    index++;
                }
                
            } else if (s.charAt(index) == ']') {
                break;
            } else {
                sb.append(s.charAt(index));
                index++;
            }
        }
        return sb.toString();
    }
}
