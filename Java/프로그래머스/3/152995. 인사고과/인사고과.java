import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int a = scores[0][0];
        int b = scores[0][1];
        int sum = a + b;
        Arrays.sort(scores, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        int temp = 0;
        for (int[] score : scores) {
            if (a < score[0] && b < score[1]) {
                return -1;
            }

            if (temp <= score[1]) {
                temp = score[1];
                if (score[0] + score[1] > sum) {
                    answer++;
                }
            }
        }
        return answer;
    }
}