class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    boolean[][] visited;
    int m, n;
    int count = 0;
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        this.m = m;
        this.n = n;
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 0 || visited[i][j]) continue;
                dfs(picture, i, j);
                numberOfArea++;
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
                count = 0;
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    void dfs(int[][] picture, int x, int y) {
        int target = picture[x][y];
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || picture[nx][ny] != target || visited[nx][ny]) continue;
            visited[nx][ny] = true;
            dfs(picture, nx, ny);
        }
    }
}