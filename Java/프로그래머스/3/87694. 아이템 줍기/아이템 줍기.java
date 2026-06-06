import java.util.*;
class Solution {
    int[][] map = new int[102][102];
    boolean[][] visited = new boolean[102][102];
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        makeDouble(rectangle);
        init(rectangle);
        answer = bfs(rectangle, characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;

        return answer;
    }

    private void init(int[][] rectangle) {
        for (int[] rect : rectangle) {
            for (int i = rect[0]; i <= rect[2]; i++) {
                for (int j = rect[1]; j <= rect[3]; j++) {
                    map[i][j] += 1;
                }
            }
        }
    }

    private int bfs(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{characterX, characterY, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];
            visited[x][y] = true;

            if (x == itemX && y == itemY) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isPossible(rectangle, nx, ny) && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny, count + 1});
                }
            }
        }
        return -1;
    }

    private boolean isPossible(int[][] rectangle, int x, int y) {
        if (map[x][y] == 0) return false;
        for (int[] rect : rectangle) {
            if (rect[0] < x && x < rect[2] && rect[1] < y && y < rect[3]) {
                return false;
            }
        }
        return true;
    }

    private void makeDouble(int[][] rectangle) {
        for (int[] rect : rectangle) {
            rect[0] *= 2;
            rect[1] *= 2;
            rect[2] *= 2;
            rect[3] *= 2;
        }
    }
}