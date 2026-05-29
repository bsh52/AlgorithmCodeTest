class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(n, computers, i, visited);
                answer++;
            }
        }

        return answer;
    }

    void dfs(int n, int[][] computers, int depth, boolean[] visited) {
        visited[depth] = true;
        for (int i = 0; i < n; i++) {
            if (computers[depth][i] == 1 && !visited[i]) {
                dfs(n, computers, i, visited);
            }
        }
    }
}