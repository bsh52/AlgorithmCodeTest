class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] visited = new int[n + 1][m + 1];

        for (int[] puddle : puddles) {
            visited[puddle[1]][puddle[0]] = -1;
        }
        visited[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (visited[i][j] == -1) {
                    continue;
                }
                if (visited[i - 1][j] != -1) {
                    visited[i][j] += visited[i - 1][j];
                    visited[i][j] %= 1000000007;
                }
                if (visited[i][j - 1] != -1) {
                    visited[i][j] += visited[i][j - 1];
                    visited[i][j] %= 1000000007;
                }
            }
        }
        answer = visited[n][m];

        return answer;
    }
}