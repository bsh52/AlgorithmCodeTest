import java.util.*;
class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    boolean[][] visited;
    int n, m, count;
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        int[] colSum = new int[m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[j][i] == 0 || visited[j][i]) {
                    continue;
                }
                boolean[] visitCol = new boolean[m];
                count = 0;
                bfs(j, i, land, visitCol);
                for (int k = 0; k < m; k++) {
                    if (visitCol[k]) {
                        colSum[k] += count;
                    }
                }
            }
        }

        answer = Arrays.stream(colSum).max().getAsInt();

        return answer;
    }

    void bfs(int x, int y, int[][] land, boolean[] visitCol) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        visitCol[y] = true;
        count++;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || land[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }
                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                visitCol[ny] = true;
                count++;
            }
        }
    }
}