import java.util.*;

class Solution {
    int[][] map = {
            {1, 7, 6, 7, 5, 4, 5, 3, 2, 3},
            {7, 1, 2, 4, 2, 3, 5, 4, 5, 6},
            {6, 2, 1, 2, 3, 2, 3, 5, 4, 5},
            {7, 4, 2, 1, 5, 3, 2, 6, 5, 4},
            {5, 2, 3, 5, 1, 2, 4, 2, 3, 5},
            {4, 3, 2, 3, 2, 1, 2, 3, 2, 3},
            {5, 5, 3, 2, 4, 2, 1, 5, 3, 2},
            {3, 4, 5, 6, 2, 3, 5, 1, 2, 4},
            {2, 5, 4, 5, 3, 2, 3, 2, 1, 2},
            {3, 6, 5, 4, 5, 3, 2, 4, 2, 1}
    };
    public int solution(String numbers) {
        int[][] dp = new int[10][10];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        dp[4][6] = 0;

        for (int i = 0; i < numbers.length(); i++) {
            int target = numbers.charAt(i) - '0';
            int[][] next = new int[10][10];
            for (int[] ints : next) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }

            for (int left = 0; left < 10; left++) {
                for (int right = 0; right < 10; right++) {
                    if (dp[left][right] == Integer.MAX_VALUE) {
                        continue;
                    }
                    int cost = dp[left][right];

                    if (target != right) {
                        next[target][right] = Math.min(next[target][right], cost + map[left][target]);
                    }
                    if (target != left) {
                        next[left][target] = Math.min(next[left][target], cost + map[right][target]);
                    }
                }
            }
            dp = next;
        }
        int answer = Integer.MAX_VALUE;

        for (int left = 0; left < 10; left++) {
            for (int right = 0; right < 10; right++) {
                answer = Math.min(answer, dp[left][right]);
            }
        }

        return answer;
    }
}