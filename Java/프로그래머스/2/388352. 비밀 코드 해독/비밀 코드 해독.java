class Solution {
    int answer;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        dfs(1, 0, n, q, ans, new int[5]);
        return answer;
    }

    void dfs(int start, int depth, int n, int[][] q, int[] ans, int[] arr) {
        if (depth == 5) {
            checkAnswer(n, q, ans, arr);
            return;
        }
        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1, n, q, ans, arr);
        }
    }

    void checkAnswer(int n, int[][] q, int[] ans, int[] arr) {
        int count = 0;
        for (int i = 0; i < q.length; i++) {
            int[] q_arr = q[i];
            int q_count = 0;
            for (int j = 0; j < q_arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if (q_arr[j] == arr[k]) {
                        q_count++;
                    }
                }
            }
            if (q_count == ans[i]) {
                count++;
            }
        }
        if (count == q.length) {
            answer++;
        }
    }
}