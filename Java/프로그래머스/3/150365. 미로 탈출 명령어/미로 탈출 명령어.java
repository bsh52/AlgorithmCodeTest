import java.util.*;
class Solution {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    String[] dir = {"d", "l", "r", "u"};
    int[] start, end;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        start = new int[]{x - 1, y - 1};
        end = new int[]{r - 1, c - 1};

        StringBuilder sb = new StringBuilder();

        return dfs(sb, k, start[0], start[1], n, m, end[0], end[1]) ? sb.toString() : "impossible";
    }

    boolean dfs(StringBuilder sb, int k, int x, int y, int n, int m, int r, int c) {
        if (sb.length() == k) {
            if (x == end[0] && y == end[1]) {
                return true;
            } else {
                return false;
            }
        }

        int remain = k - sb.length();
        int distance = Math.abs(x - r) + Math.abs(y - c);
        if (remain < distance || (remain - distance) % 2 != 0) return false;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                sb.append(dir[i]);
                if (dfs(sb, k, nx, ny, n, m, r, c)) return true;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return false;
    }
}