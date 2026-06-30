class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] map = new int[board.length + 1][board[0].length + 1];

        for (int[] ints : skill) {
            int x1 = ints[1];
            int y1 = ints[2];
            int x2 = ints[3];
            int y2 = ints[4];
            int damage = ints[0] == 1 ? -ints[5] : ints[5];

            map[x1][y1] += damage;
            map[x1][y2 + 1] -= damage;
            map[x2 + 1][y1] -= damage;
            map[x2 + 1][y2 + 1] += damage;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                map[i][j] = map[i][j - 1] + map[i][j];
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            for (int j = 1; j < board.length; j++) {
                map[j][i] = map[j - 1][i] + map[j][i];
            }
        }

        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] += map[i][j];
                if (board[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}