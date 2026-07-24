import java.util.*;
class Solution {
    int answer;
    boolean[][][] visited;
    public int solution(int[][] info, int n, int m) {
        answer = Integer.MAX_VALUE;
        visited = new boolean[info.length + 1][n + 1][m + 1];
        dfs(0, 0, 0, n, m, info);

        if (answer != Integer.MAX_VALUE) {
            return answer;
        }

        return -1;
    }

    private void dfs(int depth, int aTotal, int bTotal, int n, int m, int[][] info) {
        if (visited[depth][aTotal][bTotal]) {
            return;
        }
        if (depth == info.length) {
            answer = Math.min(answer, aTotal);
            return;
        }
        visited[depth][aTotal][bTotal] = true;
        if (bTotal + info[depth][1] < m) {
            dfs(depth + 1, aTotal, bTotal + info[depth][1], n, m, info);
        }
        if (aTotal + info[depth][0] < n) {
            dfs(depth + 1, aTotal + info[depth][0], bTotal, n, m, info);
        }
    }
}