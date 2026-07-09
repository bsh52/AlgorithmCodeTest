import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            int len = 0;
            for (int j = 0; j + i <= s.length(); j += i) {
                int count = 1;
                int next = j + i;
                String sub = s.substring(j, j + i);
                while (next + i <= s.length() && sub.equals(s.substring(next, next + i))) {
                    count++;
                    next += i;
                }
                if (count == 1) len += i;
                else len += i + String.valueOf(count).length();
                j = next - i;
            }
            len += s.length() % i;
            answer = Math.min(answer, len);
        }

        return answer;
    }
}