import java.util.*;
class Solution {
    public String solution(long n, String[] bans) {
        Arrays.sort(bans, Comparator.comparingLong(this::convertToLong));
        for (String ban : bans) {
            if (n >= convertToLong(ban)) {
                n++;
            }
        }
        String answer = convertToString(n);

        return answer;
    }

    String convertToString(long n) {
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            char c = (char) ('a' + (n % 26));
            sb.append(c);
            n /= 26;
        }
        return sb.reverse().toString();
    }

    long convertToLong(String s) {
        long result = 0;
        for (int i = 0; i < s.length(); i++) {
            long num = s.charAt(i) - 'a' + 1;
            result = result * 26 + num;
        }
        return result;
    }
}