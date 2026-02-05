import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();

        int[] countX = new int[10];
        int[] countY = new int[10];

        for (char c : X.toCharArray()) {
            countX[c - '0']++;
        }
        
        for (char c : Y.toCharArray()) {
            countY[c - '0']++;
        }
        
        for (int i = 9; i >= 0; i--) {
            int commonCount = Math.min(countX[i], countY[i]);
            for (int j = 0; j < commonCount; j++) {
                answer.append(i);
            }
        }
        
        if (answer.length() == 0) {
            answer.append("-1");
        } else if (answer.charAt(0) == '0') {
            answer.setLength(1);
        }
        
        return answer.toString();
    }
}