import java.util.*;
class Solution {
    int day = 0;
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    dfs(maps, visited, i, j);
                    answer.add(day);
                    day = 0;
                }
            }
        }

        if (answer.isEmpty()) {
            return new int[]{-1};
        }
        Collections.sort(answer);

        return answer.stream().mapToInt(i -> i).toArray();
    }

    void dfs(String[] maps, boolean[][] visited, int x, int y) {
        int num = maps[x].charAt(y) - '0';
        day += num;
        visited[x][y] = true;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length()) {
                continue;
            }

            if (maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                dfs(maps, visited, nx, ny);
            }
        }
    }
}