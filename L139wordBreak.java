package leetCode;

import java.util.*;

/**
 * @author zzq
 * @create 2021-09-30-10:48
 */
/*"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
 */
public class L139wordBreak {
    public static void main(String[] args) {
        String[] strs = new String[]{"apple", "pen", "apple"};
        String[] str2 = new String[]{"cats", "dog", "sand", "and", "cat"};
        String[] str3 = new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"};
        List<String> list1 = Arrays.asList(strs);
        List<String> list2 = Arrays.asList(str2);
        List<String> list3 = Arrays.asList(str3);
        L139wordBreak self = new L139wordBreak();
        System.out.println(self.wordBreak("applepenapple", list1));
        System.out.println(self.wordBreak("catsandog", list2));
        System.out.println(self.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", list3));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int start = 0;
        int cur = 1;
        return helper(s, wordDict);
    }

    private boolean helper(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }
}
