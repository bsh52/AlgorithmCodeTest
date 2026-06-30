import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        int total = t * m;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < total; i++) {
            sb.append(Integer.toString(i, n));
        }

        String answer = "";
        for (int i = 0; i < total; i++) {
            if (i % m == p - 1) {
                answer += sb.charAt(i);
            }
        }

        return answer.toUpperCase();
    }
}