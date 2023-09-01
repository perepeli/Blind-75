package problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()];

        for(int start = s.length()-1; start >= 0; start--) {

            for(int end = start; end < s.length(); end++) {
                String str = s.substring(start, end+1);

                if(end == s.length()-1) {
                    if(set.contains(str)) {
                        dp[start] = true;
                    }
                } else {
                    if(set.contains(str) && dp[end+1] == true) {
                        dp[start] = true;
                        break;
                    }
                }
            }
        }

        return dp[0];
    }
}
