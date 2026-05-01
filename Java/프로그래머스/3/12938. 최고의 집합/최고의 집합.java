import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        int div = s / n;
        int rem = s % n;
        Arrays.fill(answer, div);

        for (int i = 0; i < rem; i++) {
            answer[n - 1 - i]++;
        }

        return answer;
    }
}