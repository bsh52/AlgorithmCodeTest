import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0;
        int maxCop = 0;

        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }

        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);

        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        int MAX_VALUE = Integer.MAX_VALUE;

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], MAX_VALUE);
        }

        dp[alp][cop] = 0;

        for (int a = alp; a <= maxAlp; a++) {
            for (int c = cop; c <= maxCop; c++) {
                if (dp[a][c] == MAX_VALUE) continue;

                int time = dp[a][c];

                if (a < maxAlp) {
                    dp[a + 1][c] = Math.min(dp[a + 1][c], time + 1);
                }

                if (c < maxCop) {
                    dp[a][c + 1] = Math.min(dp[a][c + 1], time + 1);
                }

                for (int[] problem : problems) {
                    int alpReq = problem[0];
                    int copReq = problem[1];
                    int alpRwd = problem[2];
                    int copRwd = problem[3];
                    int cost = problem[4];

                    if (a < alpReq || c < copReq) continue;

                    int nextAlp = Math.min(maxAlp, a + alpRwd);
                    int nextCop = Math.min(maxCop, c + copRwd);

                    dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], time + cost);
                }
            }
        }

        return dp[maxAlp][maxCop];
    }
}