import java.util.*;
class Solution {
    public int solution(String[] words) {
        int answer = 0;
        Arrays.sort(words);

        for (int i = 0; i < words.length; i++) {
            int prevCnt = 0;
            if (i != 0) {
                prevCnt = check(words[i], words[i - 1]);
            }
            int nextCnt = 0;
            if (i != words.length - 1) {
                nextCnt = check(words[i], words[i + 1]);
            }
            answer += Math.max(prevCnt, nextCnt);
        }
        return answer;
    }

    private int check(String word, String other) {
        int len = Math.min(word.length(), other.length());

        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (word.charAt(i) != other.charAt(i)) {
                break;
            }
            cnt++;
        }

        if (cnt != word.length()) {
            return cnt + 1;
        }

        return cnt;
    }
}