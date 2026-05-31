class Solution {
    int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];
        int n = arr.length;
        dfs(arr, 0, 0, n);
        return answer;
    }

    void dfs(int[][] arr, int x, int y, int n) {
        int start = arr[x][y];
        if (isSame(arr, x, y, n, start)) {
            answer[start]++;
            return;
        }
        int size = n / 2;
        dfs(arr, x, y, size);
        dfs(arr, x, y + size, size);
        dfs(arr, x + size, y, size);
        dfs(arr, x + size, y + size, size);
    }

    private boolean isSame(int[][] arr, int x, int y, int n, int start) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] != start) return false;
            }
        }
        return true;
    }
}