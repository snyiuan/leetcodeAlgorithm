package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L299getHint {
    public static void main(String[] args) {
        

    }

    public String getHint(String secret, String guess) {
        int[] count1 = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            count1[secret.charAt(i) - '0']++;

        }
        int right = 0;
        int wrong = 0;

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                count1[guess.charAt(i) - '0']--;
                right++;
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) != secret.charAt(i)) {
                if(count1[guess.charAt(i) - '0']>0){
                    count1[guess.charAt(i) - '0']--;    
                    wrong++;
                };
            }
        }
        return Integer.toString(right) + "A" + Integer.toString(wrong) + "B";
    }

}
