import java.util.*;
class Solution {
    int[] hintCount;
    int maxHint = 0;
    int answer = Integer.MAX_VALUE;
    public int solution(int[][] cost, int[][] hint) {
        hintCount = new int[cost.length];
        maxHint = cost[0].length - 1;
        dfs(0, 0, cost, hint);
        return answer;
    }

    private void dfs(int idx, int sum, int[][] cost, int[][] hint) {
        if (idx == cost.length) {
            answer = Math.min(answer, sum);
            return;
        }
        int total = sum + cost[idx][Math.min(hintCount[idx], maxHint)];
        if (idx < hint.length) {
            total += hint[idx][0];
            for (int i = 1; i < hint[idx].length; i++) {
                hintCount[hint[idx][i] - 1]++;
            }
            dfs(idx + 1, total, cost, hint);
            for (int i = 1; i < hint[idx].length; i++) {
                hintCount[hint[idx][i] - 1]--;
            }
        }

        total = sum + cost[idx][Math.min(hintCount[idx], maxHint)];
        dfs(idx + 1, total, cost, hint);
    }
}