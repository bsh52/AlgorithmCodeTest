import java.util.*;
class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int[][][] costs = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(costs[i][j], Integer.MAX_VALUE);
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[3]));
        pq.add(new int[]{0, 0, 1, 0});
        pq.add(new int[]{0, 0, 2, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int dir = cur[2];
            int cost = cur[3];

            if (x == n - 1 && y == n - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
                    continue;
                }
                int nCost = dir == i ? cost + 100 : cost + 600;
                if (costs[nx][ny][i] >= nCost) {
                    costs[nx][ny][i] = nCost;
                    pq.add(new int[]{nx, ny, i, nCost});
                }
            }
        }

        int answer = Arrays.stream(costs[n - 1][n - 1]).min().getAsInt();
        return answer;
    }
}