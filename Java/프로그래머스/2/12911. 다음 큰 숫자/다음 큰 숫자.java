import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;

        String nBinary = Integer.toBinaryString(n);
        int count = 0;
        for (char c : nBinary.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }

        while (true) {
            n++;
            String nBinary2 = Integer.toBinaryString(n);
            int count2 = 0;
            for (char c : nBinary2.toCharArray()) {
                if (c == '1') {
                    count2++;
                }
            }
            if (count2 == count) {
                answer = n;
                break;
            }
        }

        return answer;
    }
}