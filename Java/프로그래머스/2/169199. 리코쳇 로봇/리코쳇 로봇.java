import java.util.*;
class Solution {
    int[] dx =  {0, 0, 1, -1};
    int[] dy =  {-1, 1, 0, 0};
    String[][] strArr;
    int startX = 0;
    int startY = 0;
    int endX = 0;
    int endY = 0;
    boolean[][] visited;
    public int solution(String[] board) {
        int answer = -1;
        strArr = new String[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                strArr[i][j] = board[i].substring(j, j + 1);
                if (strArr[i][j].equals("R")) {
                    startX = i;
                    startY = j;
                }
                if (strArr[i][j].equals("G")) {
                    endX = i;
                    endY = j;
                }
            }
        }

        bfs(startX, startY);

        if (!strArr[endX][endY].equals("G")) {
            answer = Integer.parseInt(strArr[endX][endY]);
        }

        return answer;
    }

    void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        strArr[x][y] = "0";

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int cx = cur[0];
                int cy = cur[1];
                while (true) {
                    cx += dx[i];
                    cy += dy[i];
                    if (cx >= 0 && cx < strArr.length && cy >= 0 && cy < strArr[0].length) {
                        if ("D".equals(strArr[cx][cy])) {
                            cx -= dx[i];
                            cy -= dy[i];
                            break;
                        }
                    } else {
                        cx -= dx[i];
                        cy -= dy[i];
                        break;
                    }
                }

                if (!visited[cx][cy]) {
                    strArr[cx][cy] = String.valueOf(Integer.parseInt(strArr[cur[0]][cur[1]]) + 1);
                    visited[cx][cy] = true;
                    if ("G".equals(strArr[cx][cy])) {
                        return;
                    }
                    queue.add(new int[]{cx, cy});
                }
            }
        }
    }
}