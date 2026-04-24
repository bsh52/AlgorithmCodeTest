import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < t * m; i++) {
            String s = Integer.toString(i, n).toUpperCase();
            String[] arr = s.split("");
            for (String string : arr) {
                list.add(string);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (i % m == p - 1 && answer.length() < t) {
                answer += list.get(i);
            }
        }
        return answer;
    }
}