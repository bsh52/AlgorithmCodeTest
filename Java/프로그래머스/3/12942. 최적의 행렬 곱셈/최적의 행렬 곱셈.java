import java.util.*;
class Solution {
    public int solution(int[][] matrix_sizes) {
        int answer = 0;
        int[][] dp = new int[matrix_sizes.length][matrix_sizes.length];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        for (int i = 0; i < matrix_sizes.length; i++) {
            for (int j = 0; j < matrix_sizes.length - i; j++) {
                int s = j;
                int e = j + i;
                if (s == e) {
                    dp[s][e] = 0;
                }
                for (int k = s; k < e; k++) {
                    dp[s][e] = Math.min(dp[s][e], dp[s][k] + dp[k + 1][e] + matrix_sizes[s][0] * matrix_sizes[k][1] * matrix_sizes[e][1]);
                }
            }
        }

        answer = dp[0][matrix_sizes.length - 1];

        return answer;
    }
}