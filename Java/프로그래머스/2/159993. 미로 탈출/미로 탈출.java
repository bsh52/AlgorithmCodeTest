import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = -1;
        int[] start = {0, 0};
        int[] end = {0, 0};
        int[] lever = {0, 0};
        int n = maps.length;
        int m = maps[0].length();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (c == 'E') {
                    end[0] = i;
                    end[1] = j;
                } else if (c == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }
            }
        }

        int a = bfs(maps, start, lever);
        int b = bfs(maps, lever, end);
        if (a != -1 && b != -1) {
            answer = a + b;
        }
        return answer;
    }

    int bfs(String[] maps, int[] start, int[] end) {
        int n = maps.length;
        int m = maps[0].length();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[n][m];
        int x = start[0];
        int y = start[1];

        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            x = now[0];
            y = now[1];

            if (x == end[0] && y == end[1]) {
                return visited[x][y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || maps[nx].charAt(ny) == 'X' || visited[nx][ny] > 0) {
                    continue;
                }
                visited[nx][ny] = visited[x][y] + 1;
                queue.add(new int[]{nx, ny});
            }
        }
        return -1;
    }
}