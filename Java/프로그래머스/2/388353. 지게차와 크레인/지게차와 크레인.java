class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        char[][] chars = new char[storage.length][];
        for (int i = 0; i < storage.length; i++) {
            chars[i] = storage[i].toCharArray();
        }

        for (String request : requests) {
            char c = request.charAt(0);
            if (request.length() == 1) {
                useCar(chars, c);
            } else {
                useCrane(chars, c);
            }
        }

        for (char[] arr : chars) {
            for (char c : arr) {
                if (c != '0') {
                    answer++;
                }
            }
        }

        return answer;
    }

    void useCrane(char[][] chars, char c) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                if (chars[i][j] == c) {
                    chars[i][j] = '0';
                }
            }
        }
    }

    void useCar(char[][] chars, char c) {
        boolean[][] visited = new boolean[chars.length][chars[0].length];

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                if (!visited[i][j] && (i == 0 || j == 0 || i == chars.length - 1 || j == chars[0].length - 1)) {
                    dfs(chars, c, i, j, visited);
                }
            }
        }

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                if (chars[i][j] == '1') {
                    chars[i][j] = '0';
                }
            }
        }
    }

    void dfs(char[][] chars, char c, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= chars.length || y < 0 || y >= chars[0].length || visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        if (chars[x][y] == c) {
            chars[x][y] = '1';
        }
        if (chars[x][y] != '0') {
            return;
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(chars, c, nx, ny, visited);
        }
    }
}